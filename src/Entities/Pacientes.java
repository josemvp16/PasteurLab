
package Entities;

import java.util.Date;

public class Pacientes {
    
    private Identificaciones identificacion;
    private Date fechaNacimiento;
    private String telefono;
    private String sexo;
    private String correoElectronico;
    private String facebook;
    private Date fechaRegistro;

    public Pacientes() {
    }

    public Pacientes(Identificaciones identificacion, Date fechaNacimiento, String telefono, String sexo, String correoElectronico, String facebook, Date fechaRegistro) {
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.correoElectronico = correoElectronico;
        this.facebook = facebook;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Pacientes(Object[] valores) {
        this.identificacion = (Identificaciones)valores[0];
        this.fechaNacimiento = (Date)valores[1];
        this.telefono = (String)valores[2];
        this.sexo = (String)valores[3];
        this.correoElectronico = (String)valores[4];
        this.facebook = (String)valores[5];
        this.fechaRegistro = (Date)valores[6];
    }

    public Identificaciones getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificaciones identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    @Override
    public String toString() {
        return "Pacientes{" + "identificacion=" + identificacion + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", sexo=" + sexo + ", correoElectronico=" + correoElectronico + ", facebook=" + facebook + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    public Object[] toArray() {
        Object[] datos = {
            this.identificacion.getClaveID(),
            this.fechaNacimiento,
            this.telefono,
            this.sexo,
            this.correoElectronico,
            this.facebook,
            this.fechaRegistro
        };
        return datos;
    }
    
}
