/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mtpa.servidor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.fail;

/**
 *
 * @author Pablo
 */
public class PartidaServidorTest {
    
    public PartidaServidorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //Test de SetNumsalon de la clase Servidor
    @Test
    public void testDevolverPalabraAleatoria() {
        System.out.println("devolverPalabraAleatoria");
        PartidaServidor instance = null;
        String expResult = "";
        String result = instance.devolverPalabraAleatoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    //Test de CalcularPuntuacion de la clase Servidor
    @Test
    public void testCalcularPuntuacion() {
        System.out.println("calcularPuntuacion");
        String nombre = "uhuih";
        PartidaServidor instance = null;
        String expResult = "";
        String result = instance.calcularPuntuacion(nombre);
        assertEquals(expResult, result);
        if(result != expResult){ 
            fail("El resultado esperado no es correcto");}
    }
    //Test de GetJugadores de la clase Servidor
    @Test
    public void testGetJugadores() {
        System.out.println("getJugadores");
        PartidaServidor instance = null;
        String expResult = "";
        String result = instance.getJugadores();
        assertEquals(expResult, result);
                if(result != expResult){ 
            fail("El resultado esperado no es correcto");}
    }
    
}
