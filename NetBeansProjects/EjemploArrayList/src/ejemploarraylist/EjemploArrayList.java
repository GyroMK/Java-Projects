/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Gon
 */
public class EjemploArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int posicion=1;
        // Declaración de un ArrayList de <String>)
        ArrayList<String> miArrayList = new ArrayList<String>();
        // Añade un elemento en el ArrayList
        miArrayList.add("Martillo");
        // Añade el elemento "Moneda" al ArrayList en la posición indicada
        miArrayList.add(posicion, "Moneda");
        // Devuelve el numero de elementos del ArrayList
        miArrayList.size();
        // Devuelve el elemento de la posición '2' del ArrayList
        miArrayList.get(1);
        // Devuelve true si el ArrayList contiene el elemento "Martillo"
        miArrayList.contains("Martillo");
        // Devuelve la posición de la primera ocurrencia de "Martillo" en el ArrayList  
        miArrayList.indexOf("Martillo");
        // Devuelve la posición de la última ocurrencia "Martillo" en el ArrayList   
        miArrayList.lastIndexOf("Martillo");
        // Borra el elemento de la posición indicada en el ArrayList   
        //miArrayList.remove(posicion);
        // Borra la primera ocurrencia de "Martillo"   
        //miArrayList.remove("Martillo");
        // Borra todos los elementos de ArrayList   
        //miArrayList.clear();
        // Devuelve true si el ArrayList esta vacío   
        miArrayList.isEmpty();
        // Copia un ArrayList 
        ArrayList copiaDelArrayList = (ArrayList) miArrayList.clone();
        // Pasa el ArrayList a un Array 
        Object[] array = miArrayList.toArray();
        
        /*
        * Crear un ArrayList con 10 elementos y mostramos su contenido
        */
        for (int i=0; i<10; i++){
            miArrayList.add("Contenido " + i); 
        }

        // Declaramos el Iterator y recorremos los elementos del ArrayList
        Iterator<String> iterador = miArrayList.iterator();
        while(iterador.hasNext()){
            String elemento = iterador.next();
            System.out.println(elemento);
        }
    }

}
