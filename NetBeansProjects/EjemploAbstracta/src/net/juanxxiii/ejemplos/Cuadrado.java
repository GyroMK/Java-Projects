/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.juanxxiii.ejemplos;

/**
 *
 * @author Gon
 */
public class Cuadrado extends Figura{
    double lado;
    
    public Cuadrado(double x, double y, double lado){
        super(x, y);
        this.lado = lado;
    }
    
    // Implementamos el método área con el área correspondiente del círculo

    @Override
    public double area() {
        return lado*lado; 
    }
    
}
