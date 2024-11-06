package pe.algoritmo.vidarte.cache;

import java.util.HashMap;
import java.util.Map;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista;

public class VotacionCache {
    
    private static VotacionCache instance;
    private Map<Integer, Votacion> votacionCache;
    private Lista<Votacion> votaciones;
    private CSV<Votacion> csv;
    private int idMax;

    private VotacionCache(){
        votacionCache = new HashMap<>();
        csv = new CSV<>(Votacion.class);
        votaciones = csv.leerCSV();
        for (Votacion v : votaciones){
            idMax = Math.max(idMax, v.getId());
            votacionCache.put(v.getId(), v);
        }
    }

    public static VotacionCache getInstance(){
        if (instance == null){
            instance = new VotacionCache();
        }
        return instance;
    }

    public int nextIndex(){
        return idMax + 1;
    }

    public Map<Integer, Votacion> votaciones(){
        return votacionCache;
    }

    public void registrar(int id, Votacion v){
        votacionCache.put(id, v);
        idMax = id;
    }

    public Votacion geVotacion(int id){
        return votacionCache.get(id);
    }

    public Lista<Votacion> getVotaciones(){
        return votaciones;
    }

    public boolean eliminar(int id){
        return votacionCache.remove(id) != null;
    }

    public void actualizar(int id, Votacion v){
        votacionCache.put(id, v);
    }
}
