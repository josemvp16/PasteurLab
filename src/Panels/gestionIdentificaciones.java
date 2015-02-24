
package Panels;

import Database.identificacionesCRUD;
import Entities.Identificaciones;
import Main.MainWindow;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class gestionIdentificaciones extends javax.swing.JInternalFrame {

    private final String accion;
    
    public gestionIdentificaciones() {
        initComponents();
        cargarIdentificaciones();
        accion = "Nuevo";
    }
    
    public gestionIdentificaciones(String opc) {
        initComponents();
        cargarIdentificaciones();
        accion = opc;
        btnNuevo.setText("Seleccionar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        Actualizar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaIdentificaciones = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        popMenu.add(Actualizar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        popMenu.add(Eliminar);

        setClosable(true);
        setTitle("Identificaciones");
        setInheritsPopupMenu(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        jLabel1.setText("Identificación:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("(ingresa los datos de identificación)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblListaIdentificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ClaveID", "PrimerNombre", "SegundoNombre", "ApellidoPaterno", "ApellidoMaterno", "Calle", "Numero", "Colonia", "Ciudad", "Municipio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaIdentificaciones.setComponentPopupMenu(popMenu);
        jScrollPane2.setViewportView(tblListaIdentificaciones);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if(!accion.equals("Seleccionar")){
            CreateUpdateIdentificaciones create = new CreateUpdateIdentificaciones();
            create.show();
            MainWindow.MainDesktop.add(create);
            create.toFront();
        }else{
            DefaultTableModel modelo = (DefaultTableModel)tblListaIdentificaciones.getModel();
            CreateUpdatePacientes.txtClaveID.setText(modelo.getValueAt(tblListaIdentificaciones.getSelectedRow(), 0).toString());
            this.dispose();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)tblListaIdentificaciones.getModel();
        String claveID = modelo.getValueAt(tblListaIdentificaciones.getSelectedRow(), 0).toString();
        identificacionesCRUD idCRUD = new identificacionesCRUD();
        CreateUpdateIdentificaciones update = new CreateUpdateIdentificaciones(idCRUD.read(claveID));
        idCRUD.closeCRUD();
        update.show();
        MainWindow.MainDesktop.add(update);
        update.toFront();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)tblListaIdentificaciones.getModel();
        String claveID = modelo.getValueAt(tblListaIdentificaciones.getSelectedRow(), 0).toString();
        identificacionesCRUD idCRUD = new identificacionesCRUD();
        idCRUD.delete(idCRUD.read(claveID));
        idCRUD.closeCRUD();
        cargarIdentificaciones();
    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Actualizar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPopupMenu popMenu;
    private static javax.swing.JTable tblListaIdentificaciones;
    // End of variables declaration//GEN-END:variables

    public static void cargarIdentificaciones() {
        identificacionesCRUD idCRUD = new identificacionesCRUD();
        ArrayList<Identificaciones> listaIdentificaciones = idCRUD.read();
        idCRUD.closeCRUD();
        DefaultTableModel modelo = (DefaultTableModel)tblListaIdentificaciones.getModel();
        for(int i = modelo.getRowCount() - 1; i >= 0; i--)
            modelo.removeRow(i);
        listaIdentificaciones.stream().forEach((listaIdentificacion) -> {
            modelo.addRow(listaIdentificacion.toArray());
        });
    }

}
