/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mtpa.servidor;

/**
 *
 * @author Pablo
 */
public class Usuario {

    
    private String pass;
    private String usuario;
    private String mail;
    private int puntuacion;

    Usuario(String usuario, String pass, String mail) {
        this.pass = pass;
        this.usuario = usuario;
        this.mail = mail;
        this.puntuacion =0;
        
    }
    
    public void victoria(){
        puntuacion++;
    }
    
    boolean verificarPass(String pass) {
           return this.pass.equals(pass);
    }
    
}