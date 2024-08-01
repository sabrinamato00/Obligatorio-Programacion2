//Sabrina Mato(222071) y Pamela Quesada(171498)
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Rubro> listaRubros;
    private ArrayList<Capataz> listaCapataces;
    private ArrayList<Propietario> listaPropietarios;
    private ArrayList<Obra> listaObras;
    private ArrayList<Gasto> listaGastos;

    public Sistema() {
        this.listaRubros = new ArrayList<>();
        this.listaCapataces = new ArrayList<>();
        this.listaPropietarios = new ArrayList<>();
        this.listaObras = new ArrayList<>();
        this.listaGastos = new ArrayList<>();
    }
//-----------------Getters-----------------

    public ArrayList<Rubro> getListaRubros() {
        return this.listaRubros;
    }

    public ArrayList<Capataz> getListaCapataces() {
        return this.listaCapataces;
    }

    public ArrayList<Propietario> getListaPropietarios() {
        return this.listaPropietarios;
    }

    public ArrayList<Obra> getListaObras() {
        return this.listaObras;
    }

    public ArrayList<Gasto> getListaGastos() {
        return this.listaGastos;
    }
//-----------------Setters-----------------

    public void setListaRubros(ArrayList<Rubro> listaRubros) {
        this.listaRubros = listaRubros;
        setChanged();
        notifyObservers();
    }

    public void setListaCapataces(ArrayList<Capataz> listaCapataces) {
        this.listaCapataces = listaCapataces;
        setChanged();
        notifyObservers();
    }

    public void setListaPropietario(ArrayList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
        setChanged();
        notifyObservers();
    }

    public void setListaObras(ArrayList<Obra> listaObras) {
        this.listaObras = listaObras;
        setChanged();
        notifyObservers();
    }

    public void setListaGastos(ArrayList<Gasto> listaGastos) {
        this.listaGastos = listaGastos;
        setChanged();
        notifyObservers();
    }
    //-----------------Agregar-----------------

    public void agregarCapataz(Capataz unCapataz) {
        this.getListaCapataces().add(unCapataz);
        setChanged();
        notifyObservers(unCapataz);
    }

    public void agregarRubro(Rubro unRubro) {
        this.getListaRubros().add(unRubro);
        setChanged();
        notifyObservers(unRubro);
    }

    public void agregarPropietario(Propietario unProp) {
        this.listaPropietarios.add(unProp);
        setChanged();
        notifyObservers(unProp);
    }

    public void agregarObra(Obra unaObra) {
        this.listaObras.add(unaObra);
        setChanged();
        notifyObservers(unaObra);
    }
    
        public void agregarGastoPorObra(Gasto gasto) {
        Obra obra = gasto.getObra();
        if (obra != null) {
            obra.agregarGasto(gasto);
            listaGastos.add(gasto);
        } else {
            throw new IllegalArgumentException("Obra no encontrada");
        }
        setChanged();
        notifyObservers(gasto);
    } 
    
