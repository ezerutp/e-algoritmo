package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Lista;

public class MesaController {
    
    private CSV<Mesa> csv;

    public MesaController(){
        this.csv = new CSV<>(Mesa.class);
    }

    public Lista<Mesa> getMesa(){
        return this.csv.leerCSV();
    }

    public Mesa getMesaById(int id){
        Lista<Mesa> lista  = getMesa();
        for (Mesa m : lista){
            if (m.getId() == id) { return m; }
        }
        return null;
    }
}
