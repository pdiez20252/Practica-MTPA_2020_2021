/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mtpa.servidor;

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
public class Hilo extends Thread {

    private Socket conexion;
    private Servidor serv;
        private PrintWriter salida;
    private Scanner entrada;
    
    Hilo(Socket conexion, Servidor serv) {
        this.conexion = conexion;
        this.serv = serv;
    }

    @Override
    public void run() {
        try {
            boolean seguir = true;
            salida = new PrintWriter(conexion.getOutputStream());
            entrada = new Scanner(conexion.getInputStream());
            while(seguir){
                String mensaje = entrada.nextLine();
                String[] comando = mensaje.split(":");
                boolean aceptado= false;
                switch(comando[0]){
                    case "login":
                         aceptado = serv.login(comando[1], comando[2]);
                        salida.write(""+aceptado+"\n");
                        salida.flush();
                        break;
                    case "registro":
                        aceptado = serv.registro(comando[1], comando[2]);
                        salida.write(""+aceptado+"\n");
                        salida.flush();
                        break;
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
