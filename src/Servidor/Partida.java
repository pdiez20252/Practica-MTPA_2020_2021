package Servidor;

import java.util.ArrayList;

public class Partida {
    //nombre de la partida??
    private Usuario admin;
    private static ArrayList<Usuario> UsuariosNormales = new ArrayList<>();
   
    public Partida(){};
    public Partida(Usuario admin, ArrayList<Usuario> UsuariosNormales) {
        this.admin = admin;
        this.UsuariosNormales = UsuariosNormales; 
    }

    
    /**********/
    
    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public static ArrayList<Usuario> getUsuariosNormales() {
        return UsuariosNormales;
    }

    public static void setUsuariosNormales(ArrayList<Usuario> aUsuariosNormales) {
        UsuariosNormales = aUsuariosNormales;
    }
    
    /************/
    
}
