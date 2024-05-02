package sistema.utils;

import java.util.*;

public class ConsoleReader {
    private static Scanner sc = new Scanner(System.in);
    
    public static int nextInt(){
        String num;
        int res;

        while(true){
            num = sc.nextLine();
            try {
                res = Integer.parseInt(num);
                break;
            } catch (Exception e){

            }
        }

        return res;
    }
}
