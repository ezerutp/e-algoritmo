package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista;

public class VotacionController {
    
    private CSV<Votacion> csv;

    public VotacionController(){
        this.csv = new CSV<>(Votacion.class);
    }

    public boolean registrar(Votacion v){
        int id = this.csv.obtenerIdMaximo() + 1;
        v.setId(id);
        return this.csv.registrar(v);
    }

    public Lista<Votacion> getVotaciones(){
        return this.csv.leerCSV();
    }

    public Votacion getVotacionById(int id){
        Lista<Votacion> lista = getVotaciones();
        for (Votacion v : lista){
            if (v.getId() == id) { return v; }
        }
        return null;
    }

    public boolean eliminarById(int id){
        return this.csv.eliminarPorId(id);
    }

    public boolean actualizarById(int id, Votacion v){
        return this.csv.actualizarPorId(id, v);
    }
}
