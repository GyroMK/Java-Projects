
package modelo;

/**
 *
 * @author gonzalo.detomas
 */
public class Pelicula extends Premio{//con extends hago herencia (heredamos de la clase padre:Premio)
    public enum Genero{ACCION, COMEDIA, ROMANCE, TERROR, CIENCIA_FICCION}
    //Atributos
    private String nombrePeli;
    private int duracion;
    private String pais;
    private String director;
    private Genero genero;
    private float valoracion;
    //Mc
        //Por defecto
    public Pelicula(){
        this.nombrePeli = "Rey Leon";
        this.duracion = 88;
        this.pais = "EE.UU";
        this.director = "Rocío";
        this.genero = Genero.CIENCIA_FICCION;
        this.nombrePremio = "Oscar"; //Accedo a los atributos de la clase padre
        this.ciudadPremio = "L.A";
        this.valoracion = 4.9f;
    }
        //Por parámetros
    public Pelicula(String nombrePeli, int duracion, String pais, String director, Genero genero, String nombrePremio, String ciudadPremio, float valoracion){
        this.nombrePeli = nombrePeli;
        this.duracion = duracion;
        this.pais = pais;
        this.director = director;
        this.genero = genero;
        this.nombrePremio = nombrePremio;
        this.ciudadPremio = ciudadPremio;
        this.valoracion = valoracion;
    }
    //Accedentes y mutadores

    public String getNombrePeli() {
        return nombrePeli;
    }

    public void setNombrePeli(String nombrePeli) {
        this.nombrePeli = nombrePeli;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    
}
