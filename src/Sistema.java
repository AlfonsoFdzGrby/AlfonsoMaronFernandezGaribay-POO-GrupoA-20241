import java.util.Scanner;
public class Sistema {

    // SCANNER AND ZOO OBJECTS

    private Scanner scanner = new Scanner(System.in);
    private Zoo zoo = new Zoo();

    // HEADER PRINTER

    public void printHeader(String header){
        System.out.println("==================================================");
        System.out.println(header);
        System.out.println("==================================================");
    }

    // PROGRAM

    public void runProgram(){

        int option=0;

        do {
            printHeader("WELCOME TO THE ZOO");
            System.out.println("1. Register employee");
            System.out.println("2. Register visitor");
            System.out.println("3. Register visit");
            System.out.println("4. Register animal");
            System.out.println("5. Register maintenance");
            System.out.println("6. Modify (Employee, visitor or animal)");
            System.out.println("7. Delete (Employee, visitor or animal)");
            System.out.println("8. Consult (Employee, visitor, animal, visit or maintenance)");
            System.out.println("9. Exit");
            System.out.print(">> ");
            option=scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                        printHeader("REGISTER EMPLOYEE");
                        zoo.registerEmployee();
                        break;

                case 2:
                        printHeader("REGISTER A VISITOR");
                        zoo.registerVisitor();
                        break;
                case 3:
                        printHeader("REGISTER VISIT");
                        zoo.registerVisit();
                        break;

                case 4:
                        printHeader("REGISTER ANIMAL");
                        zoo.registerAnimal();
                        break;

                case 5:
                        printHeader("REGISTER MAINTENANCE");
                        zoo.registerMaintenance();
                        break;

                case 6:
                        printHeader("MODIFY (Employee, visitor or animal)");
                        System.out.println("Please enter the element to modify: ");
                        System.out.println("1. Employee");
                        System.out.println("2. Visitor");
                        System.out.println("3. Animal");
                        System.out.println("4. Return to main menu");
                        System.out.print(">> ");
                        int subOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOption) {
                                case 1:
                                        zoo.modifyEmployee();
                                        break;

                                case 2:
                                        zoo.modifyVisitor();
                                        break;

                                case 3:
                                        zoo.modifyAnimal();
                                        break;
                        
                                default:
                                        break;
                        }
                        break;
                
                case 7:
                        printHeader("DELETE (Employee, visitor or animal)");
                        System.out.println("Please enter the element to delete");
                        System.out.println("1. Employee");
                        System.out.println("2. Visitor");
                        System.out.println("3. Animal");
                        System.out.println("4. Return to main menu");
                        System.out.print(">> ");
                        int subOption3 = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOption3) {
                                case 1:
                                        zoo.deleteEmployee();
                                        break;
                        
                                case 2:
                                        zoo.deleteVisitor();
                                        break;
                        
                                case 3:
                                        zoo.deleteAnimal();
                                        break;
                        
                                default:
                                        break;
                        }
                        break;
                
                case 8:
                        printHeader("CONSULT (Employee, visitor, animal or visit)");
                        System.out.println("Please enter the element to consult: ");
                        System.out.println("1. Employee");
                        System.out.println("2. Visitor");
                        System.out.println("3. Animal");
                        System.out.println("4. Visit");
                        System.out.println("5. Maintenance");
                        System.out.println("6. Return to main menu");
                        System.out.print(">> ");
                        int subOption2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (subOption2) {
                                case 1:
                                        zoo.consultEmployee();
                                        break;
                                
                                case 2:
                                        zoo.consultVisitor();
                                        break;

                                case 3:
                                        zoo.consultAnimal();
                                        break;
                                
                                case 4:
                                        zoo.consultVisit();
                                        break;
                                
                                case 5:
                                        zoo.consultMaintenance();
                                        break;
                        
                                default:
                                        break;
                        }

                        break;
            }

        }while (option<9);

    }

}