package pe.algoritmo.vidarte.controllers;

import pe.algoritmo.vidarte.cache.MesaCache;
import pe.algoritmo.vidarte.cache.VotacionCache;
import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class VotacionController {
    
    private CSV<Votacion> csv;

    public VotacionController(){
        this.csv = new CSV<>(Votacion.class);
    }

    public Lista<Votacion> getVotaciones(){
        return VotacionCache.getInstance().getVotaciones();
    }

    public boolean registrar(Votacion v){
        v.setId(VotacionCache.getInstance().nextIndex());
        if (this.csv.registrar(v)){
            VotacionCache.getInstance().registrar(v.getId(), v);
            return true;
        }
        return false;
    }

    public Lista<Mesa> getMesasSinVotacion(){
        Lista<Votacion> votaciones = getVotaciones();
        Lista<Mesa> mesas = MesaCache.getInstance().getMesas();
        for (Votacion v : votaciones){
            Mesa mesita = v.getMesa();
            mesas.remover(mesita);
        }
        return mesas;
    }

    public Votacion getVotacionById(int id){
        return VotacionCache.getInstance().geVotacion(id); 
    }

    public boolean eliminarById(int id){
        if (this.csv.eliminarPorId(id)){
            VotacionCache.getInstance().eliminar(id);
            return true;
        }
        return false;
    }

    public boolean actualizarById(int id, Votacion v){
        if (this.csv.actualizarPorId(id, v)){
            VotacionCache.getInstance().actualizar(id, v);
            return true;
        }
        return false;
    }
}
