package pe.algoritmo.vidarte.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Utilidades;

public class Eleccion implements CSVUtil{
    private int id;
    private int anio;
    private String titulo;
    private String fechaElecciones;
    //private final String filepathCSV = System.getProperty("user.dir") + "/csv/csv_eleccion.csv";
    private static final String CSV_DELIMITER = ";";

    public Eleccion(){}
    
    public Eleccion(int idEleccion, int anio, String titulo, String fechaElecciones) {
        this.id = idEleccion;
        this.anio = anio;
        this.titulo = titulo;
        this.fechaElecciones = fechaElecciones;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int idEleccion) {
        this.id = idEleccion;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaElecciones() {
        return this.fechaElecciones;
    }

    public void setFechaElecciones(String fechaElecciones) {
        this.fechaElecciones = fechaElecciones;
    }

    @Override
    public String getModelName() {
        return "eleccion";
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.id = Integer.parseInt(data[0]);
            this.anio = Integer.parseInt(data[1]);
            this.titulo = data[2];
            this.fechaElecciones = data[3];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toCSV(){
        return Utilidades.toCSV(this);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("id", id)
            .append("anio", anio)
            .append("titulo", titulo)
            .append("fechaElecciones", fechaElecciones)
            .toString();
    }

}
