
package Panels;

import Database.usuariosCRUD;
import Entities.Usuarios;
import java.awt.Color;

public class CreateUpdateUsuarios extends javax.swing.JInternalFrame {

    public String accion;
    
    public CreateUpdateUsuarios() {
        initComponents();
        this.setBackground(new Color(0,170,181));
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
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Usuarios");

        jLabel1.setFont(new java.awt.Font("Euphemia", 1, 14)); // NOI18N
        jLabel1.setText("Registro de Usuarios");

        jLabel2.setFont(new java.awt.Font("Euphemia", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Euphemia", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Euphemia", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Tipo de Cuenta:");

        cmbTipoCuenta.setFont(new java.awt.Font("Euphemia", 0, 11)); // NOI18N
        cmbTipoCuenta.setForeground(new java.awt.Color(0, 0, 102));
        cmbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Recepcion", "Produccion", "Gerencia" }));

        jLabel5.setFont(new java.awt.Font("Euphemia", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Activo:");

        cmbActivo.setFont(new java.awt.Font("Euphemia", 0, 11)); // NOI18N
        cmbActivo.setForeground(new java.awt.Color(0, 0, 102));
        cmbActivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));

        btGuardarRegistro.setFont(new java.awt.Font("Euphemia", 1, 11)); // NOI18N
        btGuardarRegistro.setForeground(new java.awt.Color(51, 51, 51));
        btGuardarRegistro.setText("Guardar Registro");
        btGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarRegistroActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/reguser.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btGuardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoCuenta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbActivo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
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
    private javax.swing.JLabel jLabel6;
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