//-----------------Metodos-----------------

    public String darDescripcionDeRubro(String unNombre) {
        String descripcion = "";
        for (Rubro r : this.listaRubros) {
            if (r.getNombre().equalsIgnoreCase(unNombre)) {
                descripcion = r.getDescripcion();
            }
        }
        return descripcion;
    }

    public Rubro darRubro(String nombre) {
        Rubro rubro = new Rubro();
        for (Rubro r : this.listaRubros) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                rubro = r;
            }
        }
        return rubro;
    }
    
    public Propietario darPropietario(String unaCedula) {
        Propietario propietario = new Propietario();
        for (Propietario p : this.listaPropietarios) {
            if (p.getCedula().equals(unaCedula)) {
                propietario = p;
            }
        }
        return propietario;
    }
    
    public Capataz darCapataz(String unaCedula) {
        Capataz capataz = new Capataz();
        for (Capataz c : this.listaCapataces) {
            if (c.getCedula().equals(unaCedula)) {
                capataz = c;
            }
        }
        return capataz;
    }
    
    public Obra darObra(int numObra) {
        Obra obra = new Obra();
        for (Obra o : listaObras) {
            if (o.getNumPermiso() == numObra) {
                obra = o;
            }
        }
        return obra;
    }

    public Gasto darGasto(int num) {
        Gasto gasto = new Gasto();
        for (Gasto g : this.listaGastos) {
            if (g.getNumero() == num) {
                gasto = g;
            }
        }
        return gasto;
    }

    public String[] obtenerNombresRubros() {
        String[] rubros = new String[this.listaRubros.size()];
        for (int i = 0; i < rubros.length; i++) {
            rubros[i] = listaRubros.get(i).getNombre();
        }
        return rubros;
    }
    
    public String[] arrayPropietarios() {
        String[] arrayPropietarios = new String[this.getListaPropietarios().size()];
        for (int i = 0; i < this.getListaPropietarios().size(); i++) {
            Propietario p = listaPropietarios.get(i);
            String propietario = p.getNombre() + "(" + p.getCedula() + ")";
            arrayPropietarios[i] = propietario;
        }
        System.out.println(Arrays.toString(arrayPropietarios));
        return arrayPropietarios;
    }
    
    public String[] arrayCapataces() {
        String[] arrayCapataces = new String[this.getListaCapataces().size()];
        for (int i = 0; i < this.getListaCapataces().size(); i++) {
            Capataz c = listaCapataces.get(i);
            String capataz = c.getNombre() + "(" + c.getCedula() + ")";
            arrayCapataces[i] = capataz;
        }
        return arrayCapataces;
    }

    public String[] arrayObras() {
        String[] arrayObras = new String[this.getListaObras().size()];
        for (int i = 0; i < this.getListaObras().size(); i++) {
            Obra o = listaObras.get(i);
            String obra = o.getNumPermiso() + "-" + o.getDireccion();
            arrayObras[i] = obra;
        }
        return arrayObras;
    }


    public boolean existeCapataz(String cedula) {
        for (Capataz c : this.listaCapataces) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return true;
            }
        }
        return false;
    }

    public boolean existePropietario(String cedula) {
        for (Propietario p : this.listaPropietarios) {
            if (p.getCedula().equalsIgnoreCase(cedula)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeRubro(String nombreRubro) {
        for (Rubro r : this.listaRubros) {
            if (r.getNombre().equalsIgnoreCase(nombreRubro)) {
                return true;
            }
        }
        return false;
    }

    public boolean existePermisoObra(int numPermiso) {
        for (Obra o : this.listaObras) {
            if (o.getNumPermiso() == numPermiso) {
                return true;
            }
        }
        return false;
    }

    public void modificarDescripRubro(String unNombre, String unaDescripcion) {
        for (Rubro r : this.listaRubros) {
            if (r.getNombre().equalsIgnoreCase(unNombre)) {
                r.setDescripcion(unaDescripcion);
            }
        }
    }
    
    public ArrayList<Gasto> gastosImpagosObra(int numObra) {
        ArrayList<Gasto> gastosImpagos = new ArrayList<>();
        for (Gasto g : this.listaGastos) {
            if (!g.isPago() && g.getObra().getNumPermiso() == numObra) {
                gastosImpagos.add(g);
            }
        }
        return gastosImpagos;
    }

    public String[] rubrosConGastosEnObra(Obra obra) {
        ArrayList<Rubro> rubrosConGastosEnObra = new ArrayList<>();
        for (Gasto g : this.listaGastos) {
            if (g.getObra() == obra && !rubrosConGastosEnObra.contains(g.getRubro())) {
                rubrosConGastosEnObra.add(g.getRubro());
            }
        }
        String[] arrayRubros = new String[rubrosConGastosEnObra.size()];
        for (int i = 0; i < arrayRubros.length; i++) {
            arrayRubros[i] = rubrosConGastosEnObra.get(i).getNombre();
        }
        return arrayRubros;
        
    }

    public ArrayList<Gasto> gastosRubroSeleccionado(Obra obra, Rubro rubro) {
        ArrayList<Gasto> gastos = new ArrayList<>();
        for (Gasto g : this.listaGastos) {
            if (g.getRubro() == rubro && g.getObra() == obra) {
                gastos.add(g);
            }
        }
        String[] gastosRubroSeleccionado = new String[gastos.size()];
        for (int i = 0; i < gastosRubroSeleccionado.length; i++) {
            gastosRubroSeleccionado[i] = gastos.get(i) + "";
        }
        return gastos;
    }

    public int totalGastado(Obra obra) {
        int total = 0;
        for (Gasto g : this.listaGastos) {
            if (g.getObra() == obra) {
                total += g.getMonto();
            }
        }
        return total;
    }

    public int totalGastadoReintegrado(Obra obra) {
        int total = 0;
        for (Gasto g : this.listaGastos) {
            if (g.isPago() && g.getObra() == obra) {
                total += g.getMonto();
            }
        }
        return total;
    }
    
  
    
    
    public void reintegrarGasto(Gasto gasto) {
        gasto.setPago(true);
        setChanged();
        notifyObservers(gasto);
    }
}
