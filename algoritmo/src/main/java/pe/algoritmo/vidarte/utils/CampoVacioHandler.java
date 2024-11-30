package pe.algoritmo.vidarte.utils;

import javax.swing.JTextField;

import pe.algoritmo.vidarte.Abstract.AbstractHandler;

public class CampoVacioHandler extends AbstractHandler {
    private JTextField textField;

    public CampoVacioHandler(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public boolean handle() {
        if (textField.getText().isEmpty()) {
            return false;
        }
        return super.handle();
    }
}