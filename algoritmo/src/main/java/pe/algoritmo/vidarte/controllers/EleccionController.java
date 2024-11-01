package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.utils.Lista;

public class EleccionController {
    
    private CSV<Eleccion> csv;

    public EleccionController(){
        this.csv = new CSV<>(Eleccion.class);
    }

    public Lista<Eleccion> getEleccion(){
        return this.csv.leerCSV();
    }

    public Eleccion getEleccionById(int id){
        Lista<Eleccion> lista = getEleccion();
        for (Eleccion e : lista){
            if (e.getId() == id) { return e; }
        }
        return null;
    }
}
