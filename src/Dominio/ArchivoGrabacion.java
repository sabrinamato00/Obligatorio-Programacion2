//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class ArchivoGrabacion {
    private Formatter out;
    
    //Creacion del archivo
    public ArchivoGrabacion(String unNombre){
        try{
            out = new Formatter(unNombre);
        }catch(FileNotFoundException e){
            System.out.println("Error: no se puede crear");
            System.exit(1);
        }
    }
    public void grabarLinea(String linea){
        out.format("%s%n", linea);
    }
    public void cerrar(){
        out.close();
    }
}
