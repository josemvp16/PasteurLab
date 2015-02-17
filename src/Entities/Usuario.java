
package Entities;

public class Usuario {
    private String nombre;
    private String contrasena;
    private String tipoCuenta;
    private char activo;

    public Usuario() {
        
    }

    public Usuario(String nombre, String contrasena, String tipoCuenta, char activo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tipoCuenta = tipoCuenta;
        this.activo = activo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }
    
}
