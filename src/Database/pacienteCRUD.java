
package Database;

import Entities.Paciente;
import Files.readFile;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pacienteCRUD {
    
    private Connection conexionBD;
    private Statement consulta;
    private PreparedStatement transaccion;
    private ResultSet resultadosConsulta;
    private ResultSetMetaData rsMetaData;

    public pacienteCRUD() {
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
    
    public void insertPaciente(Paciente paciente){
        String query = "INSERT INTO paciente VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            transaccion = conexionBD.prepareStatement(query);
            transaccion.setString(1, paciente.getCvePaciente());
            transaccion.setString(2, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaRegistro()));
            transaccion.setString(3, paciente.getNombrePrimero());
            transaccion.setString(4, paciente.getNombreSegundo());
            transaccion.setString(5, paciente.getPrimerApellido());
            transaccion.setString(6, paciente.getSegundoApellido());
            transaccion.setString(7, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaNacimiento()));
            transaccion.setString(8, ""+paciente.getSexo());
            transaccion.setString(9, paciente.getCalle());
            transaccion.setInt(10, paciente.getNumero());
            transaccion.setString(11, paciente.getColonia());
            transaccion.setString(12, paciente.getMunicipio());
            transaccion.setString(13, paciente.getEstado());
            transaccion.setString(14, paciente.getTelefono());
            transaccion.setString(15, paciente.getCorreo());
            transaccion.setString(16, paciente.getFacebook());
            transaccion.execute();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Registro Guardado", "Conexion a BD", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro del paciente: "+sqle, "Pacientes [Base de Datos]", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertaPaciente(Paciente paciente){
        String query = "INSERT INTO paciente VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            Object values[] = paciente.toArrayDatos();
            transaccion = conexionBD.prepareStatement(query);
            for(int i = 0; i < values.length; i++){
                System.out.println(values[i]);
                if(i  == 7)
                    transaccion.setObject(i + 1, ""+values[i]);
                else
                    transaccion.setObject(i + 1, values[i]);
            }
            transaccion.execute();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Registro Guardado", "Conexion a BD", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar la conexión a la base de datos []: "+sqle, "Conexion a BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Paciente> buscaPaciente(){
        ArrayList<Paciente> listaPacientes = null;
        try{
            listaPacientes = new ArrayList();
            String query = "SELECT * FROM paciente";  
            consulta = conexionBD.createStatement();
            resultadosConsulta = consulta.executeQuery(query);
            rsMetaData = resultadosConsulta.getMetaData();
            while(resultadosConsulta.next()){
                Object[] datosPaciente = new Object[rsMetaData.getColumnCount()];
                for(int i = 0; i < rsMetaData.getColumnCount(); i++){
                    if(i == 7){
                        char sexo = resultadosConsulta.getString(i + 1).charAt(0);
                        datosPaciente[i] = sexo;
                        System.out.println(resultadosConsulta.getString(i + 1).charAt(0));
                    }else
                        datosPaciente[i] = resultadosConsulta.getObject(i + 1);
                }
                listaPacientes.add(new Paciente(datosPaciente));
            }
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta "+sqle, "Consulta de pacientes [Base de Datos]", JOptionPane.ERROR_MESSAGE);
        }
        return listaPacientes;
    }
    
    public ArrayList<Paciente> buscaPaciente(String pac){
        ArrayList<Paciente> listaPacientes = null;
        try{
            listaPacientes = new ArrayList();
            String query = "SELECT * FROM paciente WHERE "
                    + "primerNombre LIKE '%"+pac+"%' OR "
                    + "segundoNombre LIKE '%"+pac+"%' OR "
                    + "apellidoPaterno LIKE '%"+pac+"%' OR "
                    + "apellidoMaterno LIKE '%"+pac+"%'";  
            consulta = conexionBD.createStatement();
            resultadosConsulta = consulta.executeQuery(query);
            rsMetaData = resultadosConsulta.getMetaData();
            while(resultadosConsulta.next()){
                Object[] datosPaciente = new Object[rsMetaData.getColumnCount()];
                for(int i = 0; i < rsMetaData.getColumnCount(); i++){
                    if(i == 7){
                        char sexo = resultadosConsulta.getString(i + 1).charAt(0);
                        datosPaciente[i] = sexo;
                    }else
                        datosPaciente[i] = resultadosConsulta.getObject(i + 1);
                }
                listaPacientes.add(new Paciente(datosPaciente));
            }
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta "+sqle, "Consulta de pacientes [Base de Datos]", JOptionPane.ERROR_MESSAGE);
        }
        return listaPacientes;
    }
    
    public Paciente selecionaPaciente(String pac){
        Paciente paciente = null;
        try{
            String query = "SELECT * FROM paciente WHERE "
                    + "cvePaciente = '"+pac+"'";  
            consulta = conexionBD.createStatement();
            resultadosConsulta = consulta.executeQuery(query);
            rsMetaData = resultadosConsulta.getMetaData();
            while(resultadosConsulta.next()){
                Object[] datosPaciente = new Object[rsMetaData.getColumnCount()];
                for(int i = 0; i < rsMetaData.getColumnCount(); i++){
                    if(i == 7){
                        char sexo = resultadosConsulta.getString(i + 1).charAt(0);
                        datosPaciente[i] = sexo;
                    }else
                        datosPaciente[i] = resultadosConsulta.getObject(i + 1);
                }
                paciente = new Paciente(datosPaciente);
            }
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta "+sqle, "Consulta de pacientes [Base de Datos]", JOptionPane.ERROR_MESSAGE);
        }
        return paciente;
    }
    
    public void actualizaPaciente(Paciente paciente){
        String clave = paciente.getCvePaciente();
        String query = "UPDATE paciente SET "
                + "primerNombre = ?, "
                + "segundoNombre = ?, "
                + "apellidoPaterno = ?, "
                + "apellidoMaterno = ?, "
                + "fechaNacimiento = ?, "
                + "sexo = ?, "
                + "calle = ?, "
                + "numero = ?, "
                + "colonia = ?, "
                + "municipio = ?, "
                + "estado = ?, "
                + "telefono = ?, "
                + "correo = ?, "
                + "facebook = ? "
                + "WHERE cvePaciente = '"+clave+"'";
        try{
            transaccion = conexionBD.prepareStatement(query);
            transaccion.setString(1, paciente.getNombrePrimero());
            transaccion.setString(2, paciente.getNombreSegundo());
            transaccion.setString(3, paciente.getPrimerApellido());
            transaccion.setString(4, paciente.getSegundoApellido());
            System.out.println(new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaNacimiento()));
            transaccion.setString(5, new SimpleDateFormat("YYYY-MM-d").format(paciente.getFechaNacimiento()));
            transaccion.setString(6, ""+paciente.getSexo());
            transaccion.setString(7, paciente.getCalle());
            transaccion.setInt(8, paciente.getNumero());
            transaccion.setString(9, paciente.getColonia());
            transaccion.setString(10, paciente.getMunicipio());
            transaccion.setString(11, paciente.getEstado());
            transaccion.setString(12, paciente.getTelefono());
            transaccion.setString(13, paciente.getCorreo());
            transaccion.setString(14, paciente.getFacebook());
            transaccion.execute();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Registro Guardado", "Conexion a BD", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sqle){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro del paciente: "+sqle, "Pacientes [Base de Datos]", JOptionPane.ERROR_MESSAGE);
        }
    }
}
