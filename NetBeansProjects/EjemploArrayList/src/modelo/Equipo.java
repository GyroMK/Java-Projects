/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gonzalo.detomas
 */
public class Equipo {
    private String nombre;
    private String localidad;
    private int anioFundacion;
    
    public Equipo(){
        this.nombre = "";
        this.localidad = "";
        this.anioFundacion = 0;
    }
    
    public Equipo(String nombre, String localidad, int anioFundacion){
        this.nombre = nombre;
        this.localidad = localidad;
        this.anioFundacion = anioFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    
}
