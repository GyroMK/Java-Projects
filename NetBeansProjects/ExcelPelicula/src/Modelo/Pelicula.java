/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author sergi.carmona
 */
public class Pelicula {
    
    public enum Genero {
        ACCION, COMEDIA, ROMANCE, TERROR, CIENCIA_FICCION
    }
    
    private String nombre;
    private int duracion;
    private String pais;
    private String director;
    private ArrayList<Premios> arrPremios;
    private float valoracion;
    private int numPremios;
    private Genero genero;

    public Pelicula(){
        this.nombre = "";
        this.duracion = 0;
        this.pais = "";
        this.director = "";
        this.valoracion = 0;
    }

    public int getNumPremios() {
        return numPremios;
    }

    public void setNumPremios(int numPremios) {
        this.numPremios = numPremios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<Premios> getArrPremios() {
        return arrPremios;
    }

    public void setArrPremios(ArrayList<Premios> arrPremios) {
        this.arrPremios = arrPremios;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
