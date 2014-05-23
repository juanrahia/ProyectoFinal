/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorclaves;

import gestorclaves.render.CategoriaListRender;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class DialogListCategorias extends javax.swing.JDialog {
    //Creamos el objeto conexión
    private Connection conexion = null;
    //Constantes para la conexión a la base de datos
    private final String DB_HOST = "localhost";
    private final String DB_NAME = "gestor_claves";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
    //Objeto para el elemento seleccionado
    private Categoria categoriaSelec = null;
    
    //método para pasarle la categoraSelec al PanelDetalle
    public Categoria getCategoriaSelec(){
        return categoriaSelec;
    }
    

    public DialogListCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Centrar esta ventana respecto al padre
        setLocationRelativeTo(parent);
        //Conectar a la base de datos
        conectarBD();
        try {
            //Crear categorias
            crearCategorias();
        } catch (SQLException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Llamar al método que carga los objetos categoria en la lista
        loadList();
    }
    
    //Insertar categorias en la base de datos
    private void crearCategorias() throws SQLException{
        ResultSet rsCategorias = null;
        Statement stmt = null;
        try {
            stmt = conexion.createStatement();
            rsCategorias = stmt.executeQuery(
                "SELECT * FROM categoria");
        } catch (SQLException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }     
        if(rsCategorias.next()==false){
            stmt.executeUpdate(
                "INSERT INTO categoria(id_cat, categoria) VALUES (1,'Trabajo'),"
                    + "(2,'Informática'),(3,'Ocio'),(4,'Fotografia')");
        }
    }
    
    private void conectarBD(){
        try {
            //Conexión con la base datos mysql
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            conexion = DriverManager.getConnection(
//                       "jdbc:mysql://"+DB_HOST+"/"+DB_NAME, 
//                       DB_USER, DB_PASSWORD);
            
            //Al cambiar la base de datos cambia la conexión
            //Actualizamos los parametros de conexión(driever;create=true;user;password)
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conexion = DriverManager.getConnection(
                       "jdbc:derby:"+DB_NAME+";create=true"+
                       ";user="+DB_USER+";password="+DB_PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha encontrado la librería Derby", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (InstantiationException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (SQLException ex) {            
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    private void loadList(){
        //Crear un modelo para la lista
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        //Asignar el renderer para mostrar los objetos como se desea
        jList1.setCellRenderer(new CategoriaListRender());
        
        //De la base de datos, obtener todos los campos de la tabla categoria    
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rsCategorias = stmt.executeQuery(
                "SELECT * FROM categoria");
            while (rsCategorias.next()) {
                String nombre = rsCategorias.getString("categoria");
                int id = rsCategorias.getInt("id_cat");
                //Guardar el producto en la lista
                Categoria categoria =  new Categoria(id);
                categoria.setCategoria(nombre);
                listModel.addElement(categoria);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(DialogListCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButtonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButtonSeleccionar.setText("Seleccionar");
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSeleccionar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed
        //Guardar el producto que está seleccionado en la lista
        categoriaSelec = (Categoria)jList1.getSelectedValue();
        //Cerrar la ventana de diálogo
        setVisible(false);
        dispose();

    }//GEN-LAST:event_jButtonSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogListCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogListCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogListCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogListCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogListCategorias dialog = new DialogListCategorias(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
