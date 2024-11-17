package pe.algoritmo.vidarte.csv;

import java.io.*;
import java.util.Properties;

import pe.algoritmo.vidarte.Main;

/**
 * Clase CSVConfig, singleton que se encarga de la configuración de los archivos CSV.
 * 
 * Esta clase se encarga de cargar la configuración de los archivos CSV a partir de un archivo de configuración,
 * y proporcionar métodos para obtener la ruta de los modelos de CSV.
 * 
 * @author Vidarte
 */
public class CSVConfig {
    private static CSVConfig instance;
    private Properties propiedades;
    
    /**
     * Constructor privado para evitar la creación de instancias desde fuera de la clase.
     */
    private CSVConfig() {
        propiedades = new Properties();
    }
    
    /**
     * Método para obtener la instancia única de CSVConfig.
     * 
     * @return La instancia única de CSVConfig.
     */
    public static CSVConfig getInstance() {
        if (instance == null) {
            instance = new CSVConfig();
        }
        return instance;
    }
    
    /**
     * Método para cargar la configuración de los archivos CSV.
     * 
     * Este método carga la configuración de los archivos CSV a partir de un archivo de configuración.
     * 
     * @param config Ruta del archivo de configuración.
     */
    public void loadConfig(String config) {
        String configPath = Main.class.getClassLoader().getResource(config).getPath();
        try (InputStream ruta = new FileInputStream(configPath)) {
            propiedades.load(ruta);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de configuración", e);
        }
    }
    
    /**
     * Método para obtener la ruta de un modelo de CSV.
     * 
     * Este método devuelve la ruta completa de un modelo de CSV basado en la configuración cargada.
     * 
     * @param model Nombre del modelo de CSV.
     * @return La ruta completa del modelo de CSV.
     */
    public String getRutaModel(String model) {
        return System.getProperty("user.dir") + propiedades.getProperty(model);
    }
}