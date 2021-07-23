package com.mycompany.mtpa.cliente.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Registro extends JFrame{
    
    private JTextField txtMail;
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private Socket socketCliente;
    private PrintWriter salida;
    private Scanner entrada;

    public Registro(){
        super();
        try {
            socketCliente = new Socket("localhost", 1009);
            salida = new PrintWriter(socketCliente.getOutputStream());
            entrada = new Scanner(socketCliente.getInputStream());
            this.setContentPane(panelPrincipal());
            pack();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Servidor no conectado",  "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

private JPanel panelPrincipal(){
    JPanel panel = new JPanel(new GridLayout(4,0));
    
    panel.add(new JLabel("Usuario:"));
    txtUsuario = new JTextField();
    txtUsuario.setColumns(20);
    panel.add(txtUsuario);
    txtPass= new JPasswordField();
    txtPass.setColumns(20);
    panel.add(new JLabel("Contraseña:"));
    panel.add(txtPass);
    panel.add(new JLabel("Mail:"));
    txtMail = new JTextField();
    txtMail.setColumns(20);
    panel.add(txtMail);
    JButton btnCrearCuenta = new JButton("Registrar");
    btnCrearCuenta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            registrar();
        }
    });
    panel.add(btnCrearCuenta);
    return panel;
 
}
private void registrar(){
      String usuario = txtUsuario.getText();
      String pass = txtPass.getText();
      String mail = txtMail.getText();
    if(usuario.isEmpty() || pass.isEmpty()  || mail.isEmpty()){
        JOptionPane.showMessageDialog(null, "Porfavor rellene todos los datos",  "Error",JOptionPane.ERROR_MESSAGE);
    }else{
        //protocolo login:usuario:pass:mail, enviar los datos al servidor
        String mensaje = "registro:"+usuario+":"+pass+":"+mail+"\n";
        salida.write(mensaje);
        salida.flush();
        //leer la respuesta del servidor 
        String respuesta = entrada.nextLine();
        if(respuesta.equals("true")){
            JOptionPane.showMessageDialog(null, "Registro efectuado con éxito", "Registro", JOptionPane.INFORMATION_MESSAGE);
            new Login().setVisible(true);
            setVisible(false);
        }else{
          JOptionPane.showMessageDialog(null, "Registro no válido, usuario o correo ya registrados o contraseña demasiado corta (Mínimo 3 caracteres)",  "Error",JOptionPane.ERROR_MESSAGE);

        }
    }
}

}