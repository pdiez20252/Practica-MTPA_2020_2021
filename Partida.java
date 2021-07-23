package com.mycompany.mtpa.cliente.vista;

//mover a la clase servidor y preguntar por los datos2
public class Partida {
    
    private String Nombre;
    //private String [] palabras = {"arbitro", "penalti", "pelota"};
    //

    public Partida(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
