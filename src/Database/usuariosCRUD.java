
package Database;

import Entities.Usuarios;
import Files.readFile;
import Main.Mensajes;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class usuariosCRUD {
    
    private Connection conexionBD;
    private Statement consulta;
    private PreparedStatement transaccion;
    private ResultSet resultadoConsulta;

    public usuariosCRUD() {
        try{
            readFile archivoConexion = new readFile();
            String datosConexion[] = archivoConexion.getConnectionData();            
            ConexionSGBD connect = new ConexionSGBD(datosConexion[0],datosConexion[1],datosConexion[2],datosConexion[3]);
            conexionBD = connect.ConectToDatabase();
        }catch(Exception e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se encuentran los datos de conexión: "+e, "Datos Conexión [Archivos]", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean create(Usuarios usuario) {
        try{
            String query = "INSERT INTO usuarios VALUES (?,?,?,?)";
            String[] valores = usuario.toArray();
            transaccion = conexionBD.prepareStatement(query);
            for(int i = 0; i < valores.length; i++)
                transaccion.setString(i + 1, valores[i]);
            transaccion.execute();
            new Mensajes("El registro de usuario se creo exitosamente!","Usuarios").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Usuarios").showMensaje(1);
            return false;
        }
    }

    public Usuarios read(String user) {
        try{
            Usuarios usuario = new Usuarios();
            String query = "SELECT * FROM usuarios WHERE usuario = '"+user+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            if(resultadoConsulta.next()){
                usuario.setUsuario(resultadoConsulta.getString("Usuario"));
                usuario.setContrasena(resultadoConsulta.getString("Contrasena"));
                usuario.setTipoCuenta(resultadoConsulta.getString("TipoCuenta"));
                usuario.setActivo(resultadoConsulta.getString("Activo"));
                return usuario;
            }else{
                new Mensajes("No se encuenra el registro de usuario: "+user,"Usuarios").showMensaje(0);
                return null;
            }
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Usuarios").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Usuarios> read(String campo, String valor) {
        try{
            ArrayList<Usuarios> listaUsuarios = new ArrayList();
            String query = "SELECT * FROM usuarios WHERE "+campo+" = '"+valor+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            while(resultadoConsulta.next()){
                Usuarios usuario = new Usuarios();
                usuario.setUsuario(resultadoConsulta.getString("Usuario"));
                usuario.setContrasena(resultadoConsulta.getString("Contrasena"));
                usuario.setTipoCuenta(resultadoConsulta.getString("TipoCuenta"));
                usuario.setActivo(resultadoConsulta.getString("Activo"));
                listaUsuarios.add(usuario);
            }   
            return listaUsuarios;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Usuarios").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Usuarios> read() {
        try{
            ArrayList<Usuarios> listaUsuarios = new ArrayList();
            String query = "SELECT * FROM usuarios";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            while(resultadoConsulta.next()){
                Usuarios usuario = new Usuarios();
                usuario.setUsuario(resultadoConsulta.getString("Usuario"));
                usuario.setContrasena(resultadoConsulta.getString("Contrasena"));
                usuario.setTipoCuenta(resultadoConsulta.getString("TipoCuenta"));
                usuario.setActivo(resultadoConsulta.getString("Activo"));
                listaUsuarios.add(usuario);
            }   
            return listaUsuarios;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Usuarios").showMensaje(1);
            return null;
        }
    }

    public boolean update(Usuarios usuario) {
        try{
            String query = "UPDATE usuarios SET "
                    + "Contrasena = ?, "
                    + "TipoCuenta = ?, "
                    + "Activo = ? "
                    + "WHERE Usuario = '"+usuario.getUsuario()+"'";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.setString(1, usuario.getContrasena());
            transaccion.setString(2, usuario.getTipoCuenta());
            transaccion.setString(3, usuario.getActivo());
            transaccion.execute();
            new Mensajes("El registro de usuario se actualizo exitosamente!","Usuarios").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Usuarios").showMensaje(1);
            return false;
        }
    }

    public boolean delete(Usuarios usuario) {
        try{
            String query = "DELETE FROM usuarios "
                    + "WHERE Usuario = '"+usuario.getUsuario()+"'";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.execute();
            new Mensajes("El registro de usuario se elimino exitosamente!","Usuarios").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Usuarios").showMensaje(1);
            return false;
        }
    }
    
    public void closeCRUD() {
        try {
            conexionBD.close();
        } catch (SQLException sqle) {
            new Mensajes("Error: " + sqle.getMessage(),"Usuarios").showMensaje(1);
        }
    }
}
