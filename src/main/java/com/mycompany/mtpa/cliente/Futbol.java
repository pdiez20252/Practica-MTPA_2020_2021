package com.mycompany.mtpa.cliente;



import java.util.Random;

public class Futbol extends Salon {
    private String hashtag;
    private static int contador;
    private String [] palabras = {"arbitro", "penalti", "pelotan"};
    //private String palabraCustom;
    
    
    //se puede meter en clase padre??
    public String getPalabraRandom() {
        Random r = new Random();
        int n = r.nextInt(palabras.length); //
        String  palabra = palabras[n];
        return palabra;
    }
    public void setPalabrasRandom(String palabraCustom){
        palabras[palabras.length] = palabraCustom; 
    }
    
    
    @Override
    public int comprobarLetra() { // es más de la funcionalidad, hay que revisarlo
        //de la palabra que ha generado aleatoriamente, la recorremos con la letra que
        //nos hayan metido
        return 1;
    }
    
    public static int contador(){
        contador++;
        return contador;
    }
    
    //en la clase Padre mejor
    public void CrearPartidas(String hashtag){
        int contador = contador();
  //      Partida partida = new Partida(); //el contador o hacer un array de partidas e irlas llenando poco a poco
   //     partida.CrearPartida(hashtag,getPalabraRandom());
    }
    
        
}