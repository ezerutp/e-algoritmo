package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.cache.MesaCache;
import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Lista;

public class MesaController {
    
    private CSV<Mesa> csv;

    public MesaController(){
        this.csv = new CSV<>(Mesa.class);
    }

    public Lista<Mesa> getMesas(){
        return MesaCache.getInstance().getMesas();
    }

    public boolean registrar(Mesa m){
        m.setId(MesaCache.getInstance().nextIndex());
        if (this.csv.registrar(m)){
            MesaCache.getInstance().registrar(m.getId(), m);
            return true;
        }
        return false;
    }

    public Mesa getMesaById(int id){
        return MesaCache.getInstance().getMesa(id);
    }

    public boolean eliminarById(int id){
        if (this.csv.eliminarPorId(id)){
            MesaCache.getInstance().eliminar(id);
            return true;
        }
        return false;
    }

    public boolean actualizarById(int id, Mesa m){
        if (this.csv.actualizarPorId(id, m)){
            MesaCache.getInstance().actualizar(id, m);
            return true;
        }
        return false;
    }
}
