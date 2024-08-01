//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Observable;

public class Capataz extends Observable implements Serializable, Comparable<Capataz> {
   
    private String nombre;
    private String cedula;
    private String direccion;
    private int anioIngreso;
    private Obra obra;
    
    public Capataz(String nombre, String cedula, String direccion, int anio){
        this.nombre=nombre;
        this.cedula=cedula;
        this.direccion=direccion; 
       this.anioIngreso=anio;
       
    }

    public Capataz() {
        this.nombre="Sin Nombre";
        this.cedula="sin cedula";
        this.direccion="";
        this.anioIngreso=0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        setChanged();
        notifyObservers();
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
        setChanged();
        notifyObservers();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
        setChanged();
        notifyObservers();
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
        setChanged();
        notifyObservers();
    }

    public void setObra(Obra obra) {
        this.obra = obra;
        setChanged();
        notifyObservers();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public Obra getObra() {
        return obra;
    }
    @Override
        public int compareTo(Capataz c1) {
           return this.cedula.compareTo(c1.cedula);
        }
    
    public static Comparator<Capataz> compararPorNombre = new Comparator<Capataz>() {
        @Override
        public int compare(Capataz c1, Capataz c2) {
            return c1.getNombre().compareTo(c2.getNombre());
        }
    };

    @Override
    public String toString() {
        return "Capataz{" + "nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + ", anioIngreso=" + anioIngreso + '}';
    }
    
}
