

package gestorclaves.utiles;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



public class DocumentCharactersLimiter extends PlainDocument {
 private int limit; 

    public void setLimit(int limit) { 
        this.limit = limit; 
    }     

    @Override 
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) { 
            return; 
        } 

        if ((getLength() + str.length()) <= limit) { 
            super.insertString(offset, str, attr);
        }else{
            JOptionPane.showMessageDialog(null, "Ha superado el limite");
        } 
    }   
}
