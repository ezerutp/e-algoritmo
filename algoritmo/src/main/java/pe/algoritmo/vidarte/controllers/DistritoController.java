package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.utils.Lista;

public class DistritoController {
    
    private CSV<Distrito> csv;

    public DistritoController(){
        this.csv = new CSV<>(Distrito.class);
    }

    public Lista<Distrito> getDistritos(){
        return this.csv.leerCSV();
    }

    public Distrito getDistritoById(int id){
        Lista<Distrito> lista = getDistritos();
        for (Distrito d : lista){
            if (d.getId() == id) { return d; }
        }
        return null;
    }
    
}
