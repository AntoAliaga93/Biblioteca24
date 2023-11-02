
package biblioteca24.vistas;

import biblioteca24.Entidades.Ejemplar;
import biblioteca24.Entidades.EstadoEjemplar;
import biblioteca24.Entidades.Libro;
import biblioteca24.accesoADatos.EjemplarData;
import biblioteca24.accesoADatos.LibroData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class EditarEjemplar extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private LibroData lD = new LibroData();
    private Libro libroSelec;
    private EjemplarData eD = new EjemplarData();
    private boolean botonHabilitado = true;  
    
    public EditarEjemplar() {
        initComponents();
        tfisbn.setEditable(false);
        tfisbn.setFocusable(false);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
        ui.setNorthPane(null);
        cargarCombo();
        armarCabecera();
        cargarComboLibro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfisbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbAgregar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jbModificar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jcomboE = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jbCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcomboLibro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registro de ejemplares");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ISBN:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado:");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jbAgregar.setBackground(new java.awt.Color(0, 0, 0));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/agregar (3).png"))); // NOI18N
        jbAgregar.setBorder(null);
        jbAgregar.setBorderPainted(false);
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Agregar");

        jbModificar.setBackground(new java.awt.Color(0, 0, 0));
        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/actualizarlibro.png"))); // NOI18N
        jbModificar.setBorder(null);
        jbModificar.setBorderPainted(false);
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Modificar");

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));

        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/eliminar (2).png"))); // NOI18N
        jbCerrar.setBorderPainted(false);
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Seleccione un libro:");

        jcomboLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboLibroLibroActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jcomboLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcomboLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/pila-de-libros.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/pila-de-libros.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12)))
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(68, 68, 68))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcomboE, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tfisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcomboE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(95, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
       String isbnStr = tfisbn.getText();
          
        if(isbnStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos");
            return;
        }
        EstadoEjemplar estado = (EstadoEjemplar) jcomboE.getSelectedItem();
        
        if (estado == EstadoEjemplar.SELECCIONAR) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un estado");
                return; 
        }
        int isbn = 0;
        isbn = Integer.parseInt(isbnStr);
        
        Libro libro = lD.buscarXisbn(isbn);
        List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
        Ejemplar ejemplar = new Ejemplar(libro, estado);
        ejemplares.add(ejemplar);
        eD.agregarEjemplar(ejemplar);
        
        tfisbn.setText("");
        jcomboE.setSelectedIndex(0);
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jcomboLibroLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboLibroLibroActionPerformed
        libroSelec = (Libro)jcomboLibro.getSelectedItem();
        if (libroSelec != null) {
            int isbn = libroSelec.getIsbn();
            cargarTabla(libroSelec);
            mostrarisbnCombo(isbn);
        }  
    }//GEN-LAST:event_jcomboLibroLibroActionPerformed
    private void cargarTabla(Libro libroSelec){
        int isbn = libroSelec.getIsbn();
        List<Ejemplar> ejemplares = eD.buscarEjemplares(isbn);
        //borro las filas que ya existen
        modelo.setRowCount(0);
        for (Ejemplar ejemplar : ejemplares) {
            modelo.addRow(new Object[]{
            ejemplar.getIdEjemplar(), ejemplar.getLibro().getIsbn(),ejemplar.getEstado()
        });
        }
    }
    
    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
        int filaSelec = jTabla.getSelectedRow();
        if(filaSelec !=-1){
            //aca obtengo los datos de la fila seleccionada
            int isbn = (Integer)jTabla.getValueAt(filaSelec, 1);
            EstadoEjemplar estado = (EstadoEjemplar) jTabla.getValueAt(filaSelec, 2);
            mostrarDatos(isbn, estado);
        }
    }//GEN-LAST:event_jTablaMouseClicked

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        EstadoEjemplar estado = (EstadoEjemplar) jcomboE.getSelectedItem();

        if (estado == EstadoEjemplar.SELECCIONAR) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estado");
            return;
        }

        int filaSeleccionada = jTabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un ejemplar para modificar");
            return;
        }

        int idEjemplar = (Integer) jTabla.getValueAt(filaSeleccionada, 0);
        // saco el ejemplar
        Ejemplar ejemplar = eD.obtenerEjemplarXid(idEjemplar);
        eD.modificarEjemplar(ejemplar);
        
        // Limpia los campos de texto después de actualizar
        tfisbn.setText("");
        jcomboE.setSelectedIndex(0);
    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbModificar;
    public static javax.swing.JComboBox<EstadoEjemplar> jcomboE;
    private javax.swing.JComboBox<Libro> jcomboLibro;
    public static javax.swing.JTextField tfisbn;
    // End of variables declaration//GEN-END:variables
    private void mostrarDatos(int isbn, EstadoEjemplar estado){
         tfisbn.setText(String.valueOf(isbn));
         jcomboE.setSelectedItem(estado);
    }
    private void mostrarisbnCombo(int isbn){
        tfisbn.setText(String.valueOf(isbn));
    }
    
    private void cargarCombo(){
        jcomboE.addItem(EstadoEjemplar.SELECCIONAR);
        jcomboE.addItem(EstadoEjemplar.DISPONIBLE);
        jcomboE.addItem(EstadoEjemplar.NO_DISPONIBLE);
        jcomboE.addItem(EstadoEjemplar.PRESTADO);
        jcomboE.addItem(EstadoEjemplar.REPARACION);
        jcomboE.addItem(EstadoEjemplar.RETRASO);
    }
    private void armarCabecera(){
        modelo.addColumn("ID Ejemplar");
        modelo.addColumn("ISBN");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Estado");
        jTabla.setModel(modelo);
    }
               
    private void cargarComboLibro(){
        List<Libro> libros = lD.listarLibros();
        for (Libro libro : libros) {
            jcomboLibro.addItem(libro);
        }
    }
}
