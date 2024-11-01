package pe.algoritmo.vidarte.controllers;

import java.util.List;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Distrito;

public class DistritoController {
    
    private CSV<Distrito> csv;

    public DistritoController(){
        this.csv = new CSV<>(Distrito.class);
    }

    public List<Distrito> getDistritos(){
        return this.csv.leerCSV();
    }

    public Distrito getDistritoById(int id){
        List<Distrito> lista = getDistritos();
        for (Distrito d : lista){
            if (d.getId() == id) { return d; }
        }
        return null;
    }
    
}
