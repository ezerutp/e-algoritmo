package pe.algoritmo.vidarte.cache;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Diccionario.Diccionario;
import pe.algoritmo.vidarte.utils.Lista.Lista;

/**
 * Clase MesaCache, singleton que se encarga de la gestión de la cache de mesas.
 * 
 * Esta clase se encarga de cargar las mesas desde un archivo CSV, gestionar la cache de mesas,
 * y proporcionar métodos para registrar, obtener, eliminar y actualizar mesas.
 * 
 * @author Vidarte
 */
public class MesaCache {
    private static MesaCache instance;
    private Diccionario<Integer, Mesa> mesasCache;
    private Lista<Mesa> mesas;
    private CSV<Mesa> csv;
    private int idMax;
    
    /**
     * Constructor privado para evitar la creación de instancias desde fuera de la clase.
     */
    private MesaCache() {
        mesasCache = new Diccionario<>();
        csv = new CSV<>(Mesa.class);
        mesas = this.csv.leerCSV();
        for (Mesa mesa : mesas) {
            idMax = Math.max(idMax, mesa.getId());
            mesasCache.put(mesa.getId(), mesa);
        }
    }
    
    /**
     * Método para obtener la instancia única de MesaCache.
     * 
     * @return La instancia única de MesaCache.
     */
    public static MesaCache getInstance() {
        if (instance == null) {
            instance = new MesaCache();
        }
        return instance;
    }

    /**
     * Método para obtener el próximo índice disponible.
     * 
     * @return El próximo índice disponible para una nueva mesa.
     */
    public int nextIndex(){
        return idMax + 1;
    }

    /**
     * Método para obtener el diccionario de mesas cacheadas.
     * 
     * @return El diccionario de mesas cacheadas.
     */
    public Diccionario<Integer, Mesa> mesas(){
        return mesasCache;
    }

    /**
     * Método para registrar una nueva mesa en la cache.
     * 
     * @param id El identificador de la mesa.
     * @param m La mesa a registrar.
     */
    public void registrar(int id, Mesa m){
        mesasCache.put(id, m);
        idMax = id;
    }
    
    /**
     * Método para obtener una mesa por su identificador.
     * 
     * @param id El identificador de la mesa.
     * @return La mesa correspondiente al identificador, o null si no se encuentra.
     */
    public Mesa getMesa(int id) {
        return mesasCache.get(id);
    }

    /**
     * Método para obtener la lista de mesas.
     * 
     * @return La lista de mesas.
     */
    public Lista<Mesa> getMesas(){
        return mesas;
    }

    /**
     * Método para eliminar una mesa de la cache.
     * 
     * @param id El identificador de la mesa a eliminar.
     * @return Verdadero si la mesa fue eliminada con éxito, falso de lo contrario.
     */
    public boolean eliminar(int id){
        return mesasCache.remove(id) != null;
    }

    /**
     * Método para actualizar una mesa en la cache.
     * 
     * @param id El identificador de la mesa a actualizar.
     * @param m La mesa actualizada.
     */
    public void actualizar(int id, Mesa m){
        mesasCache.put(id, m);
    }
}