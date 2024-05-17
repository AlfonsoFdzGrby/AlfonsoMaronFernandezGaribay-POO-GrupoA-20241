package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class Tools {
    private static Scanner sc = new Scanner(System.in);

    public static void printHeader(String header){
        System.out.println("===============================================================");
        System.out.println(header);
        System.out.println("===============================================================");
    }

    public static void next(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    public static int nextInt(){
        String num;
        int res;
        while(true){
            num = sc.nextLine();
            try {
                res = Integer.parseInt(num);
                break;
            } catch (Exception e) {
                System.out.println("Por favor ingrese un número");
            }
        }
        return res;
    }

    public static double nextDouble(){
        String num;
        double res;
        while(true){
            num = sc.nextLine();
            try {
                res = Double.parseDouble(num);
                break;
            } catch (Exception e) {
                System.out.println("Por favor ingrese un número");
            }
        }
        return res;
    }

    public static boolean AskForYesOrNo(char opc){
        boolean answer = false;
        switch (Character.toLowerCase(opc)) {
            case 'y' -> answer = true;
            case 's' -> answer = true;
            default -> answer = false;
        }
        return answer;
    }

    public static LocalDate askForDate(){
        LocalDate date = null;
        while (true) {
            try {
                System.out.println("Día: ");
                int dia = Tools.nextInt();
                System.out.println("Mes: ");
                int mes = Tools.nextInt();
                System.out.println("Año");
                int año = Tools.nextInt();
                date = LocalDate.of(año, mes, dia);
                break;
            } catch (Exception e) {
                System.out.println("Inválido");
            }
        }
        return date;
    }
}
