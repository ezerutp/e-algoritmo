package pe.algoritmo.vidarte.utils;

import javax.swing.JTextField;

import pe.algoritmo.vidarte.interfaces.Handler;

public class ValidadorCampos {
    public static boolean validarCampos(JTextField... textFields) {
        Handler handler = null;
        Handler currentHandler = null;

        for (JTextField textField : textFields) {
            Handler newHandler = new CampoVacioHandler(textField);
            if (handler == null) {
                handler = newHandler;
                currentHandler = newHandler;
            } else {
                currentHandler.setNext(newHandler);
                currentHandler = newHandler;
            }
        }

        return handler.handle();
    }
}