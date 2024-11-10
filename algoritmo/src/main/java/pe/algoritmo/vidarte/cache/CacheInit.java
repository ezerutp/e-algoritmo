package pe.algoritmo.vidarte.cache;

import pe.algoritmo.vidarte.csv.CSVConfig;

public class CacheInit {
    private static CacheInit instance;
    
    private CacheInit() {}
    
    public static CacheInit getInstance() {
        if (instance == null) {
            instance = new CacheInit();
        }
        return instance;
    }
    
    public void init(String configPath) {
        
        // Cargar configuración
        CSVConfig.getInstance().loadConfig(configPath);
        
        // Inicializar caches
        MesaCache.getInstance();
        VotacionCache.getInstance();
    }
} 