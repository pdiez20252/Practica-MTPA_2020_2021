/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mtpa.cliente.cliente;

import com.mycompany.mtpa.servidor.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class ComunicacionUsuario {
    
    private String nombre;
    private Socket socket;
    private PrintWriter salida;
    private Scanner entrada;
    
    public ComunicacionUsuario(String nombre, Socket socket) {
        try {
            this.nombre = nombre;
            this.socket = socket;
            salida = new PrintWriter(socket.getOutputStream());
            entrada = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ComunicacionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mandarMensaje(String mensaje){
        salida.write(mensaje);
        salida.write("\n");
        salida.flush();
    }
    
    public String recibirMensaje(){
        return entrada.nextLine();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
}
