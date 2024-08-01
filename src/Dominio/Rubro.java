//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.Serializable;
import java.util.Observable;

public class Rubro extends Observable implements Serializable{
    private String nombre;
    private String descripcion;
    
    public Rubro(){
        this.nombre="Sin nombre";
    }
    public Rubro(String unNombre, String unaDescripcion){
        this.nombre= unNombre;
        this.descripcion=unaDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        setChanged();
        notifyObservers();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Rubro{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}

