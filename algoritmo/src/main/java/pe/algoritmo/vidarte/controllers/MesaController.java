package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Lista;

public class MesaController {
    
    private CSV<Mesa> csv;

    public MesaController(){
        this.csv = new CSV<>(Mesa.class);
    }

    public boolean registrar(Mesa m){
        int id = this.csv.obtenerIdMaximo() + 1;
        m.setId(id);
        return this.csv.registrar(m);
    }

    public Lista<Mesa> getMesas(){
        return this.csv.leerCSV();
    }

    public Mesa getMesaById(int id){
        Lista<Mesa> lista  = getMesas();
        for (Mesa m : lista){
            if (m.getId() == id) { return m; }
        }
        return null;
    }

    public boolean eliminarById(int id){
        return this.csv.eliminarPorId(id);
    }

    public boolean actualizarById(int id, Mesa m){
        return this.csv.actualizarPorId(id, m);
    }
}
