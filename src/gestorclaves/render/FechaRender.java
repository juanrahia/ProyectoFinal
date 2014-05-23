
package gestorclaves.render;

import java.sql.Date;
import java.text.DateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FechaRender  extends DefaultTableCellRenderer{
    public FechaRender() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    }
     
     public void setValue(Object aValue){
         String result = "";
         if(aValue != null ){
            DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
            result = formato.format(aValue);
        }
        super.setValue(result);
    }
}
