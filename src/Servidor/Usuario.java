package Servidor;

import java.util.ArrayList;

public class Usuario {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    private String nombre;
    private String password;
    private String mail;
    private boolean admin;
	
    /****************************/

    public Usuario(){
    }
    
    public Usuario(String nombre, String password, String mail){
        this.nombre = nombre;
        this.password = password;
        this.mail = mail;
    }
    
    /****************************/
	
	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		Usuario.listaUsuarios = listaUsuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}    
        
        	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
 
	/****************************/
  
        public static int verificarUsuario(String nombre, String password, String mail){
        Usuario usuario;
        int a = 0;
            for(int i=0; i<getListaUsuarios().size();i++){
                if(getListaUsuarios().get(i).getNombre().equals(nombre) || getListaUsuarios().get(i).getMail().equals(mail)){
                return 1;
                }}
            return 0;
        }
        public void registrar(String nombre, String password, String mail){
                    int a = verificarUsuario(nombre, password, mail);
                    if(a==0){
                    Usuario.getListaUsuarios().add(new Usuario(nombre, password,mail));
            }
            }
        
        /* TEST */
        public void imprimirUsuarios(){
        for(int i = 0; i<getListaUsuarios().size(); i++) {
            System.out.println("Usuario: "+ getListaUsuarios().get(i).nombre+ " Contraseña:"+ getListaUsuarios().get(i).password+" Mail: "+getListaUsuarios().get(i).mail);
        } 
    }
        
}
