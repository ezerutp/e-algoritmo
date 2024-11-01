package pe.algoritmo.vidarte.models;

import pe.algoritmo.vidarte.controllers.DistritoController;
import pe.algoritmo.vidarte.interfaces.CSVUtil;

public class Mesa implements CSVUtil{
    private int idMesa;
    private Distrito distrito; // Asociación con Distrito
    private int seccion;
    private String mesa;
    private final String filepathCSV = System.getProperty("user.dir") + "/Elecciones-algoritmos/src/elecciones/csv_mesas.csv";
    private static final String CSV_DELIMITER = ";";

    public Mesa(){}

    public Mesa(int idMesa, Distrito distrito, int seccion, String mesa) {
        this.idMesa = idMesa;
        this.distrito = distrito;
        this.seccion = seccion;
        this.mesa = mesa;
    }

    @Override
    public int getId() {
        return this.idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Distrito getDistrito() {
        return this.distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public int getSeccion() {
        return this.seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getMesa() {
        return this.mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    @Override
    public String getFilePath() {
        return this.filepathCSV;
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.idMesa = Integer.parseInt(data[0]);
            //bloque para distrito
            DistritoController c_distrito = new DistritoController();
            this.distrito = c_distrito.getDistritoById(Integer.parseInt(data[1]));
            //fin
            this.seccion = Integer.parseInt(data[2]);
            this.mesa = data[3];
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
            " idMesa='" + getId() + "'" +
            ", distrito='" + getDistrito() + "'" +
            ", seccion='" + getSeccion() + "'" +
            ", mesa='" + getMesa() + "'" +
            "}";
    }

}
