
package gestorclaves.render;

import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


public class CuotaRender extends DefaultTableCellRenderer{
    
     public CuotaRender() { 
        setHorizontalAlignment(SwingConstants.RIGHT); 
    }
     
     public void setValue(Object aValue){
         Object result = aValue;
        if(aValue != null ){
            Number numberValue = (Number) aValue; 
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            result = formatter.format(numberValue.doubleValue());
        }
        super.setValue(result);
    }
}
