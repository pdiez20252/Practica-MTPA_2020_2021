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

    Usuario(String usuario, String pass) {
        this.pass = pass;
        this.usuario = usuario;
    }
    
    
    boolean verificarPass(String pass) {
           return this.pass.equals(pass);
    }
    
}