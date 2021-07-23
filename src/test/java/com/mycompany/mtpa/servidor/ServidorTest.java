/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mtpa.servidor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pablo
 */
public class ServidorTest {
    
    public ServidorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    //Test del método login, clase Servidor.
      @Test
    public void testLogin() {
        System.out.println("login");
        String usuario = "Pablo";
        String pass = "123456";
        Servidor instance = new Servidor();
        boolean ResultEsp = false;
        boolean resultado = instance.login(usuario, pass);
        assertEquals(ResultEsp, resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    //Test del método Main, clase Servidor.
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Servidor.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    //Test del método registro, clase Servidor.
    @Test
    public void testRegistro() {
        System.out.println("registro");
        String usuario = "Pablo";
        String pass = "123456";
        Servidor instance = new Servidor();
        boolean ResultEsp = true;
        boolean resultado = instance.registro(usuario, pass);
        assertEquals(ResultEsp, resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    
}
