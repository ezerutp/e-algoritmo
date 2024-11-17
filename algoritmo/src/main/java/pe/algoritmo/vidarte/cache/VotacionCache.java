package pe.algoritmo.vidarte.cache;

import pe.algoritmo.vidarte.csv.CSV;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Diccionario.Diccionario;
import pe.algoritmo.vidarte.utils.Lista.Lista;

/**
 * Clase VotacionCache, singleton que se encarga de la gestión de la cache de votaciones.
 * 
 * Esta clase se encarga de cargar las votaciones desde un archivo CSV, gestionar la cache de votaciones,
 * y proporcionar métodos para registrar, obtener, eliminar y actualizar votaciones.
 * 
 * @author Vidarte
 */
public class VotacionCache {
    
    private static VotacionCache instance;
    private Diccionario<Integer, Votacion> votacionCache;
    private Lista<Votacion> votaciones;
    private CSV<Votacion> csv;
    private int idMax;

    /**
     * Constructor privado para evitar la creación de instancias desde fuera de la clase.
     */
    private VotacionCache(){
        votacionCache = new Diccionario<>();
        csv = new CSV<>(Votacion.class);
        votaciones = csv.leerCSV();
        for (Votacion v : votaciones){
            idMax = Math.max(idMax, v.getId());
            votacionCache.put(v.getId(), v);
        }
    }

    /**
     * Método para obtener la instancia única de VotacionCache.
     * 
     * @return La instancia única de VotacionCache.
     */
    public static VotacionCache getInstance(){
        if (instance == null){
            instance = new VotacionCache();
        }
        return instance;
    }

    /**
     * Método para obtener el próximo índice disponible.
     * 
     * @return El próximo índice disponible para una nueva votación.
     */
    public int nextIndex(){
        return idMax + 1;
    }

    /**
     * Método para obtener el diccionario de votaciones cacheadas.
     * 
     * @return El diccionario de votaciones cacheadas.
     */
    public Diccionario<Integer, Votacion> votaciones(){
        return votacionCache;
    }

    /**
     * Método para registrar una nueva votación.
     * 
     * @param id El identificador de la votación.
     * @param v La votación a registrar.
     */
    public void registrar(int id, Votacion v){
        votacionCache.put(id, v);
        idMax = id;
    }

    /**
     * Método para obtener una votación por su identificador.
     * 
     * @param id El identificador de la votación.
     * @return La votación correspondiente al identificador.
     */
    public Votacion geVotacion(int id){
        return votacionCache.get(id);
    }

    /**
     * Método para obtener la lista de votaciones.
     * 
     * @return La lista de votaciones.
     */
    public Lista<Votacion> getVotaciones(){
        return votaciones;
    }

    /**
     * Método para eliminar una votación por su identificador.
     * 
     * @param id El identificador de la votación.
     * @return Verdadero si la votación fue eliminada, falso de lo contrario.
     */
    public boolean eliminar(int id){
        return votacionCache.remove(id) != null;
    }

    /**
     * Método para actualizar una votación existente.
     * 
     * @param id El identificador de la votación.
     * @param v La votación actualizada.
     */
    public void actualizar(int id, Votacion v){
        votacionCache.put(id, v);
    }
}
