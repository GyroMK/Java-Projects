/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escribirobjetoenfichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Gon
 */
public class EscribirObjetoEnFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileOutputStream fichero = null;        
        Persona personaParaGuardar = new Persona("Josefina", "Pontevedra", 23);
                
        try {
            fichero = new FileOutputStream("datos.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(personaParaGuardar);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        Persona personaParaLeer;
        FileInputStream ficheroEntrada = null;
        
        try{            
            ficheroEntrada = new FileInputStream("datos.txt");
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            
            personaParaLeer = (Persona)tuberiaEntrada.readObject();
            personaParaLeer.muestraPersona();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
