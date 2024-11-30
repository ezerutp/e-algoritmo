package pe.algoritmo.vidarte.utils;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import pe.algoritmo.vidarte.models.Distrito;
import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

/**
 * Clase Utilidades que proporciona métodos útiles para la conversión de modelos
 * a formato CSV.
 * 
 * Esta clase ofrece un método estático para convertir objetos de los modelos
 * Distrito, Eleccion, Mesa y Votacion
 * a una cadena de texto en formato CSV. El formato CSV generado incluye los
 * campos relevantes de cada modelo.
 * 
 * @author Vidarte
 */
public class Utilidades {

    /**
     * Convierte un objeto de un modelo específico a una cadena de texto en formato
     * CSV.
     * 
     * Este método analiza el tipo del objeto modelo pasado como parámetro y lo
     * convierte a una cadena de texto
     * en formato CSV según el modelo correspondiente. Los modelos soportados son
     * Distrito, Eleccion, Mesa y Votacion.
     * 
     * @param <T>    El tipo del modelo a convertir.
     * @param modelo El objeto del modelo a convertir a CSV.
     * @return Una cadena de texto en formato CSV representando el objeto modelo.
     */
    public static <T> String toCSV(T modelo) {
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

    public static void validarNumero(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    public static Lista<Votacion> listafiltrada(Lista<Votacion> lista, int eleccion, int distrito, int seccion) {
        Lista<Votacion> listaFiltrada = new Lista<>();
        for (Votacion votacion : lista) {
            if (votacion.getEleccion().getId() == eleccion
                    && (distrito == -1 || votacion.getMesa().getDistrito().getId() == distrito)
                    && (seccion == -1 || votacion.getMesa().getSeccion() == seccion)) {
                listaFiltrada.agregarAlFinal(votacion);
            }
        }
        return listaFiltrada;
    }
}
