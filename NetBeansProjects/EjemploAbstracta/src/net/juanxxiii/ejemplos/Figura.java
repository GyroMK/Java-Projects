/*
 *          CLASES ABSTRACTAS 
 * Las clases abstractas no se pueden crear ejemplares de la clase.
 * Se usan para definir subclases.
 * Si algún método no tiene implementación, la clase es abstracta.
 * Usamos clases abstractas cuando englobamos objetos de distintos tipos y 
 * queremos usar polimorfismo.
 */

package net.juanxxiii.ejemplos;

/**
 *
 * @author Gon
 */
public abstract class Figura {
    protected double x;
    protected double y;
    
    // Constructor de la clase Figura
    public Figura (double x, double y){
        this.x = x;
        this.y = y;
    }
    private void casa(){}
    // M�todo abstracto (no se implementa)
    public abstract double area();
    
    public void mostrar(){
        System.out.println("---------");
    }
}


