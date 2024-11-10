package pe.algoritmo.vidarte.csv;

import java.io.*;
import java.util.Properties;

import pe.algoritmo.vidarte.Main;

public class CSVConfig {
    private static CSVConfig instance;
    private Properties propiedades;
    
    private CSVConfig() {
        propiedades = new Properties();
    }
    
    public static CSVConfig getInstance() {
        if (instance == null) {
            instance = new CSVConfig();
        }
        return instance;
    }
    
    public void loadConfig(String config) {
        String configPath = Main.class.getClassLoader().getResource(config).getPath();
        try (InputStream ruta = new FileInputStream(configPath)) {
            propiedades.load(ruta);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de configuración", e);
        }
    }
    
    public String getRutaModel(String model) {
        return System.getProperty("user.dir") + propiedades.getProperty(model);
    }
}