/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves;

import gestorclaves.utiles.DocumentCharactersLimiter;
import java.awt.Frame;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class PanelDetalle extends javax.swing.JPanel {

    //Creamos una variable del objeto entrada que queremos mostrar
    private Entrada entrada;
    //Creamos un objeto Categoria
    private Categoria categoria;
    //y un método para obtener la categoria
    public Categoria getCategoria(){
        return categoria;
    }
    
    public PanelDetalle() {
        initComponents();
    }
    
    //Get y set del objeto Entrada
    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
    //Mostrar datos
    public void showData(){
        setEditable(false);
        jTextFieldCodigo.setText(String.valueOf(entrada.getIdClave()));  
        showCategoria();
        jTextFieldClave.setText(entrada.getClave());
        jTextFieldCuota.setText(String.valueOf(entrada.getCuota()));
        jDateChooser1.setDate((entrada.getFecha()));
        jTextFieldNombre.setText(entrada.getNombre());
        jTextFieldPaginaWeb.setText(entrada.getPaginaWeb());
        jTextFieldUsuario.setText(entrada.getUsuario());
        jCheckBoxFavorito.setSelected(entrada.getFavorito());      
    }
    
    //Mostrar la Categoria
    public void showCategoria(){
        if(categoria != null) {
            jTextFieldCategoria.setText(categoria.getCategoria());
        }else{
            jTextFieldCategoria.setText(entrada.getIdCat().getCategoria());
        }
    }
    
    //Campos editables
    public void setEditable(Boolean opcion){
        jTextFieldCodigo.setEditable(false);
        jTextFieldCategoria.setEditable(false);
        jTextFieldClave.setEditable(opcion);
        jTextFieldCuota.setEditable(opcion);
        jDateChooser1.setEnabled(opcion);
        jTextFieldNombre.setEditable(opcion);
        jTextFieldPaginaWeb.setEditable(opcion);
        jTextFieldUsuario.setEditable(opcion);
        jCheckBoxFavorito.setEnabled(opcion);
        jButtonCategorias.setEnabled(opcion);
    }
    
    //Limpiar datos
    public void cleanData(){
        this.limiteCaracteres();
        jTextFieldCodigo.setText("");
        jTextFieldCategoria.setText("");
        jTextFieldClave.setText("");
        jTextFieldCuota.setText("");
        jDateChooser1.setDate(null);
        jTextFieldCodigo.setText("");
        jTextFieldNombre.setText("");
        jTextFieldPaginaWeb.setText("");
        jTextFieldUsuario.setText("");
        jCheckBoxFavorito.setSelected(false);
    }
    
    //Establecer limites de caracteres
    public void limiteCaracteres(){
        //Objeto Document para limitar los caracteres de los campos uno corto(c) y otro más largo(l)
        DocumentCharactersLimiter limitClave = new DocumentCharactersLimiter();
        DocumentCharactersLimiter limitNombre = new DocumentCharactersLimiter();
        DocumentCharactersLimiter limitPagina = new DocumentCharactersLimiter();
        DocumentCharactersLimiter limitUsuario = new DocumentCharactersLimiter();
        //Se establecen los limites de caracteres
        limitClave.setLimit(20);
        limitNombre.setLimit(20);
        limitUsuario.setLimit(20);
        limitPagina.setLimit(100);
        //Se aplican a los campos especificos
        jTextFieldClave.setDocument(limitClave);
        jTextFieldNombre.setDocument(limitNombre);
        jTextFieldPaginaWeb.setDocument(limitPagina);
        jTextFieldUsuario.setDocument(limitUsuario);
    }
    
    //Establecer datos
    public void setData(){
        if(this.compruebaCuota()){
            entrada.setNombre(jTextFieldNombre.getText());
            entrada.setPaginaWeb(jTextFieldPaginaWeb.getText());
            entrada.setClave(jTextFieldClave.getText());
            entrada.setCuota(BigDecimal.valueOf(Double.valueOf(jTextFieldCuota.getText())));
            entrada.setFecha(jDateChooser1.getDate());
            entrada.setUsuario(jTextFieldUsuario.getText());
            entrada.setIdCat(categoria);
            entrada.setFavorito(jCheckBoxFavorito.isSelected());
        }
    }
    
    //Comprobar errores de números
    public boolean compruebaCuota(){
        String num = jTextFieldCuota.getText();
        try{
            Float.valueOf(num);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha insertado una cantidad no válida");
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldPaginaWeb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldClave = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCuota = new javax.swing.JTextField();
        jCheckBoxFavorito = new javax.swing.JCheckBox();
        jButtonCategorias = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Página Web:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Clave:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Código:");

        jLabel6.setText("Categoria:");

        jLabel7.setText("Fecha de alta:");

        jLabel8.setText("Cuota:");

        jCheckBoxFavorito.setText("Favorito");

        jButtonCategorias.setText("Categorias");
        jButtonCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jCheckBoxFavorito))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(103, 103, 103))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldPaginaWeb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldClave, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jButtonCategorias)))
                    .addComponent(jTextFieldCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxFavorito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCategorias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriasActionPerformed
        //Tomar una referencia al JFrame que contiene este panel
        Frame frameParent = Frame.getFrames()[0];  
        DialogListCategorias dialogListCategorias = new DialogListCategorias(frameParent, true);
        dialogListCategorias.setVisible(true);
        //Obtener la categoria que se ha seleccionado en la ventana de diálogo
        categoria = dialogListCategorias.getCategoriaSelec();
        showCategoria();
    }//GEN-LAST:event_jButtonCategoriasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JCheckBox jCheckBoxFavorito;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldClave;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCuota;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPaginaWeb;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
