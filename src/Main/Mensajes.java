
package Main;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Mensajes {
    
    private String titulo;
    private String mensaje;
    private int tipo;

    public Mensajes() {
    }

    public Mensajes(String titulo, String mensaje) {
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int t) {
        switch(t){
            case 0:
                tipo = JOptionPane.INFORMATION_MESSAGE;
                break;
            case 1:
                tipo = JOptionPane.ERROR_MESSAGE;
                break;
        }
    }
    
    public void showMensaje(int t) {
        setTipo(t);
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, titulo, mensaje, tipo);
    }

}
