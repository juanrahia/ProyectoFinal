/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves.render;

import gestorclaves.Categoria;
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
public class CategoriaRender extends DefaultTableCellRenderer{
   
    public CategoriaRender() { 
        setHorizontalAlignment(SwingConstants.CENTER); 
    }
    
    @Override 
    public void setValue(Object aValue){
        if(aValue != null ){
            Categoria categoria = (Categoria)aValue;
            switch(categoria.getIdCat()){
                case 1:
            try {
                this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/trabajo.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 2:
            try {
                this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/informatica.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 3:
            try {
                this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/ocio.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 4:
            try {
                this.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/fotografia.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                default:
                    this.setIcon(null);     
            }
        }else{
          this.setIcon(null);  
        }
    }
}
