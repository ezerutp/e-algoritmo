package pe.algoritmo.vidarte.cache;

import pe.algoritmo.vidarte.csv.CSVConfig;

/**
 * Clase CacheInit, responsable de inicializar los caches del sistema.
 * 
 * Esta clase se encarga de cargar la configuración del sistema y de inicializar los caches necesarios.
 * 
 * @author Vidarte
 */
public class CacheInit {
    private static CacheInit instance;
    
    /**
     * Constructor privado para evitar la creación de instancias desde fuera de la clase.
     */
    private CacheInit() {}
    
    /**
     * Método para obtener la instancia única de CacheInit.
     * 
     * @return La instancia única de CacheInit.
     */
    public static CacheInit getInstance() {
        if (instance == null) {
            instance = new CacheInit();
        }
        return instance;
    }
    
    /**
     * Método para inicializar los caches del sistema.
     * 
     * Este método carga la configuración del sistema a partir de un archivo de configuración y
     * inicializa los caches necesarios.
     * 
     * @param configPath Ruta del archivo de configuración.
     */
    public void init(String configPath) {
        
        // Cargar configuración
        CSVConfig.getInstance().loadConfig(configPath);
        
        // Inicializar caches
        MesaCache.getInstance();
        VotacionCache.getInstance();
    }
} 