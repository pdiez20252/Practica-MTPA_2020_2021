package com.mycompany.mtpa.servidor;

//mover a la clase servidor y preguntar por los datos2
public class Partida {
    
    private String Nombre;
    private String Numsalon;
    //private String [] palabras = {"arbitro", "penalti", "pelota"};
    //

    public Partida(String Nombre, String Numsalon) {
        this.Nombre = Nombre;
        this.Numsalon = Numsalon;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNumsalon() {
        return Numsalon;
    }

    public void setNumsalon(String Numsalon) {
        this.Numsalon = Numsalon;
    }
}
