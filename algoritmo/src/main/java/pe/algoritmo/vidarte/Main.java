package pe.algoritmo.vidarte;

import pe.algoritmo.vidarte.views.votaciones.votaciones;
import pe.algoritmo.vidarte.cache.CacheInit;
import pe.algoritmo.vidarte.views.*;

public class Main {
    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir") + "/config.properties";
        CacheInit.getInstance().init(ruta);
        
        Menu.main(null);
    }
}