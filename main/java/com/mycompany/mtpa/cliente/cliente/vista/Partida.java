package com.mycompany.mtpa.cliente.vista;

//mover a la clase servidor y preguntar por los datos2
public class Partida {
    
    private String Nombre;
    private int Numsalon;
    //private String [] palabras = {"arbitro", "penalti", "pelota"};
    //

    public Partida(String Nombre, int Numsalon) {
        this.Nombre = Nombre;
        this.Numsalon = Numsalon;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumsalon() {
        return Numsalon;
    }

    public void setNumsalon(int Numsalon) {
        this.Numsalon = Numsalon;
    }
}
