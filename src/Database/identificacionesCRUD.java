
package Database;

import Entities.Identificaciones;
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

public class identificacionesCRUD {
    
    private Connection conexionBD;
    private Statement consulta;
    private PreparedStatement transaccion;
    private ResultSet resultadoConsulta;

    public identificacionesCRUD() {
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
    
    public boolean create(Identificaciones identificacion) {
        try{
            String query = "INSERT INTO identificaciones VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            String[] valores = identificacion.toArray();
            transaccion = conexionBD.prepareStatement(query);
            for(int i = 0; i < valores.length; i++)
                transaccion.setString(i + 1, valores[i]);
            transaccion.execute();
            new Mensajes("El registro de identificacion se creo exitosamente!","Identificaciones").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Identificaciones").showMensaje(1);
            return false;
        }
    }

    public Identificaciones read(String id) {
        try{
            String query = "SELECT * FROM identificaciones WHERE ClaveID = '"+id+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            String[] valores = new String[11];
            if(resultadoConsulta.next()){
                for(int i = 0; i < valores.length; i++)
                    valores[i] = resultadoConsulta.getString(i+1);
                return new Identificaciones(valores);
            }else{
                new Mensajes("No se encuentra el registro de identificación: "+id,"Identificaciones").showMensaje(0);
                return null;
            }
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Identificaciones").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Identificaciones> read(String campo, String valor) {
        try{
            ArrayList<Identificaciones> listaIdentificaciones = new ArrayList();
            String query = "SELECT * FROM identificaciones WHERE "+campo+" = '"+valor+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            String[] valores = new String[11];
            while(resultadoConsulta.next()){
                for(int i = 0; i < valores.length; i++)
                    valores[i] = resultadoConsulta.getString(i+1);
                listaIdentificaciones.add(new Identificaciones(valores));
            }   
            return listaIdentificaciones;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Identificaciones").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Identificaciones> read() {
        try{
            ArrayList<Identificaciones> listaIdentificaciones = new ArrayList();
            String query = "SELECT * FROM identificaciones";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            String[] valores = new String[11];
            while(resultadoConsulta.next()){
                for(int i = 0; i < valores.length; i++)
                    valores[i] = resultadoConsulta.getString(i+1);
                listaIdentificaciones.add(new Identificaciones(valores));
            }   
            return listaIdentificaciones;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Identificaciones").showMensaje(1);
            return null;
        }
    }

    public boolean update(Identificaciones identificacion) {
        try{
            String query = "UPDATE identificaciones SET "
                    + "PrimerNombre = ?, "
                    + "SegundoNombre = ?, "
                    + "ApellidoPaterno = ?, "
                    + "ApellidoMaterno = ?, "
                    + "Calle = ?, "
                    + "Numero = ?, "
                    + "Colonia = ?, "
                    + "Ciudad = ?, "
                    + "Municipio = ?, "
                    + "Estado = ? "
                    + "WHERE ClaveID = '"+identificacion.getClaveID()+"'";
            transaccion = conexionBD.prepareStatement(query);
            String[] valores = identificacion.toArray();
            for(int i = 1; i < valores.length; i++)
                transaccion.setString(i, valores[i]);
            transaccion.execute();
            new Mensajes("El registro de identificación se actualizo exitosamente!","Identificaciones").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Identificaciones").showMensaje(1);
            return false;
        }
    }

    public boolean delete(Identificaciones identificacion) {
        try{
            String query = "DELETE FROM identificaciones "
                    + "WHERE ClaveID = '"+identificacion.getClaveID()+"'";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.execute();
            new Mensajes("El registro de identificación se elimino exitosamente!","Identificaciones").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Identificaciones").showMensaje(1);
            return false;
        }
    }
    
    public void closeCRUD() {
        try {
            conexionBD.close();
        } catch (SQLException sqle) {
            new Mensajes("Error: " + sqle.getMessage(),"Identificaciones").showMensaje(1);
        }
    }
}
