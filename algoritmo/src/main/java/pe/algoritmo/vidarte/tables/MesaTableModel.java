package pe.algoritmo.vidarte.tables;

import javax.swing.table.AbstractTableModel;

import pe.algoritmo.vidarte.models.Mesa;
import pe.algoritmo.vidarte.utils.Lista.Lista;

public class MesaTableModel extends AbstractTableModel{
    private Lista<Mesa> modelo;
    private String[] columnStrings = {"Distrito", "Seccion", "Mesa"};

    public MesaTableModel(Lista<Mesa> lista){
        this.modelo = lista;
    }

    @Override
    public int getColumnCount() {
        return columnStrings.length;
    }

    @Override
    public int getRowCount() {
        return modelo.size();
    }

    @Override
    public String getColumnName(int column){
        return columnStrings[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesa m = modelo.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getDistrito().getNombre();
            case 1:
                return m.getSeccion();
            case 2:
                return m.getTipoMesa();
            default:
                return null;
        }
        
    }
    
}
