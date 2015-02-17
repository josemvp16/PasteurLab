
package Database;

import Entities.Usuario;
import Files.readFile;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class usuarioSesion {
    
    private ConexionSGBD connect;
    private Connection conexionBD;
    private Statement consulta;
    private PreparedStatement transaccion;
    private ResultSet resultadosConsulta;
    private ResultSetMetaData rsMetaData;
    
    public usuarioSesion(){
        try{
            readFile archivoConexion = new readFile();
            String datosConexion[] = archivoConexion.getConnectionData();            
            connect = new ConexionSGBD(datosConexion[0],datosConexion[1],datosConexion[2],datosConexion[3]);
            conexionBD = connect.ConectToDatabase();
        }catch(Exception e){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se encuentran los datos de conexión: "+e, "Datos Conexión [Archivos]", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Usuario startSesion(String usr, String psw){
        String query = "SELECT * FROM usuario WHERE nombre='"+ usr +"' AND contrasena='"+ psw +"'";
        Usuario user = null;
        try{
            consulta = conexionBD.createStatement();
            resultadosConsulta = consulta.executeQuery(query);
            if(resultadosConsulta.next()){
                user = new Usuario();
                user.setNombre(resultadosConsulta.getString("nombre"));
                user.setContrasena(resultadosConsulta.getString("contrasena"));
                user.setTipoCuenta(resultadosConsulta.getString("tipoCuenta"));
                user.setActivo(resultadosConsulta.getString("activo").charAt(0));
            }
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Datos Correctos");
            resultadosConsulta.close();
            consulta.close();
            conexionBD.close();
            connect.CloseConection();
            return user;
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta: "+sqle, "Usuarios [Base de Datos]", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
