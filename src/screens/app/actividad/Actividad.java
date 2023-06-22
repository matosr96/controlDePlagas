package screens.app.actividad;

import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Metodos;

public class Actividad extends javax.swing.JFrame {

    private Metodos metodos;

    public Actividad() {
        initComponents();
        metodos = new Metodos();
        cargarTabla();
        setLocationRelativeTo(null);

    }

    public void cargarTabla() {

        ResultSet rs = metodos.consultaActividadPorUbicacion("TODO");

        try {

            DefaultTableModel tabla = (DefaultTableModel) tablaActividades.getModel();
            tabla.setRowCount(0);

            Object[] reg = new Object[7];

            while (rs.next()) {

                reg[0] = rs.getString(1);
                reg[1] = rs.getString(2);
                reg[2] = rs.getString(3);
                reg[3] = rs.getString(4);
                reg[4] = rs.getString(5);
                reg[5] = rs.getString(6);
                reg[6] = rs.getString(7);

                tabla.addRow(reg);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, e);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();
        botonRedirigirCrearInsumo = new javax.swing.JButton();
        botonActualizarTabla = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 55, 77));

        tablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "UBICACION", "FECHA", "INSUMO", "PLAGA", "RESULTADO", "RESPONSABLE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaActividades);

        botonRedirigirCrearInsumo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonRedirigirCrearInsumo.setText("NUEVA ACTIVIDAD");
        botonRedirigirCrearInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRedirigirCrearInsumoActionPerformed(evt);
            }
        });

        botonActualizarTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonActualizarTabla.setText("ACTUALIZAR TABLA");
        botonActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarTablaActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/caneca.png"))); // NOI18N
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonRedirigirCrearInsumo)
                        .addGap(18, 18, 18)
                        .addComponent(botonActualizarTabla)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1218, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRedirigirCrearInsumo)
                    .addComponent(botonActualizarTabla))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEliminar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRedirigirCrearInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRedirigirCrearInsumoActionPerformed
        CrearActividad form = new CrearActividad();
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRedirigirCrearInsumoActionPerformed

    private void botonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarTablaActionPerformed
        cargarTabla();
    }//GEN-LAST:event_botonActualizarTablaActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        DefaultTableModel model;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        Statement sent;

        try {
            int fila = tablaActividades.getSelectedRow();

            if (fila == -1) {
                // No se ha seleccionado ninguna fila
                JOptionPane.showMessageDialog(null, "Selecciona una actividad para eliminar");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar la actividad?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM ACTIVIDAD WHERE id =" + tablaActividades.getValueAt(fila, 0).toString();
                sent = cn.createStatement();
                int n = sent.executeUpdate(sql);

                if (n > 0) {
                    cargarTabla();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarTabla;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRedirigirCrearInsumo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaActividades;
    // End of variables declaration//GEN-END:variables
}
