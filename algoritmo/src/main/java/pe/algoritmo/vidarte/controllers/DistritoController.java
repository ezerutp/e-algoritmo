package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.utils.Lista;

public class DistritoController {
    
    private CSV<Distrito> csv;

    public DistritoController(){
        this.csv = new CSV<>(Distrito.class);
    }

    public boolean registrar(Distrito d){
        int id = this.csv.obtenerIdMaximo() + 1;
        d.setId(id);
        return this.csv.registrar(d);
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

    public boolean eliminarById(int id){
        return this.csv.eliminarPorId(id);
    }

    public boolean actualizarById(int id, Distrito d){
        return this.csv.actualizarPorId(id, d);
    }
    
}
