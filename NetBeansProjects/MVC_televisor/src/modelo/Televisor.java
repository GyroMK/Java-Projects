package modelo;

/**
 *
 * @author sergi.carmona
 */
public class Televisor {

    public enum Nombre {
        SAMSUNG, LG, PHILIPS, SONY
    }

    private String modelo;
    private int pulgadas;
    private String pais;
    private Nombre nombre;
    
    public Televisor() {
        this.nombre = Nombre.SAMSUNG;
        this.modelo = "Alcaparra";
        this.pulgadas = 0;
        this.pais = "Marruecos";
    }

    public Televisor(Nombre nombre, String modelo, Integer pulgadas, String pais) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.pulgadas = pulgadas;
        this.pais = pais;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }
}
