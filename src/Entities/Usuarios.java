
package Entities;

public class Usuarios{
    
    private String Usuario;
    private String Contrasena;
    private String TipoCuenta;
    private String Activo;

    public Usuarios() {
    }

    public Usuarios(String Usuario, String Contrasena, String TipoCuenta, String Activo) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.TipoCuenta = TipoCuenta;
        this.Activo = Activo;
    }
    
    public Usuarios(String[] datos) {
        this.Usuario = datos[0];
        this.Contrasena = datos[1];
        this.TipoCuenta = datos[2];
        this.Activo = datos[3];
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "Usuario=" + Usuario + ", Contrasena=" + Contrasena + ", TipoCuenta=" + TipoCuenta + ", Activo=" + Activo + '}';
    }   
    
    public String[] toArray() {
        String[] arrayDatosUsuario = {
            this.Usuario,
            this.Contrasena,
            this.TipoCuenta,
            this.Activo
        };
        return arrayDatosUsuario;
    }
    
}
