package pe.algoritmo.vidarte.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pe.algoritmo.vidarte.controllers.DistritoController;
import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Utilidades;

public class Mesa implements CSVUtil{
    private int id;
    private Distrito distrito; // Asociación con Distrito
    private int seccion;
    private String tipoMesa;
    private final String filepathCSV = System.getProperty("user.dir") + "/csv/csv_mesas.csv";
    private static final String CSV_DELIMITER = ";";

    public Mesa(){}

    public Mesa(int idMesa, Distrito distrito, int seccion, String tipomesa) {
        this.id = idMesa;
        this.distrito = distrito;
        this.seccion = seccion;
        this.tipoMesa = tipomesa;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int idMesa) {
        this.id = idMesa;
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

    public String getTipoMesa() {
        return this.tipoMesa;
    }

    public void setTipoMesa(String mesa) {
        this.tipoMesa = mesa;
    }

    @Override
    public String getFilePath() {
        return this.filepathCSV;
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.id = Integer.parseInt(data[0]);
            //bloque para distrito
            DistritoController c_distrito = new DistritoController();
            this.distrito = c_distrito.getDistritoById(Integer.parseInt(data[1]));
            //fin
            this.seccion = Integer.parseInt(data[2]);
            this.tipoMesa = data[3];
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
            .append("distrito", distrito)
            .append("seccion", seccion)
            .append("tipoMesa", tipoMesa)
            .toString();
    }

}
