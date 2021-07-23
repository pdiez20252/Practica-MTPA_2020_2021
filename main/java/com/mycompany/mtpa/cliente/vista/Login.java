/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class Login extends JFrame{
    
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private Socket socketCliente;
    private PrintWriter salida;
    private Scanner entrada;

    public Login(){
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
    JPanel panel = new JPanel(new GridLayout(3,2));
    
    panel.add(new JLabel("Usuario:"));
    txtUsuario = new JTextField();
    txtUsuario.setColumns(20);
    panel.add(txtUsuario);
    txtPass= new JPasswordField();
    txtPass.setColumns(20);
    panel.add(new JLabel("Contraseña:"));
    panel.add(txtPass);
    JButton btnIniciarSesion = new JButton("Iniciar Sesión");
    btnIniciarSesion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            login();
        }
    });
    panel.add(btnIniciarSesion);
    JButton btnCrearCuenta = new JButton("Quiero una cuenta nueva");
    btnCrearCuenta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            new Registro().setVisible(true);
            setVisible(false);
            //registrar();
        }
    });
    panel.add(btnCrearCuenta);
    return panel;
 
}

private void login(){
    String usuario = txtUsuario.getText();
    String pass = txtPass.getText();
    if(usuario.isEmpty() || pass.isEmpty()){
        JOptionPane.showMessageDialog(null, "El usuario y la contraseña no pueden estar vacíos",  "Error",JOptionPane.ERROR_MESSAGE);

    }else{
        //protocolo login:usuario:pass
        String mensaje = "login:"+usuario+":"+pass+"\n";
        salida.write(mensaje);
        salida.flush();
        //leer la respuesta del servidor 
        String respuesta = entrada.nextLine();
        if(respuesta.equals("true")){
            new Salon().setVisible(true);
            setVisible(false);
                    //pasar a la ventana principal
        }else{
          JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidas",  "Error",JOptionPane.ERROR_MESSAGE);

        }
    }
}



    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}