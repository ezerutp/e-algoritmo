package pe.algoritmo.vidarte.tables;

import javax.swing.table.AbstractTableModel;

import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class VotacionTableModel extends AbstractTableModel{
    private Lista<Votacion> modelo;
    private String[] columStrings = {"electores", "abstenciones", "votantes", "blancos", "validos", "nulos", "psoe", "fo", "pp", "pacma", "pcte", "pumJ", "vox", "puede", "aeev", "rc", "sumar"};

    public VotacionTableModel(Lista<Votacion> lista){
        this.modelo = lista;
    }

    @Override
    public int getRowCount() {
        return modelo.size();
    }

    @Override
    public int getColumnCount() {
        return columStrings.length;
    }

    @Override
    public String getColumnName(int column) {
        return columStrings[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Votacion v = modelo.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getResultado().getElectores();
            case 1:
                return v.getResultado().getAbstenciones();
            case 2:
                return v.getResultado().getVotantes();
            case 3:
                return v.getResultado().getBlancos();
            case 4:
                return v.getResultado().getValidos();
            case 5:
                return v.getResultado().getNulos();
            case 6:
                return v.getResultado().getPsoe();
            case 7:
                return v.getResultado().getFo();
            case 8:
                return v.getResultado().getPp();
            case 9:
                return v.getResultado().getPacma();
            case 10:
                return v.getResultado().getPcte();
            case 11:
                return v.getResultado().getPumJ();
            case 12:
                return v.getResultado().getVox();
            case 13:
                return v.getResultado().getPuede();
            case 14:
                return v.getResultado().getAeev();
            case 15:
                return v.getResultado().getRc();
            case 16:
                return v.getResultado().getSumar();
            default:
                return null;
        }
    }
    
}
