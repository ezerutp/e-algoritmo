package pe.algoritmo.vidarte.models;

import pe.algoritmo.vidarte.controllers.EleccionController;
import pe.algoritmo.vidarte.controllers.MesaController;
import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Utilidades;
import pe.algoritmo.vidarte.utils.Utilidades.Partido;

public class Votacion implements CSVUtil{
    private int idVotacion;
    private Eleccion eleccion; // Asociación con Eleccion
    private Mesa mesa; // Asociación con Mesa
    private Partido partido;    
    private int numVotos;
    private final String filepathCSV = System.getProperty("user.dir") + "/Elecciones-algoritmos/src/elecciones/csv_votacion.csv";
    private static final String CSV_DELIMITER = ";";

    public Votacion(){}

    //Constructor para partidos
    public Votacion(int idVotacion, Eleccion eleccion, Mesa mesa, Partido partido, int numVotos) {
        this.idVotacion = idVotacion;
        this.eleccion = eleccion;
        this.mesa = mesa;
        this.partido = partido;
        this.numVotos = numVotos;
    }

    @Override
    public int getId() {
        return this.idVotacion;
    }

    public void setId(int idVotacion) {
        this.idVotacion = idVotacion;
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

    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getNumVotos() {
        return this.numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    @Override
    public String getFilePath(){
        return filepathCSV;
    }

    @Override
    public void fromCSV(String csv){
        try {
            String[] data = csv.split(CSV_DELIMITER);
            this.idVotacion = Integer.parseInt(data[0]);
            //bloque para eleccion
            EleccionController c_eleccion = new EleccionController();
            this.eleccion = c_eleccion.getEleccionById(Integer.parseInt(data[1]));
            //bloque para mesa
            MesaController c_mesa = new MesaController();
            this.mesa = c_mesa.getMesaById(Integer.parseInt(data[2]));
            //fin
            this.partido = Utilidades.tipoPartido(data[3]);
            this.numVotos = Integer.parseInt(data[4]);
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
            ", partido='" + getPartido() + "'" +
            ", numVotos='" + getNumVotos() + "'" +
            "}";
    }

}