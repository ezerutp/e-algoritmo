package pe.algoritmo.vidarte.models;

import pe.algoritmo.vidarte.interfaces.CSVUtil;
import pe.algoritmo.vidarte.utils.Utilidades;

public class Elecciones implements CSVUtil{

    private int id;
    private int anio;
    private String titulo;
    private String fechaElecciones;
    private int distrito;
    private int seccion;
    private String mesa;
    private String partido;
    private int numVotos;
    private final String filepathCSV = System.getProperty("user.dir") + "/Elecciones-algoritmos/src/elecciones/ElecGenEspania2023_v2.csv";
    private static final String CSV_DELIMITER = ";";

    public Elecciones() { }

    // Constructor
    public Elecciones(int id, int anio, String titulo, String fechaElecciones, int distrito, int seccion, String mesa, String partido, int numVotos, String tipoResumen) {
        this.id = id;
        this.anio = anio;
        this.titulo = titulo;
        this.fechaElecciones = fechaElecciones;
        this.distrito = distrito;
        this.seccion = seccion;
        this.mesa = mesa;
        this.partido = partido;
        this.numVotos = numVotos; // Asignar el tipo de resumen (null si no es un resumen)
    }

    @Override
    public int getId() {
        return id;
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

    public int getDistrito() {
        return this.distrito;
    }

    public void setDistrito(int distrito) {
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

    public String getPartido() {
        return this.partido;
    }

    public void setPartido(String partido) {
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
            this.anio = Integer.parseInt(data[0]);
            this.titulo = data[1];
            this.fechaElecciones = data[2];
            this.distrito = Integer.parseInt(data[3]);
            this.seccion = Integer.parseInt(data[4]);
            this.mesa = data[5];
            this.partido = data[6];
            this.numVotos = Integer.parseInt(data[7]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toCSV() {
        return null;
    }

    public Distrito gerD(){
        Distrito nDistrito = new Distrito();
        nDistrito.setIdDistrito(this.distrito);
        nDistrito.setDistrito("Distrito " + this.distrito);
        return nDistrito;
    }

    public Mesa getM(){
        Mesa nMesa = new Mesa();
        nMesa.setIdMesa(0);
        nMesa.setMesa(this.mesa);
        nMesa.setDistrito(gerD());
        nMesa.setSeccion(this.seccion);
        return nMesa;
    }

    public Eleccion getE(){
        Eleccion nEleccion = new Eleccion();
        nEleccion.setIdEleccion(0);
        nEleccion.setAnio(this.anio);
        nEleccion.setFechaElecciones(this.fechaElecciones);
        nEleccion.setTitulo(this.titulo);
        return nEleccion;
    }

    public Votacion getV(){
        Votacion nVotacion = new Votacion();
        nVotacion.setId(0);
        nVotacion.setEleccion(getE());
        nVotacion.setMesa(getM());
        nVotacion.setPartido(Utilidades.tipoPartido(partido));
        nVotacion.setNumVotos(numVotos);
        return nVotacion;
    }
}
