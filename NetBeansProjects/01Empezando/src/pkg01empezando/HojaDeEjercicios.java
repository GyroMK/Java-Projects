package pkg01empezando;

import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class HojaDeEjercicios {

    public static void main(String[] args) {
        HojaDeEjercicios ej = new HojaDeEjercicios();
        EjerciciosMatrices Matriz = new EjerciciosMatrices();
        //creamos un objeto scanner

        //guardamos en una variable la informacion
        String nombre;
        int opcion;

        do {
            opcion = ej.menu();

            switch (opcion) {
                case 0:
                    ej.ejercicio0();
                    break;
                case 1:
                    ej.ejercicio1();
                    break;
                case 2:
                    ej.ejercicio2();
                    break;
                case 3:
                    ej.ejercicio3();
                    break;
                case 4:
                    ej.ejercicio4();
                    break;
                case 5:
                    ej.ejercicio5();
                    break;
                case 6:
                    ej.ejercicio6();
                    break;
                case 7:
                    ej.ejercicio7();
                    break;
                case 8:
                    ej.ejercicio8();
                    break;
                case 9:
                    ej.ejercicio9();
                    break;
                case 10:
                    ej.ejercicio10();
                    break;
                case 11:
                    ej.ejercicio11();
                    break;
                case 12:
                    ej.ejercicio12();
                    break;
                case 13:
                    ej.ejercicio13();
                    break;
                case 14:
                    ej.ejercicio14();
                    break;
                case 15:
                    ej.ejercicio15();
                    break;
                case 16:
                    ej.ejercicio16();
                    break;
                case 17:
                    ej.ejercicio17();
                    break;
                case 18:
                    ej.ejercicio18();
                    break;
                case 19:
                    ej.ejercicio19();
                    break;
                case 20:
                    ej.ejercicio20();
                    break;
                case 21:
                    ej.ejercicio21();
                    break;
                case 22:
                    ej.ejercicio22();
                    break;
                case 23:
                    ej.ejercicio23();
                    break;
                case 24:
                    ej.ejercicio24();
                    break;
                case 25:
                    ej.ejercicio25();
                    break;
                case 27:
                    ej.ejercicio27();
                    break;
                case 28:
                    ej.ejercicio28();
                    break;
                case 29:
                    ej.ejercicio29();
                    break;
                case 30:
                    ej.ejercicio30();
                    break;
                case 31:
                    //ej.();
                    break;
                case 32:
                    Matriz.ejercicio32();
                    break;
                case 33:
                    Matriz.ejercicio33();
                    break;
                case 34:
                    Matriz.ejercicio34();
                    break;
            }
        } while (opcion
                != 30);

    }

    public int menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        System.out.println("0. pedir nombre");
        System.out.println("1. suma de dos numeros");
        System.out.println("2. promedio de 3 numeros");
        System.out.println("3. numero par o impar");
        System.out.println("introduzca opcion");
        opcion = teclado.nextInt();

        return opcion;
    }

    public void ejercicio0() {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        teclado.nextLine();
        System.out.println("¿Como te llamas?");
        nombre = teclado.nextLine();
        System.out.println("Bienvenido " + nombre);
    }

    public void ejercicio1() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el primer numero");
        int n1 = teclado.nextInt();
        System.out.println("escribe el segundo numero");
        int n2 = teclado.nextInt();
        int suma = n1 + n2;
        System.out.print("el resultado de ");
        System.out.print(n1);
        System.out.print(" + ");
        System.out.print(n2);
        System.out.println(" es " + suma);
    }

    public void ejercicio2() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el primer numero");
        int p1 = teclado.nextInt();
        System.out.println("escribe el segundo numero");
        int p2 = teclado.nextInt();
        System.out.println("escribe el tercer numero");
        int p3 = teclado.nextInt();
        int sumap = p1 + p2 + p3;
        int pro = sumap / 3;
        System.out.print("el promedio de los numeros ");
        System.out.print(p1);
        System.out.print(", ");
        System.out.print(p2);
        System.out.print(", ");
        System.out.print(p3);
        System.out.println(" es " + pro);
    }

    public void ejercicio3() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero");
        int ej3 = teclado.nextInt();
        if (ej3 % 2 == 0) {
            System.out.println("el numero es par");
        } else {
            System.out.println("el numero es impar");
        }
    }

    public void ejercicio4() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el grado celsius");
        int C = teclado.nextInt();
        int F = C * 9 / 5 + 32;
        System.out.println("la conversion da " + F);
    }

    public void ejercicio5() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el primer numero");
        int m1 = teclado.nextInt();
        System.out.println("escribe el segundo numero");
        int m2 = teclado.nextInt();
        System.out.println("escribe el tercer numero");
        int m3 = teclado.nextInt();
        if (m1 > m2 && m1 > m3) {
            System.out.println("el mayor numero es " + m1);
        } else if (m2 > m1 && m2 > m3) {
            System.out.println("el mayor numero es " + m2);
        } else if (m3 > m1 && m3 > m2) {
            System.out.println("el mayor numero es " + m3);
        }
    }

    public void ejercicio6() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el radio");
        int R = teclado.nextInt();
        double pi = Math.PI;
        double area = pi * R * R;
        System.out.println("El area del circulo es " + area);
    }

    public void ejercicio7() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero");
        int num = teclado.nextInt();
        if (num < 0) {
            System.out.println("El numero es negativo");
        } else if (num == 0) {
            System.out.println("El numero es 0");
        } else {
            System.out.println("el numero es positivo");
        }
    }

    public void ejercicio8() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero");
        long total = 1;
        int num = teclado.nextInt();
        for (int i = 1; i <= num; i++) {
            total *= i;
        }
        System.out.println("el factorial es " + total);
    }

    public void ejercicio9() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero");
        int mult = teclado.nextInt();
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " * " + mult + " = " + i * mult);
        }
    }

    public void ejercicio10() {
        Scanner teclado = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("");
        for (int e = 10; e >= 1; e--) {
            System.out.print(e + ", ");
        }
        System.out.println("");
        for (int a = 1; a <= 40; a++) {
            if (a % 2 == 0) {
                System.out.print(a + ", ");
            }
        }
        System.out.println("");
        for (int b = 40; b >= 1; b--) {
            if (b % 2 == 1) {
                System.out.print(b + ", ");
            }
        }
        System.out.println("");
    }

    public void ejercicio11() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero");
        int entero = 0;
        for (int i = teclado.nextInt(); i >= 1; i--) {
            entero += i;
        }
        System.out.println("la suma de los enteros es " + entero);
    }

    public void ejercicio12() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe tu peso");
        int kg = teclado.nextInt();
        System.out.println("Escribe tu altura");
        int m = teclado.nextInt();
        int IMC = kg / (m * m);
        System.out.println("Tu IMC es: " + IMC);
        if (IMC > 18.5) {
            System.out.println(" Tienes Bajo Peso");
        } else if (IMC >= 18.5 && IMC < 24.9) {
            System.out.println("Tienes Peso Normal");
        } else if (IMC >= 25 && IMC < 29.9) {
            System.out.println("Tienes Sobrepeso");
        } else if (IMC >= 30) {
            System.out.println("Tienes Obesidad");
        }
    }

    public void ejercicio13() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero: ");
        int num13 = teclado.nextInt();
        int perf = 0;
        for (int i = 1; i < num13; i++) {
            if (num13 % i == 0) {
                perf += i;
            }
        }
        System.out.println("la suma es " + perf);
        if (perf == num13) {
            System.out.println("el numero es perfecto");
        } else {
            System.out.println("El numero no es perfecto");
        }
    }

    public void ejercicio14() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero: ");
        int num14 = teclado.nextInt();
        int cont = 0;
        while (num14 >= 1) {
            num14 = num14 / 10;
            cont++;
        }
        System.out.println(cont);
    }

    public void ejercicio15() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero: ");
        int num15 = teclado.nextInt();
        int a = 0;
        int b = 1;
        int c;
        for (int i = 1; i < num15; i++) {
            c = a + b;
            a = b;
            b = a;
            System.out.println(c);
        }
    }

    public void ejercicio16() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe la primera cadena de texto: ");
        String txt1 = teclado.nextLine();
        System.out.println("Escribe la segunda cadena de texto: ");
        String txt2 = teclado.nextLine();
        if (txt1.equals(txt2)) {
            System.out.println("Las cadenas son iguales");
        } else {
            System.out.println("Las cadenas no son iguales");
        }
    }

    public void ejercicio17() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el anyo");
        int any = teclado.nextInt();
        if ((any % 4 == 0 && any % 100 != 0) || any % 400 == 0) {
            System.out.println("El anyo " + any + " es bisiesto");
        } else {
            System.out.println("El anyo " + any + " no es bisiesto");
        }
    }

    public void ejercicio18() {
        Scanner teclado = new Scanner(System.in);
        int num = teclado.nextInt();
        int numeros[] = {1, 2, 3, 4, 5};
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == num) {
                System.out.println(i);
            }
        }
    }

    public void ejercicio19() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe la palabra");
        String palabra = teclado.nextLine();
        int contar = 0;
        for (int i = 0; i < palabra.length(); i++) {
            switch (palabra.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contar++;
                    break;
            }
        }
        System.out.println("La cadena tiene " + contar + " vocales");
    }

    public void ejercicio20() {
        System.out.println("El rango de un byte esta comprendido entre (" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + ")");
        System.out.println("El rango de un short esta comprendido entre (" + Short.MIN_VALUE + ", " + Short.MAX_VALUE + ")");
        System.out.println("El rango de un int esta comprendido entre (" + ", " + Integer.MIN_VALUE + Integer.MAX_VALUE + ")");
        System.out.println("El rango de un long esta comprendido entre (" + Long.MIN_VALUE + ", " + Long.MAX_VALUE + ")");
        System.out.println("El rango de un float esta comprendido entre (" + Float.MIN_VALUE + ", " + Float.MAX_VALUE + ")");
        System.out.println("El rango de un double esta comprendido entre (" + Double.MIN_VALUE + ", " + Double.MAX_VALUE + ")");
    }

    public void ejercicio21() {
        String palabraUno = "Descafeinado";
        String palabraDos = " sin azucar";

        System.out.println("El caracter en el indice 5 de PalabraUno es: " + palabraUno.charAt(5));
        System.out.println("El caracter en el indice 5 de PalabraDos es: " + palabraDos.charAt(5));

        System.out.println("El resultado de concatenar PalabraUno y PalabraDos es: " + palabraUno + palabraDos);

        System.out.println("PalabraUno contiene la subsecuenca 'car': " + palabraUno.contains("car"));
        System.out.println("PalabraDos contiene la subsecuenca 'car': " + palabraDos.contains("car"));

        System.out.println("PalabraUno termina en" + " 'ado': " + palabraUno.endsWith("ado"));
        System.out.println("PalabraDos termina en" + " 'ado': " + palabraDos.endsWith("ado"));

        System.out.println("El indice de la letra 'c' en PalabraUno es: " + palabraUno.indexOf('c'));
        System.out.println("El indice de la letra 'c' en PalabraDos es: " + palabraDos.indexOf('c'));

        System.out.println("El indice de la ultima letra 'a' en PalabraDos es: " + palabraDos.lastIndexOf('a'));
        System.out.println("El indice de la ultima letra 'a' en PalabraDos es: " + palabraDos.lastIndexOf('a'));

        System.out.println("El numero de caracteres de PalabraUno es de: " + palabraUno.length() + " caracteres");
        System.out.println("El numero de caracteres de PalabraDos es de: " + palabraDos.length() + " caracteres");

        System.out.println("El substring de PalabraUno entre la posicion 3 y 7 es: " + palabraUno.substring(3, 7));
        System.out.println("El substring de PalabraDos entre la posicion 5 y 11 es: " + palabraDos.substring(5, 11));

        System.out.println("Paso palabraUno a minusculas: " + palabraUno.toLowerCase());

        System.out.println("Paso palabraUno a mayusculas: " + palabraUno.toUpperCase());
        System.out.println("Paso palabraDos a mayusculas: " + palabraDos.toUpperCase());

    }

    public void ejercicio22() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el numero de tu DNI: ");
        String resto[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        int dni = teclado.nextInt();
        int div = dni % 23;
        System.out.println(div);
        System.out.println("Tu letra del dni es: " + resto[div]);
    }

    public void ejercicio23() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero entre 3 y 9");
        int ast = teclado.nextInt();
        if (ast >= 3 && ast <= 9) {
            for (int filas = 0; filas < ast; filas++) {
                for (int columnas = 0; columnas < ast; columnas++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
        } else {
            ejercicio23();
        }

    }

    public void ejercicio24() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero entre 3 y 9");
        int ast = teclado.nextInt();
        if (ast >= 3 && ast <= 9) {
            for (int filas = 0; filas < ast; filas++) {
                for (int columnas = 0; columnas < ast; columnas++) {
                    if (columnas == 0 || columnas == (ast - 1) || filas == 0 || filas == (ast - 1)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
        } else {
            ejercicio24();
        }

    }

    public void ejercicio25() {
        int cont;
        for (int i = 1; i <= 100; i++) {
            cont = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cont++;
                }
                
            }
            if (cont == 2) {
                    System.out.print(cont + " ");
                }
        }
        System.out.println("");
    }

    public void ejercicio27() {

    }

    public void ejercicio28() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero entre 3 y 9");
        int num = teclado.nextInt();
        for (int fila = 0; fila < num; fila++) {
            for (int cols = 0; cols < num; cols++) {
                if (fila + cols < num) {
                    System.out.print(" ");

                } else {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
        

    }

    public void ejercicio29() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe un numero entre 3 y 9");
        int num = teclado.nextInt();
        for (int fila = 0; fila < num; fila++) {
            for (int cols = 0; cols < num; cols++) {
                if (cols <= fila -1) {
                    System.out.print(" ");

                } else {
                    System.out.print(" *");
                }
            }
            System.out.println("");
        }
        for (int fila = 2; fila <= num; fila++) {
            for (int cols = 0; cols < num; cols++) {
                if (fila + cols < num) {
                    System.out.print(" ");

                } else {
                    System.out.print(" *");
                }
            }
            System.out.println("");
        }
    }
    public void ejercicio30() {
        
    }

    public void ejercicio31() {
        Scanner teclado = new Scanner(System.in);
        String nombres[] = new String[3];
        float peso[] = new float[3];
        float altura[] = new float[3];

        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Escribe el nombre");
            nombres[i] = teclado.next();
            System.out.println("Escribe el peso");
            peso[i] = teclado.nextFloat();
            System.out.println("Escribe la altura");
            altura[i] = teclado.nextFloat();
        }

        for (int a = 0; a < 3; a++) {
            System.out.println("El IMC de " + nombres[a] + " es: ");
            float IMC = peso[a] / (altura[a] * altura[a]);
            System.out.println(IMC);
        }

    }

    public void AlgoritmoBurbuja() {
        int edades[] = {18, 20, 8, 2, 8, 1, 15, 77, 25, 3};
        System.out.println("Antes de ordenar");
        muestra(edades);
        int temporal;
        for (int i = 0; i < edades.length; i++) {
            for (int j = 0; j < edades.length; j++) {
                if (edades[j] > edades[i]) {
                    temporal = edades[i];
                    edades[i] = edades[j];
                    edades[j] = temporal;
                }
            }
        }
        System.out.println("Despues de ordenar");
        muestra(edades);
    }

    public void muestra(int edades[]) {
        for (int i = 0; i < edades.length; i++) {
            System.out.print(edades[i] + " ");
        }
    }
}
