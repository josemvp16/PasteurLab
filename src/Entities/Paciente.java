
package Entities;

import java.util.Date;

public class Paciente {
    
    //Atributos
    private String cvePaciente;
    private Date fechaRegistro;
    private String nombrePrimero;
    private String nombreSegundo;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private char sexo;
    private String calle;
    private int numero;
    private String colonia;
    private String municipio;
    private String estado;
    private String telefono;
    private String correo;
    private String facebook;

    public Paciente(Object[] datos) {
        this.cvePaciente = (String)datos[0];
        this.fechaRegistro = (Date)datos[1];
        this.nombrePrimero = (String)datos[2];
        this.nombreSegundo = (String)datos[3];
        this.primerApellido = (String)datos[4];
        this.segundoApellido = (String)datos[5];
        this.fechaNacimiento = (Date)datos[6];
        this.sexo = (char)datos[7];
        this.calle = (String)datos[8];
        this.numero = (int)datos[9];
        this.colonia = (String)datos[10];
        this.municipio = (String)datos[11];
        this.estado = (String)datos[12];
        this.telefono = (String)datos[13];
        this.correo = (String)datos[14];
        this.facebook = (String)datos[15];
    }

    public Paciente(String cvePaciente, Date fechaRegistro, String nombrePrimero, String nombreSegundo, String primerApellido, String segundoApellido, Date fechaNacimiento, char sexo, String calle, int numero, String colonia, String municipio, String estado, String telefono, String correo, String facebook) {
        this.cvePaciente = cvePaciente;
        this.fechaRegistro = fechaRegistro;
        this.nombrePrimero = nombrePrimero;
        this.nombreSegundo = nombreSegundo;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.telefono = telefono;
        this.correo = correo;
        this.facebook = facebook;
    }
    
    public void setDatosPersonales(String cvp, Date fcr, String nmp, String nms, String pra, String sda, Date fcn, char sxo){
        this.cvePaciente = cvp;
        this.fechaRegistro = fcr;
        this.nombrePrimero = nmp;
        this.nombreSegundo = nms;
        this.primerApellido = pra;
        this.segundoApellido = sda;
        this.fechaNacimiento = fcn;
        this.sexo = sxo;
    }
    
    public void setDatosDireccion(String cll, int num, String col, String mun, String est, String tel, String cor, String fac){
        this.calle = cll;
        this.numero = num;
        this.colonia = col;
        this.municipio = mun;
        this.estado = est;
        this.telefono = tel;
        this.correo = cor;
        this.facebook = fac;
    }

    public String getCvePaciente() {
        return cvePaciente;
    }

    public void setCvePaciente(String cvePaciente) {
        this.cvePaciente = cvePaciente;
    }

    public String getNombrePrimero() {
        return nombrePrimero;
    }

    public void setNombrePrimero(String nombrePrimero) {
        this.nombrePrimero = nombrePrimero;
    }

    public String getNombreSegundo() {
        return nombreSegundo;
    }

    public void setNombreSegundo(String nombreSegundo) {
        this.nombreSegundo = nombreSegundo;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Object[] toArrayDatos(){
        Object[] datosPaciente = {
            this.cvePaciente,
            this.fechaRegistro,
            this.nombrePrimero,
            this.nombreSegundo,
            this.primerApellido,
            this.segundoApellido,
            this.fechaNacimiento,
            this.sexo,
            this.calle,
            this.numero,
            this.colonia,
            this.municipio,
            this.estado,
            this.telefono,
            this.correo,
            this.facebook
        }; 
        return datosPaciente;
    }
}
