//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArchivoLectura {
    private Scanner in;
    private String linea;
    //Apertura de un archivo 
    public ArchivoLectura(String unNombre){
        try{
            in= new Scanner (Paths.get(unNombre));
        } catch(IOException e){
            System.err.println("Error de apertura");
            System.exit(1);
        }
    }
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if (in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    //Retorna la linea actual(ultima linea leida):
    public String linea(){
        return linea;
    }
    public void cerrar(){
        in.close();
    }
}
