package pe.algoritmo.vidarte.controllers;

import java.util.List;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;

public class MesaController {
    
    private CSV<Mesa> csv;

    public MesaController(){
        this.csv = new CSV<>(Mesa.class);
    }

    public List<Mesa> getMesa(){
        return this.csv.leerCSV();
    }

    public Mesa getMesaById(int id){
        List<Mesa> lista  = getMesa();
        for (Mesa m : lista){
            if (m.getId() == id) { return m; }
        }
        return null;
    }
}
