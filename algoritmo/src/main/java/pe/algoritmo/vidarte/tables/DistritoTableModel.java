package pe.algoritmo.vidarte.tables;

import javax.swing.table.AbstractTableModel;
import pe.algoritmo.vidarte.utils.Lista;
import pe.algoritmo.vidarte.models.Distrito;

public class DistritoTableModel extends AbstractTableModel {
    private Lista<Distrito> modelo;
    private String[] columStrings = {"Nombre"};

    public DistritoTableModel(Lista<Distrito> lista){
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
        Distrito d = modelo.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getNombre();
            default:
                return null;
        }
    }

}
