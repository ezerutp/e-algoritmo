package pe.algoritmo.vidarte.controllers;

import java.util.List;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Eleccion;

public class EleccionController {
    
    private CSV<Eleccion> csv;

    public EleccionController(){
        this.csv = new CSV<>(Eleccion.class);
    }

    public List<Eleccion> getEleccion(){
        return this.csv.leerCSV();
    }

    public Eleccion getEleccionById(int id){
        List<Eleccion> lista = getEleccion();
        for (Eleccion e : lista){
            if (e.getId() == id) { return e; }
        }
        return null;
    }
}
