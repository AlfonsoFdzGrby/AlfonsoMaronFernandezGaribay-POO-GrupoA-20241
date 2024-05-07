package Tarea4U4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1: Excepción Aritmética
        
        try {
            System.out.println(8/0);
        } catch (ArithmeticException e) {
            System.out.println("Error matemático");
        }

        // 2: Excepción de apuntador nulo

        try {
            String cad = null;
            System.out.println(cad.length());
        } catch (NullPointerException e) {
            System.out.println("Esta es una cadena vacía");
        }

        // 3: Excepción fuera de límites

        int[] arreglo = new int[2];
        arreglo[0] = 1;
        arreglo[1] = 2;
        try {
            int num = arreglo[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El índice del arreglo se encuentra fuera de límites");
        }

        // 4: Error de entrada/salida

        try {
            System.out.println("Ingrese un número entero");
            int num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es un entero");
        } finally {
            sc.nextLine();
        }

        // 5: Archivo no encontrado

        try {
            FileReader archivo = new FileReader("archivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe o no fue encontrado");
        }

        // 6: Clase no encontrada

        try {
            Class.forName("NombreDeClase");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase no ha sido encontrada");
        }

        // 7: Excepción de estado ilegal

        sc.close();
        try {
            int var = sc.nextInt();
        } catch (IllegalStateException e) {
            System.out.println("Se ha hecho una referencia a un objeto finalizado");
        }

        // 8: Error al formatear número

        try {
            String doble = "1.2";
            int entero = Integer.parseInt(doble);
        } catch (NumberFormatException e) {
            System.out.println("El número no puede ser formateado a un entero");
        }

        // 9: Tamaño de arreglo negativo

        try {
            int[] arreglo2 = new int[-3];
        } catch (NegativeArraySizeException e) {
            System.out.println("No se puede definir un arreglo con un tamaño negativo");
        }

        // 10: Indice de cadena fuera de límites
        
        try {
            String cad = "Texto";
            char car = cad.charAt(5);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("El caracter no puede ser creado por que el índice definido está fuera de límites");
        }
    }
}