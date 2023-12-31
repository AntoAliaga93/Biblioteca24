/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca24.vistas;

import biblioteca24.Entidades.Lector;
import biblioteca24.accesoADatos.LectorData;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AltaBajaL extends javax.swing.JInternalFrame {
    private LectorData lD = new LectorData();
    private Lector lector;
    private Lector lectorSelec;
    private int dniSelec;
    private DefaultTableModel modelo = new DefaultTableModel();
    public AltaBajaL() {
        initComponents();
        lector = null;
        lectorSelec = null;
        armarCabecera();
        cargarTabla();
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
        jSeparator1 = new javax.swing.JSeparator();
        jbDesactivar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbActivar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Activar/Desactivar un lector");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        jbDesactivar.setBackground(new java.awt.Color(0, 0, 0));
        jbDesactivar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jbDesactivar.setForeground(new java.awt.Color(0, 0, 0));
        jbDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/dejar-de-seguir.png"))); // NOI18N
        jbDesactivar.setBorder(null);
        jbDesactivar.setBorderPainted(false);
        jbDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesactivarActionPerformed(evt);
            }
        });

        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/eliminar (2).png"))); // NOI18N
        jbCerrar.setBorderPainted(false);
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar por apellido:");

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

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Desactivar");

        jbActivar.setBackground(new java.awt.Color(0, 0, 0));
        jbActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/verificado.png"))); // NOI18N
        jbActivar.setBorder(null);
        jbActivar.setBorderPainted(false);
        jbActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActivarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Activar");

        jbBuscar.setBackground(new java.awt.Color(0, 0, 0));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/lupa.png"))); // NOI18N
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbDesactivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbActivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
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

    private void jbDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesactivarActionPerformed
       if (dniSelec != 0) {
            lector = lD.buscarporDni(dniSelec);
            if (lector != null) {
                if (lector.isEstado()) {
                    lD.desactivarLector(dniSelec);
                    cargarTabla(); // Actualizar la tabla
                } else {
                    JOptionPane.showMessageDialog(null, "El lector ya está desactivado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el lector con el DNI especificado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            dniSelec = 0; // Reiniciar dniSelec después de la operación
            cargarTabla(); // Actualizar la tabla nuevamente
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbDesactivarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
         int filaSelec = jTabla.getSelectedRow();
        
        if (filaSelec != -1) {
            dniSelec = (int) modelo.getValueAt(filaSelec, 0);
            jbDesactivar.setEnabled(true);
            jbActivar.setEnabled(true); // Habilita ambos botones ya que hay una fila seleccionada.
        } else {
            jbDesactivar.setEnabled(false);
            jbActivar.setEnabled(false);
        }
    }//GEN-LAST:event_jTablaMouseClicked

    private void jbActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActivarActionPerformed
        if (dniSelec != 0) {
         lectorSelec = lD.buscarporDni(dniSelec);

            if (lectorSelec != null) {
                if (lectorSelec.isEstado()) {
                    JOptionPane.showMessageDialog(null, "El lector ya está activo.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    lD.activarLector(dniSelec);
                    cargarTabla(); // Actualizar la tabla
                }
            } else {
                JOptionPane.showMessageDialog(null, "El lector no se encuentra en la base de datos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            dniSelec = 0; // Reiniciar dniSelec después de la operación
            cargarTabla(); // Actualizar la tabla nuevamente
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbActivarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String apellidoBuscado = tfApellido.getText();

        if (!apellidoBuscado.isEmpty() && apellidoBuscado.matches("^[a-zA-Z]+$")) {
            List<Lector> lectores = lD.buscarPorApellido(apellidoBuscado);
            if (lectores.isEmpty()) {
                // Muestra un mensaje indicando que no se encontraron resultados
                JOptionPane.showMessageDialog(this, "No se encontraron lectores con el apellido ingresado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
            } else {
                modelo.setRowCount(0);
                for (Lector lector : lectores) {
                    modelo.addRow(new Object[]{
                        lector.getDni(), lector.getNombre(), lector.getApellido(), lector.isEstado()
                    });
                }
                jbDesactivar.setEnabled(false);
                jbActivar.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un apellido válido.", "Error", JOptionPane.ERROR_MESSAGE);
            cargarTabla();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabla;
    private javax.swing.JButton jbActivar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbDesactivar;
    private javax.swing.JTextField tfApellido;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera(){
        modelo.addColumn("DNI"); 
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Estado");
        jTabla.setModel(modelo);
    }
    
    private void cargarTabla(){
        List<Lector> lectores = lD.listarLectores();
        modelo.setRowCount(0);
        for (Lector lector : lectores) {
            modelo.addRow(new Object[]{
            lector.getDni(), lector.getNombre(), lector.getApellido(), lector.isEstado()
        });
        }
    }
}
