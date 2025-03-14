package modelo;

/**
 *
 * @author sergi.carmona
 */
public class Viajes {

    private String destino;
    private int tiempo;

    public enum Acompanyante {
        FAMILIA, AMIGOS, SOLO
    }
    private Acompanyante acompanyante;

    private int valoracion;

    public Viajes() {
        this.destino = "";
        this.tiempo = 0;
        this.acompanyante = Acompanyante.SOLO;
        this.valoracion = 0;
    }

    public Viajes(String destino, int tiempo, Acompanyante acompanyante, int valoracion) {
        this.destino = destino;
        this.tiempo = tiempo;
        this.acompanyante = acompanyante;
        this.valoracion = valoracion;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Acompanyante getAcompanyante() {
        return acompanyante;
    }

    public void setAcompanyante(Acompanyante acompanyante) {
        this.acompanyante = acompanyante;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

}
