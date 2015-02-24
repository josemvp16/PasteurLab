
package Panels;

import Database.usuariosCRUD;
import Entities.Usuarios;

public class CreateUpdateUsuarios extends javax.swing.JInternalFrame {

    public String accion;
    
    public CreateUpdateUsuarios() {
        initComponents();
        accion = "Crear";
    }
    
    public CreateUpdateUsuarios(Usuarios us) {
        initComponents();
        accion = "Actualizar";
        writeTextBoxes(us);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTipoCuenta = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbActivo = new javax.swing.JComboBox();
        btGuardarRegistro = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();

        setClosable(true);
        setTitle("Usuarios");

        jLabel1.setText("Registro de Usuarios");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        jLabel4.setText("Tipo de Cuenta:");

        cmbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Recepcion", "Produccion", "Gerencia" }));

        jLabel5.setText("Activo:");

        cmbActivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));

        btGuardarRegistro.setText("Guardar Registro");
        btGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btGuardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtUsuario)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(cmbTipoCuenta, 0, 200, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(cmbActivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContrasena)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGuardarRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarRegistroActionPerformed
        if(accion.equals("Crear")){
            usuariosCRUD userCRUD = new usuariosCRUD();
            userCRUD.create(readTextBoxes());
            userCRUD.closeCRUD();
            gestionUsuarios.cargarUsuarios();
            this.dispose();
        }else if(accion.equals("Actualizar")){
            usuariosCRUD userCRUD = new usuariosCRUD();
            userCRUD.update(readTextBoxes());
            userCRUD.closeCRUD();
            gestionUsuarios.cargarUsuarios();
            this.dispose();
        }
    }//GEN-LAST:event_btGuardarRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGuardarRegistro;
    private javax.swing.JComboBox cmbActivo;
    private javax.swing.JComboBox cmbTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private Usuarios readTextBoxes(){
        String[] datos = {
            txtUsuario.getText(),
            txtContrasena.getText(),
            cmbTipoCuenta.getSelectedItem().toString(),
            cmbActivo.getSelectedItem().toString()
        };
        return new Usuarios(datos);
    }

    private void writeTextBoxes(Usuarios us) {
        txtUsuario.setEditable(false);
        txtUsuario.setText(us.getUsuario());
        txtContrasena.setText(us.getContrasena());
        cmbTipoCuenta.setSelectedItem(us.getTipoCuenta());
        cmbActivo.setSelectedItem(us.getActivo());
    }
    
}
