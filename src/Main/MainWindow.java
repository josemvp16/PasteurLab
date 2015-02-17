
package Main;

import Database.ConexionSGBD;
import Entities.Usuario;
import Panels.createPaciente;
import Panels.inicioSesion;
import Panels.readPaciente;
import Files.readFile;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame {
    
    public static Usuario userSystem;

    public MainWindow() {
        initComponents();
        myInit(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        btnConectar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        MainDesktop = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        menuLabSystem = new javax.swing.JMenu();
        mniIniciarSesion = new javax.swing.JMenuItem();
        mniCerrarSesion = new javax.swing.JMenuItem();
        mniCambiarUsuario = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();
        menuPacientes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        leftPanel.setBackground(new java.awt.Color(0, 170, 181));

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap(551, Short.MAX_VALUE)
                .addComponent(btnConectar)
                .addContainerGap())
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackgroundImage.png"))); // NOI18N
        jLabel1.setOpaque(true);

        MainDesktop.setOpaque(false);

        menuLabSystem.setText("LabSystem");

        mniIniciarSesion.setText("Iniciar Sesión");
        mniIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniIniciarSesionActionPerformed(evt);
            }
        });
        menuLabSystem.add(mniIniciarSesion);

        mniCerrarSesion.setText("Cerrar Sesión");
        mniCerrarSesion.setEnabled(false);
        mniCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCerrarSesionActionPerformed(evt);
            }
        });
        menuLabSystem.add(mniCerrarSesion);

        mniCambiarUsuario.setText("Cambiar Usuario");
        mniCambiarUsuario.setEnabled(false);
        mniCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCambiarUsuarioActionPerformed(evt);
            }
        });
        menuLabSystem.add(mniCambiarUsuario);

        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        menuLabSystem.add(mniSalir);

        barraMenu.add(menuLabSystem);

        menuPacientes.setText("Pacientes");
        menuPacientes.setEnabled(false);

        jMenuItem1.setText("Registrar Paciente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPacientes.add(jMenuItem1);

        jMenuItem2.setText("Buscar Registro Paciente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuPacientes.add(jMenuItem2);

        barraMenu.add(menuPacientes);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 167, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(MainDesktop)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniIniciarSesionActionPerformed
        inicioSesion is = new inicioSesion();
        is.show();
        MainDesktop.add(is);
    }//GEN-LAST:event_mniIniciarSesionActionPerformed

    private void mniCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCambiarUsuarioActionPerformed
        activateSesion(false);
        enableAdmin(false);
        inicioSesion is = new inicioSesion();
        is.show();
        MainDesktop.add(is);
    }//GEN-LAST:event_mniCambiarUsuarioActionPerformed

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCerrarSesionActionPerformed
        activateSesion(false);
        enableAdmin(false);
    }//GEN-LAST:event_mniCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        createPaciente cp = new createPaciente();
        cp.show();
        MainDesktop.add(cp);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        readPaciente rp = new readPaciente();
        rp.show();
        MainDesktop.add(rp);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if(initDatabase()){
            btnConectar.setEnabled(false);
            myInit(true);
        }
    }//GEN-LAST:event_btnConectarActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane MainDesktop;
    private javax.swing.JMenuBar barraMenu;
    public static javax.swing.JButton btnConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JMenu menuLabSystem;
    public static javax.swing.JMenu menuPacientes;
    public static javax.swing.JMenuItem mniCambiarUsuario;
    public static javax.swing.JMenuItem mniCerrarSesion;
    public static javax.swing.JMenuItem mniIniciarSesion;
    public static javax.swing.JMenuItem mniSalir;
    // End of variables declaration//GEN-END:variables

    private void myInit(boolean st) {
        menuLabSystem.setEnabled(st);
    }

    public static void enableAdmin(boolean est){
        menuPacientes.setEnabled(est);
    }
    
    public static void activateSesion(boolean est){
        mniIniciarSesion.setEnabled(!est);
        mniCerrarSesion.setEnabled(est);
        mniCambiarUsuario.setEnabled(est);
        //mniSalir.setEnabled(est);
    }
    
    private boolean initDatabase(){
        try{
            readFile archivoConexion = new readFile();
            String datosConexion[] = archivoConexion.getConnectionData();
            ConexionSGBD conection = new ConexionSGBD(datosConexion[0],datosConexion[1],datosConexion[2],datosConexion[3]);
            conection.ConectToDatabase();
            conection.CloseConection();
            return true;
        }catch(Exception e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se encuentran los datos de conexión: "+e, "Datos Conexión [Archivos]", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
