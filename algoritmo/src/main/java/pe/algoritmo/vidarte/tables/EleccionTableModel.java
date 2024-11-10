package pe.algoritmo.vidarte.tables;

import javax.swing.table.AbstractTableModel;

import pe.algoritmo.vidarte.models.Eleccion;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class EleccionTableModel extends AbstractTableModel{
    Lista<Eleccion> modelo;
    private String[] columStrings = {"Anio", "Titulo", "Fecha"};

    public EleccionTableModel(Lista<Eleccion> lista){
        this.modelo = lista;
    }

    @Override
    public int getColumnCount() {
        return columStrings.length;
    }

    @Override
    public int getRowCount() {
        return modelo.size();
    }

    @Override
    public String getColumnName(int column) {
        return columStrings[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Eleccion e = modelo.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getAnio();
            case 1:
                return e.getTitulo();
            case 2:
                return e.getFechaElecciones();
            default:
                return null;
        }
    }
    
}
