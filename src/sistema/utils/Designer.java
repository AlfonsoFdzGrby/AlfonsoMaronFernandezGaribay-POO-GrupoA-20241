package sistema.utils;

import java.util.Scanner;

public class Designer {

    private static Scanner sc = new Scanner(System.in);

    public static void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    public static void printHeader(String header){
        System.out.println("=====================================================");
        System.out.println(header);
        System.out.println("=====================================================");
    }

    public static boolean yesOrNo(char opt){
        boolean ans = false;
        switch (Character.toLowerCase(opt)) {
            case 'y':
            case 's':
                ans = true;
                break;
        
            default:
                ans = false;
                break;
        }
        return ans;
    }

}
