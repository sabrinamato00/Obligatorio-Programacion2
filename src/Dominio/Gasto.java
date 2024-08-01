//Sabrina Mato(222071) y Pamela Quesada(171498)

package Dominio;

import java.io.Serializable;
import java.util.Observable;

public class Gasto extends Observable implements Serializable{
    private int numero;
    private Obra obra;
    private Rubro rubro;
    private boolean pago;
    private int monto;
    private int mes;
    private int anio;
    private String descripcion;

    public Gasto() {
        this.descripcion="Sin descripcion";
        this.pago = false;
    }
    public Gasto(Obra obra, Rubro rubro, int monto, int mes, int año, String descripcion) {
        this.obra = obra;
        this.rubro = rubro;
        this.monto = monto;
        this.mes = mes;
        this.anio = año;
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public Obra getObra() {
        return obra;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    

    public int getMonto() {
        return monto;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        setChanged();
        notifyObservers();
    }

    public void setObra(Obra obra) {
        this.obra = obra;
        setChanged();
        notifyObservers();
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
        setChanged();
        notifyObservers();
    }

    public void setMonto(int monto) {
        this.monto = monto;
        setChanged();
        notifyObservers();
    }

    public void setMes(int mes) {
        this.mes = mes;
        setChanged();
        notifyObservers();
    }

    public void setAño(int año) {
        this.anio = año;
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
        return "No."+this.getNumero()+" de " + this.getMes()+"/"+this.getAnio()+" "+ this.descripcion+" $"+this.monto;
    }
}