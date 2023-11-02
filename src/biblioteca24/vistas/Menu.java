
package biblioteca24.vistas;

import biblioteca24.Entidades.Lector;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu extends javax.swing.JFrame {
    private Inicio inicioFrame;
    private boolean esAdministrador;
    public Menu(Inicio inicioFrame, boolean esAdmin) {
       initComponents(); 
       this.setLocationRelativeTo(null);
       this.setSize(1000, 730);
       this.inicioFrame = inicioFrame;
       this.esAdministrador = esAdmin;
       habilitarElementosDelMenu();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        ImageIcon icono = new ImageIcon(getClass().getResource("/biblioteca24/Recursos/libro-abierto-.jpg"));
        Image miImagen = icono.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){

                g.drawImage(miImagen,0,0,getWidth(),getHeight(),this);

            }
        };
        jMenuBar2 = new javax.swing.JMenuBar();
        jMLibro = new javax.swing.JMenu();
        jmBuscar = new javax.swing.JMenuItem();
        jMLectores = new javax.swing.JMenu();
        jmiActDatos = new javax.swing.JMenuItem();
        jMPrestamos = new javax.swing.JMenu();
        jmDevolver = new javax.swing.JMenuItem();
        jmAdmin = new javax.swing.JMenu();
        jmiLibro = new javax.swing.JMenuItem();
        jmiEjemplar = new javax.swing.JMenuItem();
        jmiFicheros = new javax.swing.JMenuItem();
        jmiMovimientos = new javax.swing.JMenuItem();
        jMCerrarSesion = new javax.swing.JMenu();
        jmiCerrarS = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        jMLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/libros (2).png"))); // NOI18N
        jMLibro.setText("Libros");
        jMLibro.setMaximumSize(new java.awt.Dimension(200, 32767));

        jmBuscar.setText("Buscar");
        jmBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBuscarActionPerformed(evt);
            }
        });
        jMLibro.add(jmBuscar);

        jMenuBar2.add(jMLibro);

        jMLectores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/lector.png"))); // NOI18N
        jMLectores.setText("Lectores");
        jMLectores.setMaximumSize(new java.awt.Dimension(200, 32767));

        jmiActDatos.setText("Actualizar Datos");
        jmiActDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiActDatosActionPerformed(evt);
            }
        });
        jMLectores.add(jmiActDatos);

        jMenuBar2.add(jMLectores);

        jMPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/pedir-prestado.png"))); // NOI18N
        jMPrestamos.setText("Préstamos");
        jMPrestamos.setMaximumSize(new java.awt.Dimension(200, 32767));

        jmDevolver.setText("Devolver");
        jmDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDevolverActionPerformed(evt);
            }
        });
        jMPrestamos.add(jmDevolver);

        jMenuBar2.add(jMPrestamos);

        jmAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/administrador.png"))); // NOI18N
        jmAdmin.setText("Administración");
        jmAdmin.setMaximumSize(new java.awt.Dimension(200, 32767));
        jmAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAdminActionPerformed(evt);
            }
        });

        jmiLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/libro-item.png"))); // NOI18N
        jmiLibro.setText(" Libro + -");
        jmiLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLibroActionPerformed(evt);
            }
        });
        jmAdmin.add(jmiLibro);

        jmiEjemplar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/ejemplar.png"))); // NOI18N
        jmiEjemplar.setText("Ejemplar + -");
        jmiEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEjemplarActionPerformed(evt);
            }
        });
        jmAdmin.add(jmiEjemplar);

        jmiFicheros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/datos-del-usuario.png"))); // NOI18N
        jmiFicheros.setText("Alta/Baja Lector");
        jmiFicheros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFicherosActionPerformed(evt);
            }
        });
        jmAdmin.add(jmiFicheros);

        jmiMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/libro.png"))); // NOI18N
        jmiMovimientos.setText("Movimientos");
        jmiMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMovimientosActionPerformed(evt);
            }
        });
        jmAdmin.add(jmiMovimientos);

        jMenuBar2.add(jmAdmin);

        jMCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        jMCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca24/Recursos/cerrar-sesion.png"))); // NOI18N
        jMCerrarSesion.setText("Cerrar Sesión");
        jMCerrarSesion.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMCerrarSesion.setMaximumSize(new java.awt.Dimension(200, 32767));

        jmiCerrarS.setText("Cerrar Sesión");
        jmiCerrarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCerrarSActionPerformed(evt);
            }
        });
        jMCerrarSesion.add(jmiCerrarS);

        jMenuBar2.add(jMCerrarSesion);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLibroActionPerformed
        EditarLibro editar = new EditarLibro();
        editar.setVisible(true);
        escritorio.add(editar);
        escritorio.moveToFront(editar);
    }//GEN-LAST:event_jmiLibroActionPerformed

    private void jmiMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMovimientosActionPerformed
       Consultas consulta = new Consultas();
       consulta.setVisible(true);
       escritorio.add(consulta);
       escritorio.moveToFront(consulta);
    }//GEN-LAST:event_jmiMovimientosActionPerformed

    private void jmiActDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiActDatosActionPerformed
       EditarLector editar = new EditarLector(inicioFrame);
       editar.setVisible(true);
       escritorio.add(editar);
       escritorio.moveToFront(editar);
    }//GEN-LAST:event_jmiActDatosActionPerformed

    private void jmiCerrarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCerrarSActionPerformed
       if (esAdministrador) {
        // tengo que ver como lo cierro
            this.dispose();
            inicioFrame.setVisible(true);
        } else {
            mostrarDialogoCerrarSesion();
        } 
    }//GEN-LAST:event_jmiCerrarSActionPerformed

    private void jmAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAdminActionPerformed
        //aca lo otro
    }//GEN-LAST:event_jmAdminActionPerformed

    private void jmiEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEjemplarActionPerformed
        EditarEjemplar editarE = new EditarEjemplar();
        editarE.setVisible(true);
        escritorio.add(editarE);
        escritorio.moveToFront(editarE);
    }//GEN-LAST:event_jmiEjemplarActionPerformed

    private void jmiFicherosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFicherosActionPerformed
        AltaBajaL baja = new AltaBajaL();
        baja.setVisible(true);
        escritorio.add(baja);
        escritorio.moveToFront(baja);
    }//GEN-LAST:event_jmiFicherosActionPerformed

    private void jmBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBuscarActionPerformed
        BuscarL buscar = new BuscarL();
        buscar.setVisible(true);
        escritorio.add(buscar);
        escritorio.moveToFront(buscar);
    }//GEN-LAST:event_jmBuscarActionPerformed

    private void jmDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDevolverActionPerformed
        Devolver devolver = new Devolver();
        devolver.setVisible(true);
        escritorio.add(devolver);
        escritorio.moveToFront(devolver);
    }//GEN-LAST:event_jmDevolverActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Inicio inicioFrame = new Inicio();
        boolean esAdmin = true;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(inicioFrame, esAdmin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMCerrarSesion;
    private javax.swing.JMenu jMLectores;
    private javax.swing.JMenu jMLibro;
    private javax.swing.JMenu jMPrestamos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jmAdmin;
    private javax.swing.JMenuItem jmBuscar;
    private javax.swing.JMenuItem jmDevolver;
    private javax.swing.JMenuItem jmiActDatos;
    private javax.swing.JMenuItem jmiCerrarS;
    private javax.swing.JMenuItem jmiEjemplar;
    private javax.swing.JMenuItem jmiFicheros;
    private javax.swing.JMenuItem jmiLibro;
    private javax.swing.JMenuItem jmiMovimientos;
    // End of variables declaration//GEN-END:variables
   private void habilitarElementosDelMenu() {
        // Habilitar o deshabilitar elementos del menú según si es un administrador o no
        jmAdmin.setEnabled(esAdministrador); 
        jmiLibro.setEnabled(esAdministrador); 
        jmiFicheros.setEnabled(esAdministrador); 
        jmiMovimientos.setEnabled(esAdministrador); 
    }
   public void mostrarDialogoCerrarSesion() {
    Lector lectorActual = inicioFrame.getLectorActual();

        if (lectorActual != null) {
            String mensaje = "Cerrar sesión de " + lectorActual.getNombre() + " " + lectorActual.getApellido() + "?";
            int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                inicioFrame.setLectorActual(null);
                this.dispose();
                inicioFrame.setVisible(true);
            }
        } else {
             //si es nulo
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el lector actual.");
        }
    }
 
 
}
