
package gestorclaves;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloTabla extends AbstractTableModel{
    
    List<Entrada> list;
    
    //Dar al modeloTabla la lista de objetos 
    public void setDataList(List<Entrada> list){
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: 
                return "Nombre";
            case 1: 
                return "Categoria";
            case 2: 
                return "Favorito";
            case 3:
                return "Fecha";
            case 4:
                return "Cuota";
            default:
                return null;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entrada entrada = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return entrada.getNombre();
            case 1:
                return entrada.getIdCat();
            case 2:
                return entrada.getFavorito();
            case 3: 
                return entrada.getFecha();
            case 4:
                return entrada.getCuota();
            default:
                return null;
        }
       
    }
    
    
}
