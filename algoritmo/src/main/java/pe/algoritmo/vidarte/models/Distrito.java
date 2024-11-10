package pe.algoritmo.vidarte.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Utilidades;

public class Distrito implements CSVUtil{
    private int id;
    private String nombre;
    //private final String filepathCSV = System.getProperty("user.dir") + "/csv/csv_distritos.csv";
    private static final String CSV_DELIMITER = ";";

    public Distrito(){}

    public Distrito(int idDistrito, String distrito) {
        this.id = idDistrito;
        this.nombre = distrito;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int idDistrito) {
        this.id = idDistrito;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String distrito) {
        this.nombre = distrito;
    }

    @Override
    public String getModelName() {
        return "distrito";
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.id = Integer.parseInt(data[0]);
            this.nombre = data[1];
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
            .append("nombre", nombre)
            .toString();
    }
}
