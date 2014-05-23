/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves.render;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author usuario
 */
public class FavoritoRender extends DefaultTableCellRenderer{
    
    public FavoritoRender() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    }
    
    @Override 
    public void setValue(Object aValue) {
        Boolean result = (Boolean)aValue; 
        if ((result != null) && (result instanceof Boolean)) {
            if(result){
                try {
                    this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/check.png"))));
                } catch (IOException ex) {
                    Logger.getLogger(FavoritoRender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                    this.setIcon(null);
            } 
        }     
    }
}
