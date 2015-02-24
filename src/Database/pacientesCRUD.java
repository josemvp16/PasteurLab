
package Database;

import Entities.Identificaciones;
import Entities.Pacientes;
import Files.readFile;
import Main.Mensajes;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pacientesCRUD {
    
    private Connection conexionBD;
    private Statement consulta;
    private PreparedStatement transaccion;
    private ResultSet resultadoConsulta;

    public pacientesCRUD() {
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
    
    public boolean create(Pacientes paciente) {
        try{
            String query = "INSERT INTO pacientes VALUES (?,?,?,?,?,?,?)";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.setString(1, paciente.getIdentificacion().getClaveID());
            transaccion.setString(2, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaNacimiento()));
            transaccion.setString(3, paciente.getTelefono());
            transaccion.setString(4, paciente.getSexo());
            transaccion.setString(5, paciente.getCorreoElectronico());
            transaccion.setString(6, paciente.getFacebook());
            transaccion.setString(7, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaRegistro()));
            transaccion.execute();
            new Mensajes("El registro de paciente se creo exitosamente!","Pacientes").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Pacientes").showMensaje(1);
            return false;
        }
    }

    public Pacientes read(Identificaciones id) {
        try{
            String query = "SELECT * FROM pacientes WHERE ClaveID = '"+id.getClaveID()+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            if(resultadoConsulta.next()){
                Pacientes paciente = new Pacientes();
                paciente.setIdentificacion(id);
                paciente.setFechaNacimiento(resultadoConsulta.getDate("FechaNacimiento"));
                paciente.setTelefono(resultadoConsulta.getString("Telefono"));
                paciente.setSexo(resultadoConsulta.getString("Sexo"));
                paciente.setCorreoElectronico(resultadoConsulta.getString("CorreoElectronico"));
                paciente.setFacebook(resultadoConsulta.getString("Facebook"));
                paciente.setFechaRegistro(resultadoConsulta.getDate("FechaRegistro"));
                return paciente;
            }else{
                new Mensajes("No se encuentra el registro de paciente: "+id.getClaveID(),"Pacientes").showMensaje(0);
                return null;
            }
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Pacientes").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Pacientes> read(String campo, String valor) {
        try{
            ArrayList<Pacientes> listaPacientes = new ArrayList();
            String query = "SELECT * FROM pacientes WHERE "+campo+" = '"+valor+"'";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            while(resultadoConsulta.next()){
                Pacientes paciente = new Pacientes();
                identificacionesCRUD idCRUD = new identificacionesCRUD();
                paciente.setIdentificacion(idCRUD.read(resultadoConsulta.getString("ClaveID")));
                idCRUD.closeCRUD();
                paciente.setFechaNacimiento(resultadoConsulta.getDate("FechaNacimiento"));
                paciente.setTelefono(resultadoConsulta.getString("Telefono"));
                paciente.setSexo(resultadoConsulta.getString("Sexo"));
                paciente.setCorreoElectronico(resultadoConsulta.getString("CorreoElectronico"));
                paciente.setFacebook(resultadoConsulta.getString("Facebook"));
                paciente.setFechaRegistro(resultadoConsulta.getDate("FechaRegistro"));
               listaPacientes.add(paciente);
            }   
            return listaPacientes;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Pacientes").showMensaje(1);
            return null;
        }
    }
    
    public ArrayList<Pacientes> read() {
        try{
            ArrayList<Pacientes> listaPacientes = new ArrayList();
            String query = "SELECT * FROM pacientes";
            consulta = conexionBD.createStatement();
            resultadoConsulta = consulta.executeQuery(query);
            while(resultadoConsulta.next()){
                Pacientes paciente = new Pacientes();
                identificacionesCRUD idCRUD = new identificacionesCRUD();
                paciente.setIdentificacion(idCRUD.read(resultadoConsulta.getString("ClaveID")));
                idCRUD.closeCRUD();
                paciente.setFechaNacimiento(resultadoConsulta.getDate("FechaNacimiento"));
                paciente.setTelefono(resultadoConsulta.getString("Telefono"));
                paciente.setSexo(resultadoConsulta.getString("Sexo"));
                paciente.setCorreoElectronico(resultadoConsulta.getString("CorreoElectronico"));
                paciente.setFacebook(resultadoConsulta.getString("Facebook"));
                paciente.setFechaRegistro(resultadoConsulta.getDate("FechaRegistro"));
               listaPacientes.add(paciente);
            }   
            return listaPacientes;
        }catch(SQLException sqle){
            new Mensajes("Error: "+sqle.getMessage(),"Pacientes").showMensaje(1);
            return null;
        }
    }

    public boolean update(Pacientes paciente) {
        try{
            String query = "UPDATE pacientes SET "
                    + "FechaNacimiento = ?, "
                    + "Telefono = ?, "
                    + "Sexo = ?, "
                    + "CorreoElectronico = ?, "
                    + "Facebook = ?, "
                    + "FechaRegistro = ? "
                    + "WHERE ClaveID = '"+paciente.getIdentificacion().getClaveID()+"'";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.setString(1, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaNacimiento()));
            transaccion.setString(2, paciente.getTelefono());
            transaccion.setString(3, paciente.getSexo());
            transaccion.setString(4, paciente.getCorreoElectronico());
            transaccion.setString(5, paciente.getFacebook());
            transaccion.setString(6, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaRegistro()));
            transaccion.execute();
            new Mensajes("El registro de paciente se actualizo exitosamente!","Pacientes").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Pacientes").showMensaje(1);
            return false;
        }
    }

    public boolean delete(Pacientes paciente) {
        try{
            String query = "DELETE FROM paciente "
                    + "WHERE ClaveID = '"+paciente.getIdentificacion().getClaveID()+"'";
            transaccion = conexionBD.prepareStatement(query);
            transaccion.execute();
            new Mensajes("El registro de paciente se elimino exitosamente!","Pacientes").showMensaje(0);
            return true;
        }catch(SQLException sqle){
            new Mensajes("Error: " + sqle.getMessage(),"Pacientes").showMensaje(1);
            return false;
        }
    }
    
    public void closeCRUD() {
        try {
            conexionBD.close();
        } catch (SQLException sqle) {
            new Mensajes("Error: " + sqle.getMessage(),"Pacientes").showMensaje(1);
        }
    }
}
