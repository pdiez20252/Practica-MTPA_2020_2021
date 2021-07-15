package Servidor;

import java.util.Random;

public class Futbol 
        extends Salon {
    
    //se puede meter en clase padre
    @Override
    public String getPalabraRandom() {
        String [] palabras  = {"arbitro", "penalti", "pelotan"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        String  palabra = palabras[n];
        return palabra;
    }
        
}
