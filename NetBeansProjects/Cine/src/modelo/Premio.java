package modelo;

/**
 *
 * @author gonzalo.detomas
 */
public class Premio {
    //Atributos
    protected String nombrePremio;//Usamos protected para que estos atributos solo sean visible por la clase padre e hija (no nieta)
    protected String ciudadPremio;
    //MC
        //Por defecto
    public Premio(){
        this.nombrePremio = "Oscar";
        this.ciudadPremio = "LA";
    }
        //Por parámetros
    public Premio(String nombrePremio, String ciudadPremio){
        this.nombrePremio = nombrePremio;
        this.ciudadPremio = ciudadPremio;
    }
    //Accedentes y mutadores

    public String getNombrePremio() {
        return nombrePremio;
    }

    public void setNombrePremio(String nombrePremio) {
        this.nombrePremio = nombrePremio;
    }

    public String getCiudadPremio() {
        return ciudadPremio;
    }

    public void setCiudadPremio(String ciudadPremio) {
        this.ciudadPremio = ciudadPremio;
    }
    
}
