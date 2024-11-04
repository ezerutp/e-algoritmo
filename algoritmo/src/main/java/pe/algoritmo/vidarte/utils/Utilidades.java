package pe.algoritmo.vidarte.utils;

import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.models.Votacion;

public class Utilidades {

    public static <T> String toCSV(T modelo){
        if (modelo instanceof Distrito) {
            Distrito distrito = (Distrito) modelo;
            return distrito.getId() + ";" + distrito.getNombre();
        } else if (modelo instanceof Eleccion) {
            Eleccion eleccion = (Eleccion) modelo;
            return eleccion.getId() + ";" + eleccion.getAnio() + ";" + eleccion.getTitulo() + ";" + eleccion.getFechaElecciones();
        } else if (modelo instanceof Mesa) {
            Mesa mesa = (Mesa) modelo;
            return mesa.getId() + ";" + mesa.getDistrito().getId() + ";" + mesa.getSeccion() + ";" + mesa.getTipoMesa();
        } else if (modelo instanceof Votacion) {
            Votacion v = (Votacion) modelo;
            return v.getId() + ";" + v.getEleccion().getId() + ";" + v.getMesa().getId() + ";" + v.getResultado().getElectores() + ";" + 
            v.getResultado().getAbstenciones() + ";" + v.getResultado().getVotantes() + ";" +
            v.getResultado().getBlancos() + ";" + v.getResultado().getValidos() + ";" + v.getResultado().getNulos() + ";" +
            v.getResultado().getPsoe() + ";" + v.getResultado().getFo() + ";" + v.getResultado().getPp() + ";" +
            v.getResultado().getPacma() + ";" + v.getResultado().getPcte() + ";" + v.getResultado().getPumJ() + ";" +
            v.getResultado().getVox() + ";" + v.getResultado().getPuede() + ";" + v.getResultado().getAeev() + ";" +
            v.getResultado().getRc() + ";" + v.getResultado().getSumar();
        }
        return null;
    }
}
