package Modelo;

/**
 *
 * @author sergi.carmona
 */
public class Premios {
    private String nombrePremio;
    private String ciudad;
    
    public Premios(){
        this.nombrePremio = "";
        this.ciudad = "";
    }
    
    public Premios(String nombre, String ciudad){
        this.nombrePremio = nombre;
        this.ciudad = ciudad;
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public void setNombrePremio(String nombrePremio) {
        this.nombrePremio = nombrePremio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
