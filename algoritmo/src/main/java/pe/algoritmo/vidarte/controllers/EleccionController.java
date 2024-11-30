package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class EleccionController {
    
    private CSV<Eleccion> csv;

    public EleccionController(){
        this.csv = new CSV<>(Eleccion.class);
    }

    public boolean registrar(Eleccion e){
        int id = this.csv.obtenerIdMaximo() + 1;
        e.setId(id);
        return this.csv.registrar(e);
    }

    public Lista<Eleccion> getElecciones(){
        return this.csv.leerCSV();
    }

    public Lista<String> getNombresElecciones(){
        Lista<Eleccion> lista = getElecciones();
        Lista<String> nombres = new Lista<>();
        for (Eleccion e : lista){
            nombres.agregarAlFinal(e.getTitulo() + " - " + e.getAnio());
        }
        return nombres;
    }

    public Eleccion getEleccionById(int id){
        Lista<Eleccion> lista = getElecciones();
        for (Eleccion e : lista){
            if (e.getId() == id) { return e; }
        }
        return null;
    }

    public boolean eliminarById(int id){
        return this.csv.eliminarPorId(id);
    }

    public boolean actualizarById(int id, Eleccion e){
        return this.csv.actualizarPorId(id, e);
    }
}
