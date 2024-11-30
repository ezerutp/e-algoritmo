package pe.algoritmo.vidarte.tables;

import javax.swing.table.AbstractTableModel;

import pe.algoritmo.vidarte.models.Votacion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class VotacionDistritoTableModel extends AbstractTableModel{
    private Lista<Votacion> modelo;
    private String[] columStrings = {"distrito", "seccion", "mesa", "electores", "abstenciones", "votantes", "blancos", "validos", "nulos"};

    public VotacionDistritoTableModel(Lista<Votacion> lista){
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
                return v.getMesa().getDistrito().getNombre();
            case 1:
                return v.getMesa().getSeccion();
            case 2:
                return v.getMesa().getTipoMesa();
            case 3:
                return v.getResultado().getElectores();
            case 4:
                return v.getResultado().getAbstenciones();
            case 5:
                return v.getResultado().getVotantes();
            case 6:
                return v.getResultado().getBlancos();
            case 7:
                return v.getResultado().getValidos();
            case 8:
                return v.getResultado().getNulos();
            default:
                return null;
        }
    }
    
}
