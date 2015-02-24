
package Entities;

public class Identificaciones {
    
    private String ClaveID;
    private String PrimerNombre;
    private String SegundoNombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Calle;
    private String Numero;
    private String Colonia;
    private String Ciudad;
    private String Municipio;
    private String Estado;

    public Identificaciones() {
    }

    public Identificaciones(String ClaveID, String PrimerNombre, String SegundoNombre, String ApellidoPaterno, String ApellidoMaterno, String Calle, String Numero, String Colonia, String Ciudad, String Municipio, String Estado) {
        this.ClaveID = ClaveID;
        this.PrimerNombre = PrimerNombre;
        this.SegundoNombre = SegundoNombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.Ciudad = Ciudad;
        this.Municipio = Municipio;
        this.Estado = Estado;
    }
    
    public Identificaciones(String[] valores){
        this.ClaveID = valores[0];
        this.PrimerNombre = valores[1];
        this.SegundoNombre = valores[2];
        this.ApellidoPaterno = valores[3];
        this.ApellidoMaterno = valores[4];
        this.Calle = valores[5];
        this.Numero = valores[6];
        this.Colonia = valores[7];
        this.Ciudad = valores[8];
        this.Municipio = valores[9];
        this.Estado = valores[10];
    }

    public String getClaveID() {
        return ClaveID;
    }

    public void setClaveID(String ClaveID) {
        this.ClaveID = ClaveID;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Identificaciones{" + "ClaveID=" + ClaveID + ", PrimerNombre=" + PrimerNombre + ", SegundoNombre=" + SegundoNombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", Calle=" + Calle + ", Numero=" + Numero + ", Colonia=" + Colonia + ", Ciudad=" + Ciudad + ", Municipio=" + Municipio + ", Estado=" + Estado + '}';
    }
    
    public String[] toArray() {
        String[] datos = {
            this.ClaveID,
            this.PrimerNombre,
            this.SegundoNombre,
            this.ApellidoPaterno,
            this.ApellidoMaterno,
            this.Calle,
            this.Numero,
            this.Colonia,
            this.Ciudad,
            this.Municipio,
            this.Estado,
        };
        return datos;
    }
    
}
