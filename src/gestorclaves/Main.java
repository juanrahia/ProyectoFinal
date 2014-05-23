/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves;

import gestorclaves.render.CategoriaRender;
import gestorclaves.render.CuotaRender;
import gestorclaves.render.FavoritoRender;
import gestorclaves.render.FechaRender;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author usuario
 */
public class Main extends javax.swing.JFrame {

    //Instanciamos el modelo de la tabla
    ModeloTabla modelo;
    //Variable para diferenciar editar y crear nuevo a la hora de guardar
    boolean editarRegistro = false;
    
    //Método para guardar un registro nuevo
    private void guardarRegistroNuevo(){
        Entrada entrada = new Entrada();
        //Al panel le damos la entrada
        panelDetalle1.setEntrada(entrada);
        //A continuación le establecemos los datos
        panelDetalle1.setData();
        //Comineza la transacción
        entityManager1.getTransaction().begin(); 
        //Almacenar el objeto en la BD 
        entityManager1.persist(entrada); 
        entityManager1.getTransaction().commit();
        //Añadir el objeto al final de la lista de datos 
        list1.add(entrada); 
        //Informar al JTable que se ha insertado una fila al final 
        modelo.fireTableRowsInserted(list1.size()-1, list1.size()-1);
    }
    
    //Método para guardar un registro editado
    private void guardarRegistroEditado(){
        //Obtener el índice de la fila seleccionada en la tabla 
        int selectedRow = jTable1.getSelectedRow(); 
        //Obtener el objeto desde la lista de datos, conociendo su posición 
        Entrada entrada = list1.get(selectedRow); 
        //Rellenar sus datos 
        panelDetalle1.setData();
        //Comienza la transacción
        entityManager1.getTransaction().begin(); 
        //Actualizar el objeto en la BD 
        entityManager1.merge(entrada); 
        entityManager1.getTransaction().commit(); 
        //Añadir el objeto al final de la lista de datos 
        list1.set(selectedRow, entrada); 
        //Informar al JTable que se ha modificado la fila seleccionada 
        modelo.fireTableRowsUpdated(selectedRow, selectedRow);
    }
    
    
    public Main() {
        initComponents();
        
        //icono de la aplicacion
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/safe.png")).getImage());
        setTitle("Gestor de claves");
        //Evitar que se puedan editar los campos
        panelDetalle1.setEditable(false);
        //Creamos el modelo de la tabla
        modelo = new ModeloTabla();
        //Le damos la list1 de la base de datos
        modelo.setDataList(list1);
        //Se establece el modelo para el jTable1
        jTable1.setModel(modelo);
        
        //Control acceso de usuarios
        //Cargar archivo properties
        Properties properties = new Properties();
        String PROPERTIES_FILE = "properties.properties";
        try {
             properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
        } catch (IOException ex) {
            Logger.getLogger(AccesoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(properties.getProperty("esNuevo").equals("true")){
            RegistroUsuario registro = new RegistroUsuario(this, true);
            registro.setVisible(true);
        }else{
            AccesoUsuario acceso = new AccesoUsuario(this, true);
            acceso.setVisible(true);
        }
        
        //Pantalla centrada
        this.setLocationRelativeTo(null);
        
        //Alinear a la derecha las cantidades
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER );
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        //Dar formato a los favoritos
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new FavoritoRender());
        //Dar formato a las categorias
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new CategoriaRender());
        //Dar formato a las cuotas
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new CuotaRender());
        //Dar formato a las fechas
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new FechaRender());
        
        //Establecer los tamaños de las celdas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(125);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(74);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(65);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(65);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(63);
        
        
        //Permitir unicamente una selección de la tabla
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Método para que aparezcan automaticamente los campo al seleccionar
        //un item de la lista.
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                //Creamos el objeto entrada y lo inicializamos con la posicion
                //de la lista. Preguntamos que el indice sea mayor que -1.
                if(jTable1.getSelectedRow() > -1){
                    Entrada entrada = list1.get(jTable1.getSelectedRow());    
                    //Le pasamos el objeto entrada al panel
                    panelDetalle1.setEntrada(entrada);
                    //y mostramos sus datos
                    panelDetalle1.showData();
                }

            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("GestorClavesPU").createEntityManager();
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT e FROM Entrada e");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query1.getResultList();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNuevo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOpciones = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelDetalle1 = new gestorclaves.PanelDetalle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de claves");
        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setRollover(true);

        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jButtonNuevo.setFocusable(false);
        jButtonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNuevo);

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jButtonEditar.setFocusable(false);
        jButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEditar);

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jButtonGuardar.setFocusable(false);
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardar);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jButtonCancelar.setFocusable(false);
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonCancelar);

        jButtonOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/opciones.png"))); // NOI18N
        jButtonOpciones.setFocusable(false);
        jButtonOpciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOpciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpcionesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonOpciones);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Inicio", jScrollPane1);
        jTabbedPane1.addTab("Detalle", panelDetalle1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Obtener el indice de la fila seleccionada
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow>-1){
            //Obtener el objeto entrada del al lista
            Entrada entrada = list1.get(selectedRow);
            
            //Preguntar si se quiere borrar la entrada
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea borrar "+entrada.getNombre()+"?", "Borrar", JOptionPane.YES_NO_CANCEL_OPTION);
            if(respuesta==JOptionPane.YES_OPTION) {
                    //Iniciar una transacción con la BD
                    entityManager1.getTransaction().begin();
                    //Eliminar el objeto
                    entityManager1.remove(entrada);
                    //Finalizar la transacción
                    entityManager1.getTransaction().commit();
                    //Eliminar el objeto de la lista de datos
                    list1.remove(entrada);
                    //Informar al JTable que se ha eliminado una fila
                    modelo.fireTableRowsDeleted(selectedRow, selectedRow);
                    //Eliminar los datos del detalle
                    panelDetalle1.cleanData();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        panelDetalle1.cleanData();
        panelDetalle1.setEditable(true);
        jTable1.clearSelection();
        editarRegistro = false;
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if(this.editarRegistro){
            this.guardarRegistroEditado();
            panelDetalle1.setEditable(false);
            jTable1.clearSelection();
        }else{
            this.guardarRegistroNuevo();
            panelDetalle1.setEditable(false);
            jTable1.clearSelection();
        }
                
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if(jTable1.getSelectedRow()>-1){
            jTabbedPane1.setSelectedIndex(1);
            panelDetalle1.showData();
            panelDetalle1.setEditable(true);
            editarRegistro = true;
        }
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        panelDetalle1.cleanData();
        jTable1.clearSelection();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpcionesActionPerformed
        CambiarPassword cambiarPassword = new CambiarPassword(this, true);
        cambiarPassword.setVisible(true);
    }//GEN-LAST:event_jButtonOpcionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JButton jButtonOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private java.util.List<Entrada> list1;
    private gestorclaves.PanelDetalle panelDetalle1;
    private javax.persistence.Query query1;
    // End of variables declaration//GEN-END:variables
}
