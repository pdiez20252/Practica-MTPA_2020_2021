package com.mycompany.mtpa.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class Servidor {
    
    private ServerSocket socketServidor;
    private HashMap<String,Usuario> usuarios;
    private ArrayList<Partida> lista = new ArrayList<Partida>();
    
    public Servidor(){
        try {
            socketServidor = new ServerSocket(1009);
            usuarios = new HashMap();
            System.out.println("Servidor a la escucha");
        } catch (IOException ex) {
            System.out.println("Puerto ocupado, imposible crear socket");
        }
    }
    
    
    private void escucha(){
        
        while(true){try {
            //mejor decidir cuando se termina?
            Socket conexion = socketServidor.accept();
            new Hilo(conexion, this).start();//le pasamos donde comunicarse y donde recoger datos
            } catch (IOException ex) {
                System.out.println("Error en la comunicación");
            }
        }
    }

    boolean login(String usuario, String pass) {
        Usuario target = usuarios.get(usuario);
        if(target == null){//no existe el usuario
            return false;
        }
        
        return target.verificarPass(pass);
    }
    
    public static void main(String[] args) {
        new Servidor().escucha();
    }

    boolean registro(String usuario, String pass) {
        System.out.println("Nombre que nos han pasado:"+ usuario);
        if(usuarios.containsKey(usuario) || pass.length()<4){
            return false;
        }
        usuarios.put(usuario, new Usuario(usuario, pass));
        return true;
    }
    
    boolean crearPartida(String nombrePartida, String sala){  
        Partida partida = new Partida(nombrePartida, sala); //crear partida con el nombre que el usuario le pase y la sala actual
        lista.add(partida);
        /*for(int i=0; i<=lista.size();i++){
        System.out.println(""+ lista.get(i).getNombre()+lista.get(i).getNumsalon());}*/
        return true;
    }
    String mostrar(String vuelta){
        int i = Integer.parseInt(vuelta);
        return lista.get(i).getNombre()+":"+lista.get(i).getNumsalon(); 
    }
    int tamanoLista(){
    return lista.size();
    }
         
            }
    
    
    
