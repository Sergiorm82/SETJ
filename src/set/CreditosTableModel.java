package set;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreditosTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "RFC", "Número Crédito", "Nombre o razón Social"};
    private final List<CreditosFiscales> creditos;

    public CreditosTableModel(List<CreditosFiscales> creditos) {
        this.creditos = creditos;
    }

    @Override
    public int getRowCount() {
        return creditos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CreditosFiscales credito = creditos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> credito.getNumeroControl(); // Reemplaza con el método correcto
            case 1 -> credito.getRfc();
            case 2 -> credito.getNumeroCredito();
            case 3 -> credito.getRazonSocial();
            default -> null;
        };
    }

    public CreditosFiscales getCreditoAt(int rowIndex) {
        return creditos.get(rowIndex);
    }
}