package Servidor;

import java.util.ArrayList;

public class Principal {
    public static void main(String [] args){
        
        Usuario admin = new Usuario();
        Usuario admin2 = new Usuario();
        //guardar en arryalist
        /*Usuario admin2 = new UsuariosNormales();
        Usuario admin3 = new Usuario();
        Usuario admin4 = new Usuario();*/
        
        
        admin.registrar("a", "password", "mail");
        admin2.registrar("xd", "password", "mail");
        /*admin3.registrar("b", "apassword", "maail");
        admin4.registrar("c", "passmword", "mmail");
        Partida partida1 = new Partida(admin,admin2);*/

        
        admin.imprimirUsuarios();
        
        
        
    }
}
