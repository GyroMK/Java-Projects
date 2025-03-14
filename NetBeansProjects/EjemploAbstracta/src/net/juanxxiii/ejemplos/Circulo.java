/*
 * Clase Círculo que hereda de Figura
 */

package net.juanxxiii.ejemplos;

/**
 *
 * @author Gon
 */
public class Circulo extends Figura{
    double radio;
    
    public Circulo(double x, double y){
        super(x, y);
        this.radio = 0.0d;
    }
    
    public Circulo(double x, double y, double radio){
        super(x, y);
        this.radio = radio;
    }
    
    // Implementamos el método área con el área correspondiente del círculo
    @Override
    public double area(){
        return Math.PI*radio*radio;
    }
}
