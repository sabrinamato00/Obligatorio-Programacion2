//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Observable;

public class Propietario extends Observable implements Serializable, Comparable<Propietario>{

    private String nombre;
    private String cedula;
    private String direccion;
    private int celular;
    private Obra obra;

    public Propietario(String nombre, String cedula, String direccion, int celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.celular = celular;
    }

    public Propietario() {
        this.nombre = "Sin nombre";
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

    public int getCelular() {
        return celular;
    }

    public Obra getObra() {
        return obra;
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

    public void setCelular(int celular) {
        this.celular = celular;
        setChanged();
        notifyObservers();
    }

    public void setObra(Obra obra) {
        this.obra = obra;
        setChanged();
        notifyObservers();
    }
      @Override
    public int compareTo(Propietario otroPropietario) {
        return this.cedula.compareTo(otroPropietario.cedula);
    }

    public static Comparator<Propietario> compararPorNombre = new Comparator<Propietario>() {
        @Override
        public int compare(Propietario p1, Propietario p2) {
            return p1.getNombre().compareTo(p2.getNombre());
        }
    };

    @Override
    public String toString() {
        return "Propietario{" + "nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + ", celular=" + celular + '}';
    }
    
    
}
