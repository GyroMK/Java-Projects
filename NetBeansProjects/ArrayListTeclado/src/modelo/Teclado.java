package modelo;

import java.util.ArrayList;

public class Teclado {

    private String marca;
    private String modelo;
    private String color;
    private int numTeclas;
    private ArrayList<Teclado> arrTeclado;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Teclado> getArrTeclado() {
        return arrTeclado;
    }

    public void setArrTeclado(ArrayList<Teclado> arrTeclado) {
        this.arrTeclado = arrTeclado;
    }

    public Teclado() {
        this.marca = "";
        this.modelo = "";
        this.color = "";
    }

    public Teclado(String nombre, String apellido, String edad) {
        this.marca = nombre;
        this.modelo = apellido;
        this.color = edad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEdad() {
        return color;
    }

    public void setEdad(String edad) {
        this.color = edad;
    }

    public int getNumTeclas() {
        return numTeclas;
    }

    public void setNumTeclas(int numTeclas) {
        this.numTeclas = numTeclas;
    }
}
