package pe.algoritmo.vidarte.models;

import pe.algoritmo.vidarte.interfaces.CSVUtil;

public class Distrito implements CSVUtil{
    private int idDistrito;
    private String distrito;
    private final String filepathCSV = System.getProperty("user.dir") + "/Elecciones-algoritmos/src/elecciones/csv_distritos.csv";
    private static final String CSV_DELIMITER = ";";

    public Distrito(){}

    public Distrito(int idDistrito, String distrito) {
        this.idDistrito = idDistrito;
        this.distrito = distrito;
    }

    @Override
    public int getId() {
        return this.idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDistrito() {
        return this.distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String getFilePath() {
        return this.filepathCSV;
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.idDistrito = Integer.parseInt(data[0]);
            this.distrito = data[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toCSV(){
        return null;
    }
    
    @Override
    public String toString() {
        return "{" +
            " idDistrito='" + getId() + "'" +
            ", distrito='" + getDistrito() + "'" +
            "}";
    }

}
