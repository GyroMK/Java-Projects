/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploprintwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gon
 */
public class EjemploFileReader {

    public static void main(String[] args) {
        String cadena;
        FileReader f = null;

        try {
            f = new FileReader("probando.txt");

            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                System.out.println(cadena);
            }
            b.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
