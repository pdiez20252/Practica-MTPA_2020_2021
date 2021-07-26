package com.mycompany.mtpa.servidor;

//mover a la clase servidor y preguntar por los datos2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PartidaServidor {
    
    private String Nombre;
    private String Numsalon;
    public ArrayList<String> palabrasDisponibles= new ArrayList<String>();
    private String[] palabras;
    private String[][] letras;
    private final int NUM_TANDAS = 3;
    private List<String> jugadores;
    private List<Integer> puntos;
// = {"arbitro", "penalti", "pelota"};
    //

    public PartidaServidor(String Nombre, String Numsalon) {
        this.Nombre = Nombre;
        this.Numsalon = Numsalon;
        this.palabras = new String[NUM_TANDAS];
        jugadores = new ArrayList();
        puntos = new ArrayList();
        this.rellenar();
         this.letras = new String[NUM_TANDAS][];
        for(int tanda=0; tanda < NUM_TANDAS; tanda++){
            this.palabras[tanda] = this.devolverPalabraAleatoria();
            this.letras[tanda] = this.devolverLetras(palabras[tanda]);

        }
        /**/ System.out.println(Arrays.toString(this.palabras));
    }

    public String getPalabra(int tanda){
        return palabras[tanda];
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
    
    public String [] getLetras(int tanda){
        return letras[tanda];
    }

    public void setNumsalon(String Numsalon) {
        this.Numsalon = Numsalon;
    }


    
    public void añadirPalabra(String palabra){
        palabrasDisponibles.add(palabra);
    }
    
    public String devolverPalabraAleatoria(){
        int posicion = new Random().nextInt(palabrasDisponibles.size());
        return palabrasDisponibles.remove(posicion);//eliminamos para no repetir
    }
    
    private String[] devolverLetras(String palabra){
        String [] letras = new String[palabra.length()];
        ArrayList<Character> desordenadas = new ArrayList(palabra.length());
        for(int i =0; i< palabra.length(); i++) desordenadas.add(palabra.charAt(i));
        
        desordenadas.sort(new Comparator<Character>(){
              public int compare(Character c, Character c1){
                  if(new Random().nextBoolean()) return -1;
                  return 1;
              }
        });
        for(int i =0; i< desordenadas.size(); i++){
            letras[i]= desordenadas.get(i).toString();
        }
        return letras;
    }

    void addJugador(String nombre) {
        this.jugadores.add(nombre);
        this.puntos.add(0);
    }

    String getJugadores() {
        String respuesta ="";
        for(int i =0; i< jugadores.size(); i++){
            respuesta+= jugadores.get(i)+"("+puntos.get(i)+"):";
        }
        return respuesta;
    }

    private void rellenar() {
        switch (Numsalon){
            case "0":
                palabrasDisponibles.add("arbitro");
                palabrasDisponibles.add("pelota");
                palabrasDisponibles.add("portero"); 
                palabrasDisponibles.add("liga");
                break;
                
            case "1":
                palabrasDisponibles.add("apple");
                palabrasDisponibles.add("amazon");
                palabrasDisponibles.add("microsoft"); 
                palabrasDisponibles.add("facebook");
                break;
            case "2":
                palabrasDisponibles.add("violeta");
                palabrasDisponibles.add("rojo");
                palabrasDisponibles.add("amarillo"); 
                palabrasDisponibles.add("turquesa");
                break;
            case "3":
            palabrasDisponibles.add("rinoceronte");
            palabrasDisponibles.add("leopardo");
            palabrasDisponibles.add("perro"); 
            palabrasDisponibles.add("tortuga");               
            break;
        }
    }

    void puntuar(String nombre) {
        for(int i =0;i< jugadores.size(); i++){
            if(jugadores.get(i).equals(nombre)){
                puntos.set(i, puntos.get(i)+1);
            }
        }
    }

    String calcularPuntuacion(String nombre) {
        for(int i =0;i< jugadores.size(); i++){
            if(jugadores.get(i).equals(nombre)){
                return ""+ puntos.get(i);
            }
        }
        return "";
    }

  


 
    
    
    
}
