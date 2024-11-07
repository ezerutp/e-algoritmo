package pe.algoritmo.vidarte.utils;

import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.models.Votacion;

public class Utilidades {

    public static <T> String toCSV(T modelo){
        if (modelo instanceof Distrito) {
            Distrito distrito = (Distrito) modelo;
            return new StringBuilder()
                .append(distrito.getId())
                .append(";")
                .append(distrito.getNombre())
                .toString();
        } else if (modelo instanceof Eleccion) {
            Eleccion eleccion = (Eleccion) modelo;
            return new StringBuilder()
                .append(eleccion.getId())
                .append(";")
                .append(eleccion.getAnio())
                .append(";")
                .append(eleccion.getTitulo())
                .append(";")
                .append(eleccion.getFechaElecciones())
                .toString();
        } else if (modelo instanceof Mesa) {
            Mesa mesa = (Mesa) modelo;
            return new StringBuilder()
                .append(mesa.getId())
                .append(";")
                .append(mesa.getDistrito().getId())
                .append(";") 
                .append(mesa.getSeccion())
                .append(";")
                .append(mesa.getTipoMesa())
                .toString();
        } else if (modelo instanceof Votacion) {
            Votacion v = (Votacion) modelo;
            return new StringBuilder()
                .append(v.getId())
                .append(";")
                .append(v.getEleccion().getId())
                .append(";")
                .append(v.getMesa().getId())
                .append(";")
                .append(v.getResultado().getElectores())
                .append(";")
                .append(v.getResultado().getAbstenciones())
                .append(";")
                .append(v.getResultado().getVotantes())
                .append(";")
                .append(v.getResultado().getBlancos())
                .append(";")
                .append(v.getResultado().getValidos())
                .append(";")
                .append(v.getResultado().getNulos())
                .append(";")
                .append(v.getResultado().getPsoe())
                .append(";")
                .append(v.getResultado().getFo())
                .append(";")
                .append(v.getResultado().getPp())
                .append(";")
                .append(v.getResultado().getPacma())
                .append(";")
                .append(v.getResultado().getPcte())
                .append(";")
                .append(v.getResultado().getPumJ())
                .append(";")
                .append(v.getResultado().getVox())
                .append(";")
                .append(v.getResultado().getPuede())
                .append(";")
                .append(v.getResultado().getAeev())
                .append(";")
                .append(v.getResultado().getRc())
                .append(";")
                .append(v.getResultado().getSumar())
                .toString();
        }
        return null;
    }
}
