//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Obra extends Observable implements Serializable {

    private Propietario propietario;
    private Capataz capataz;
    private int numPermiso;
    private String direccion;
    private String mesAñoComienzo;
    private int presupuesto;
    private HashMap<String, Integer> rubrosPresupuestados;
    private HashMap<Gasto, Integer> gastos;

    public Obra(Propietario propietario, Capataz capataz, int numPermiso, String direccion, String mesAñoComienzo, int presupuesto, HashMap<String, Integer> rubrosPresupuestados) {
        this.propietario = propietario;
        this.capataz = capataz;
        this.numPermiso = numPermiso;
        this.direccion = direccion;
        this.mesAñoComienzo = mesAñoComienzo;
        this.presupuesto = presupuesto;
        this.rubrosPresupuestados = rubrosPresupuestados;
    }

    public Obra() {
        this.numPermiso = 0;
    }

    public Obra(int unNumPermiso) {
        this.numPermiso = unNumPermiso;
        this.gastos = new HashMap<>();
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Capataz getCapataz() {
        return capataz;
    }

    public int getNumPermiso() {
        return numPermiso;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMesAñoComienzo() {
        return mesAñoComienzo;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public HashMap<String, Integer> getRubrosPresupuestados() {
        return rubrosPresupuestados;
    }

    public HashMap<Gasto, Integer> getGastos() {
        return gastos;
    }

    public void setPropietario(Propietario unPropietario) {
        this.propietario = unPropietario;
        setChanged();
        notifyObservers();
    }

    public void setCapataz(Capataz unCapataz) {
        this.capataz = unCapataz;
        setChanged();
        notifyObservers();
    }

    public void setNumPermiso(int numPermiso) {
        this.numPermiso = numPermiso;
        setChanged();
        notifyObservers();
    }

    public void setDireccion(String unaDireccion) {
        this.direccion = unaDireccion;
        setChanged();
        notifyObservers();
    }

    public void setMesAñoComienzo(String unaFecha) {
        this.mesAñoComienzo = unaFecha;
        setChanged();
        notifyObservers();
    }

    public void setPresupuesto(int unPresupuesto) {
        this.presupuesto = unPresupuesto;
        setChanged();
        notifyObservers();
    }

    public void setRubrosPresupuestados(HashMap<String, Integer> rubrosPresupuestados) {
        this.rubrosPresupuestados = rubrosPresupuestados;
        setChanged();
        notifyObservers();
    }

    public String[] arrayRubrosPresupestados() {
        String[] rubros = new String[this.rubrosPresupuestados.size()];
        int i = 0;
        for (HashMap.Entry<String, Integer> entry : this.rubrosPresupuestados.entrySet()) {
            rubros[i] = entry.getKey() + " $" + entry.getValue();
            i++;
        }
        return rubros;

    }

    public void agregarGasto(Gasto gasto) {
        if (gastos == null) {
            gastos = new HashMap<>(); 
        }
        int numero = gastos.size() + 1; 
        gasto.setNumero(numero);
        gastos.put(gasto, numero);
    }

    public Integer obtenerNumeroGasto(Gasto gasto) {
        return gastos.get(gasto);
    }

    @Override
    public String toString() {
        return "Obra{" + "propietario=" + propietario + ", capataz=" + capataz + ", numPermiso=" + numPermiso + ", direccion=" + direccion + ", mesA\u00f1oComienzo=" + mesAñoComienzo + ", presupuesto=" + presupuesto + " Rubros presupuestados: " + rubrosPresupuestados + '}';
    }

}
