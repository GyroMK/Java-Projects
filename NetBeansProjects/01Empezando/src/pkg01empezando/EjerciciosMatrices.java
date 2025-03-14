package pkg01empezando;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class EjerciciosMatrices {

    public void ejercicio32() {
        Scanner teclado = new Scanner(System.in);
        float[][] notaMedia = new float[3][3];
        int[][] notasjava = new int[3][3];
        int[][] notasPython = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Notas de Java: ");
                notasjava[i][j] = teclado.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Notas de Python: ");
                notasPython[i][j] = teclado.nextInt();

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                notaMedia[i][j] = (float) (notasjava[i][j] + notasPython[i][j]) / 2;
                System.out.print(notaMedia[i][j] + ", ");

            }
            System.out.println("");
        }
    }

    public void ejercicio33() {
        Random aleatorio = new Random();
        int posX = 0, posY = 0;
        int mayor = Integer.MIN_VALUE;

        int[][] nums = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = aleatorio.nextInt(100) + 1;
                if (nums[i][j] > mayor) {
                    mayor = nums[i][j];
                    posX = i;
                    posY = j;

                }
                System.out.print(nums[i][j] + "\t");

            }
            System.out.println("");
        }
        System.out.println("El numero mas grande es: " + mayor + " y esta en la fila " + (posX + 1) + " y en la columna " + (posY + 1));
    }

    public void ejercicio34() {
        Random aleatorio = new Random();
        int[][] nums = new int[10][3];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = aleatorio.nextInt(7) + 1;
                if (nums[i][0]==nums[i][1]) {
                    nums[i][2]=1;
                }
                else {
                    nums[i][2]=0;
                }
                System.out.print(nums[i][j]+"\t");
                
            }
            System.out.println("");
            
        }
        
    }
}
