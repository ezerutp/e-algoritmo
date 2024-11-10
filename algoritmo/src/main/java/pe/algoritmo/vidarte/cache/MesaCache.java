package pe.algoritmo.vidarte.cache;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Diccionario.Diccionario;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class MesaCache {
    private static MesaCache instance;
    private Diccionario<Integer, Mesa> mesasCache;
    private Lista<Mesa> mesas;
    private CSV<Mesa> csv;
    private int idMax;
    
    private MesaCache() {
        mesasCache = new Diccionario<>();
        csv = new CSV<>(Mesa.class);
        mesas = this.csv.leerCSV();
        for (Mesa mesa : mesas) {
            idMax = Math.max(idMax, mesa.getId());
            mesasCache.put(mesa.getId(), mesa);
        }
    }
    
    public static MesaCache getInstance() {
        if (instance == null) {
            instance = new MesaCache();
        }
        return instance;
    }

    public int nextIndex(){
        return idMax + 1;
    }

    public Diccionario<Integer, Mesa> mesas(){
        return mesasCache;
    }

    public void registrar(int id, Mesa m){
        mesasCache.put(id, m);
        idMax = id;
    }
    
    public Mesa getMesa(int id) {
        return mesasCache.get(id);
    }

    public Lista<Mesa> getMesas(){
        return mesas;
    }

    public boolean eliminar(int id){
        return mesasCache.remove(id) != null;
    }

    public void actualizar(int id, Mesa m){
        mesasCache.put(id, m);
    }
}