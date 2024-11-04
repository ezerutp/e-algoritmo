package pe.algoritmo.vidarte.models;

import pe.algoritmo.vidarte.controllers.EleccionController;
import pe.algoritmo.vidarte.controllers.MesaController;
import pe.algoritmo.vidarte.interfaces.CSVUtil;

public class Votacion implements CSVUtil{
    private int id;
    private Eleccion eleccion; // Asociación con Eleccion
    private Mesa mesa; // Asociación con Mesa
    private EleccionResultado resultado;
    private final String filepathCSV = System.getProperty("user.dir") + "/csv/csv_votacion.csv";
    private static final String CSV_DELIMITER = ";";

    public Votacion(){}

    //Constructor para partidos
    public Votacion(int idVotacion, Eleccion eleccion, Mesa mesa, EleccionResultado resultado) {
        this.id = idVotacion;
        this.eleccion = eleccion;
        this.mesa = mesa;
        this.resultado = resultado;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int idVotacion) {
        this.id = idVotacion;
    }

    public Eleccion getEleccion() {
        return this.eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    public Mesa getMesa() {
        return this.mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public EleccionResultado getResultado() {
        return this.resultado;
    }

    public void setResultado(EleccionResultado resultado) {
        this.resultado = resultado;
    }

    public String getFilepathCSV() {
        return this.filepathCSV;
    }

    @Override
    public String getFilePath(){
        return filepathCSV;
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.id = Integer.parseInt(data[0]);
            //bloque para eleccion
            EleccionController c_eleccion = new EleccionController();
            this.eleccion = c_eleccion.getEleccionById(Integer.parseInt(data[1]));
            //bloque para mesa
            MesaController c_mesa = new MesaController();
            this.mesa = c_mesa.getMesaById(Integer.parseInt(data[2]));
            //fin
            this.resultado = new EleccionResultado(data);            
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
            " idVotacion='" + getId() + "'" +
            ", eleccion='" + getEleccion() + "'" +
            ", mesa='" + getMesa() + "'" +
            "}";
    }

}