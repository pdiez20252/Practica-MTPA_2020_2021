package com.mycompany.mtpa.servidor;

import static org.testng.Assert.*;

/**
 *
 * @author Pablo
 */
public class ServidorTest {
    
    public ServidorTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    //Test del método Login de la clase Servidor
    @org.testng.annotations.Test
    public void testLogin() {
        System.out.println("login");
        String usuario = "Pablo";
        String pass = "1234567890";
        Servidor instance = new Servidor();
        boolean expResult = false;
        boolean result = instance.login(usuario, pass);
        assertEquals(result, expResult);
        if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }

    // Test del método registro de la clase Servidor
    @org.testng.annotations.Test
    public void testRegistro() {
        System.out.println("registro");
        String usuario = "Pablo";
        String pass = "1234567890";
        String mail = "pablo@test.com";
        Servidor instance = new Servidor();
        boolean expResult = true;
        boolean result = instance.registro(usuario, pass, mail);
        assertEquals(result, expResult);
       if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }

    // Test del método CrearPartida de la clase Servidor
    @org.testng.annotations.Test
    public void testCrearPartida() {
        System.out.println("crearPartida");
        String nombrePartida = "#hola";
        String sala = "1";
        Servidor instance = new Servidor();
        boolean expResult = false;
        boolean result = instance.crearPartida(nombrePartida, sala);
        assertEquals(result, expResult);
        if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }

    //Test de método mostrar de la clase Servidor
    @org.testng.annotations.Test
    public void testMostrar() {
        System.out.println("mostrar");
        String sala = "2";
        Servidor instance = new Servidor();
        String expResult = "#test";
        String result = instance.mostrar(sala);
        assertEquals(result, expResult);
        if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }

    //Test de método BuscarUsuario de la clase Servidor
    @org.testng.annotations.Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        String usuario = "fasmmfaska";
        Servidor instance = new Servidor();
        Usuario expResult = null;
        Usuario result = instance.buscarUsuario(usuario);
        assertEquals(result, expResult);
        if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }

    //Test de método BuscarPartida de la clase Servidor
    @org.testng.annotations.Test
    public void testBuscarPartida() {
        System.out.println("buscarPartida");
        String nombrePartida = "#Test";
        String salaactual = "2";
        Servidor instance = new Servidor();
        PartidaServidor expResult = null;
        PartidaServidor result = instance.buscarPartida(nombrePartida, salaactual);
        assertEquals(result, expResult);
        if(result != expResult){ 
        fail("El resultado esperado no es correcto");}
    }
    
}
