
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sergi.carmona
 */
public class Edificios {

private String calle;
private int numPiso;
private String nomPres;
private int numPuertas;

public Edificios() {
    this.calle = "";
    this.numPiso = 0;
    this.nomPres = "";
    this.numPuertas = 0;
}

public Edificios(String calle, int numPiso, String nomPres, int numPuertas) {
    this.calle = calle;
    this.numPiso = numPiso;
    this.nomPres = nomPres;
    this.numPuertas = numPuertas;
}

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumPiso() {
        return numPiso;
    }

    public void setNumPiso(int numPiso) {
        this.numPiso = numPiso;
    }

    public String getNomPres() {
        return nomPres;
    }

    public void setNomPres(String nomPres) {
        this.nomPres = nomPres;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Edificios{:\n" + "\tcalle: " + calle + ",\t\nnumPiso=" + numPiso + ",\t\nnomPres: " + nomPres + ",\t\nnumPuertas: " + numPuertas + '}';
    }

}
