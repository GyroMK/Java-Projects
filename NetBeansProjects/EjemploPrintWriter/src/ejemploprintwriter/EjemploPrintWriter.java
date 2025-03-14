/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploprintwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Gon
 */
public class EjemploPrintWriter {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo = new File("probando.txt");

        PrintWriter pw = null;
        String nombre = "Ana";
        int edad = 22; 
        
        try{
            pw = new PrintWriter(archivo);
            pw.println("Vamos chavales!!!");
            pw.println(nombre);
            pw.println(edad);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally{
            if (pw != null){
                pw.close();
            }
        }
    }
}

