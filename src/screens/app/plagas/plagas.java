package screens.app.plagas;

import database.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilidades.Metodos;

public class plagas extends javax.swing.JFrame {

    private Metodos metodos;

    public plagas() {
        initComponents();
        metodos = new Metodos();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    public void cargarTabla() {

        ResultSet rs = metodos.consultaPlagaPorNombre("TODO");

        try {

            DefaultTableModel tabla = (DefaultTableModel) tablaPlagas.getModel();
            tabla.setRowCount(0);

            Object[] reg = new Object[3];

            while (rs.next()) {

                reg[0] = rs.getString(1);
                reg[1] = rs.getString(2);
                reg[2] = rs.getString(3);

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
        tablaPlagas = new javax.swing.JTable();
        botonRedirigirCrearPlaga = new javax.swing.JButton();
        botonActualizarTabla = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 55, 77));

        tablaPlagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPlagas);

        botonRedirigirCrearPlaga.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonRedirigirCrearPlaga.setText("REGISTRAR PLAGA");
        botonRedirigirCrearPlaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRedirigirCrearPlagaActionPerformed(evt);
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
                        .addComponent(botonRedirigirCrearPlaga)
                        .addGap(18, 18, 18)
                        .addComponent(botonActualizarTabla)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRedirigirCrearPlaga)
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

    private void botonRedirigirCrearPlagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRedirigirCrearPlagaActionPerformed
        crearPlaga form = new crearPlaga();
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonRedirigirCrearPlagaActionPerformed

    private void botonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarTablaActionPerformed
        cargarTabla();
    }//GEN-LAST:event_botonActualizarTablaActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        DefaultTableModel model;
        Conexion cc = new Conexion();
        Connection cn = cc.getConnection();
        Statement sent;

        try {
            int fila = tablaPlagas.getSelectedRow();

            if (fila == -1) {
                // No se ha seleccionado ninguna fila
                JOptionPane.showMessageDialog(null, "Selecciona un insumo para eliminar");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el insumo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM PLAGAS WHERE id =" + tablaPlagas.getValueAt(fila, 0).toString();
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
            java.util.logging.Logger.getLogger(plagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(plagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(plagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(plagas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new plagas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarTabla;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonRedirigirCrearPlaga;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlagas;
    // End of variables declaration//GEN-END:variables
}
