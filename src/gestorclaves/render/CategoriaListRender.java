/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves.render;

import gestorclaves.Categoria;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author usuario
 */
public class CategoriaListRender implements ListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //Se van a mostrar los elementos en un JLabel, que es el componente habitual en los JList
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        
        //Convertir el valor recibido (value) al tipo de datos corespondiente
        Categoria categoria = (Categoria) value;
        //Crear el texto que se quiere mostrar para cada objeto
        switch(categoria.getIdCat()){
                case 1:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/trabajo.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 2:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/informatica.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 3:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/ocio.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                case 4:
            try {
                renderer.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/imagenes/fotografia.png"))));
            } catch (IOException ex) {
                Logger.getLogger(CategoriaRender.class.getName()).log(Level.SEVERE, null, ex);
            }
                    break;
                default:
                    renderer.setIcon(null);     
            }  
        
        renderer.setText(categoria.getCategoria());
        
        return renderer;
    }
}
