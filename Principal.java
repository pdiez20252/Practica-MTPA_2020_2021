package Servidor;

public class Principal {
    public static void main(String [] args){
        
        Usuario admin = new Usuario();
        Usuario admin2 = new Usuario();
        Usuario admin3 = new Usuario();
        Usuario admin4 = new Usuario();
        admin.registrar("a", "password", "mail");
        admin2.registrar("x", "password", "mail");
        admin3.registrar("b", "apassword", "maail");
        admin4.registrar("c", "passmword", "mmail");
        
        admin.imprimirUsuarios();
        
    }
}
