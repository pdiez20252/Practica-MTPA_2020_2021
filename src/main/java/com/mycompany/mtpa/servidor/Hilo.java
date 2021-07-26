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
    private  PartidaServidor partidaEnCurso;
    private int tanda;
    
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
                String cadena;
                int tamanoLista;
                switch(comando[0]){
                    case "login":
                         aceptado = serv.login(comando[1], comando[2]);
                        salida.write(""+aceptado+"\n");
                        salida.flush();
                        break;
                    case "registro":
                        aceptado = serv.registro(comando[1], comando[2], comando[3]);
                        salida.write(""+aceptado+"\n");
                        salida.flush();
                        break;
                   case "crearPartida":
                        aceptado = serv.crearPartida(comando[1],comando[2]);
                        salida.write(""+aceptado+"\n");
                        salida.flush(); 
                        break;
                   case "mostrar":
              
                        cadena = serv.mostrar(comando[1]);
                        salida.write(cadena+"\n");
                        salida.flush(); 
                        break; 
                   case "unirse":
                       //unirse:partida:sala:usuario
                         partidaEnCurso = serv.buscarPartida(comando[1],comando[2]);
                        
                        if(partidaEnCurso == null){
                            salida.write("false\n");
                        }else{
                            partidaEnCurso.addJugador(comando[3]);
                            tanda=1;
                            String l = "";
                            for(String c: partidaEnCurso.getLetras(1)){
                                l += c;
                            }
                            //nombre:letras:nTanda
                            salida.write(partidaEnCurso.getNombre()+":"+l+":"+tanda+"\n"); 
                        }
                       
                        salida.flush(); 
                       break;
                   case "nuevaPartida":
                      //nuevaPartida:usuario:salatanda:partida:tanda
                       PartidaServidor nueva = serv.buscarPartida(comando[3], comando[2]);
                       String l1 = "";
                            for(String c: nueva.getLetras(Integer.valueOf(comando[4]))){
                                l1 += c;
                       }
                       cadena =l1+":"+nueva.getJugadores()+"\n";
                       salida.write(cadena);
                       salida.flush();
                       break;
                   case "partidaFinalizada":
                        //partidaFinalizada:usuario:sala:partida
                        PartidaServidor partida1 = serv.buscarPartida(comando[3], comando[2]);
                        String puntuacion = partida1.calcularPuntuacion(comando[1]);
                       break;
                   case "resolver":
                       //resolver:usuario:sala:partida:palabra:tanda
                       PartidaServidor partida = serv.buscarPartida(comando[3], comando[2]);
                       if(comando[4].equals(partida.getPalabra(Integer.valueOf(comando[5])))){
                           Usuario actual = serv.buscarUsuario(comando[1]);
                           actual.victoria();
                           partida.puntuar(comando[1]);
                           salida.write("true\n");

                       }else{
                           salida.write("false\n");
                       }
                       
                       salida.flush();
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}