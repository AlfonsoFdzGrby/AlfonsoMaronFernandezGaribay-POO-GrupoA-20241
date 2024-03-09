import java.util.*;

public class Main {
    public static Bank bank = new Bank();
    public static Scanner sc = new Scanner(System.in);
    public static Random ran = new Random();
    public static Employee user;
    public static char type='A';
    public static float funds=0;
    public static int opt;

    public static void main(String[] args) {
        bank.storeUser(new Employee('A', "User1", 15000, 123456789));
        while(true){
            printheader("BANK");
            System.out.println("Select an option:");
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("3. Enter as Bank Executive");
            System.out.println("4. Exit");
            System.out.print(">> ");

            opt = sc.nextInt();
            sc.nextLine();
    
            switch (opt) {
                case 1:
                    logIn();
                    break; 
                case 2:
                    signUp();
                    break;
                case 3:
                    executive();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
        
    public static void executive() {
        while(true){
            printheader("BANK EXECUTIVE OPTIONS");
            System.out.println("1. List users registered in Bank");
            System.out.println("2. Show a specific user's information");
            System.out.println("3. Return to main menu");
            System.out.print(">> ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    printheader("USER LIST");
                    bank.listEmployees();
                    System.out.println("Press enter to return to the main menu...");
                    sc.nextLine();
                    break;

                case 2:
                    boolean found = false;
                    printheader("USER INFORMATION");
                    while(true)
                    {
                        System.out.println("Enter username: ");
                        System.out.print(">> ");
                        String userName = sc.nextLine();
                        System.out.println();
                        for (int i = 0; i < bank.getEmployeeList().size(); i++) {
                            if(userName.equalsIgnoreCase(bank.getEmployeeList().get(i).getUserName())){
                                found = true;
                                user = bank.getEmployeeList().get(i);
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("User not found. Please enter an existent username");
                        }else{
                            user.printAcList();
                            System.out.println("Press enter to return to bank executive's options...");
                            sc.nextLine();
                            break;
                        }
                    }
                    break;

                default:
                    break;
            }
            if(option>2){
                break;
            }
        }
    }

    public static void signUp() {
        printheader("SIGN UP");
        System.out.println("To create your new account, please fill up the next data:");
        System.out.print(">> Name: ");
        String name = sc.nextLine();
        printheader("SIGN UP");
        System.out.println("Hello " + name + "!\n");
        System.out.println("There are several account types you can create, which are:");
        System.out.println("TYPE A:");
        System.out.println("  > Fund limit: $50,000.00");
        System.out.println("  > Withdraw Minimum: $1,000.00");
        System.out.println("TYPE B:");
        System.out.println("  > Fund limit: $100,000.00");
        System.out.println("  > Withdraw Minimum: $5,000.00");
        System.out.println("TYPE C:");
        System.out.println("  > No fund limit");
        System.out.println("  > Withdraw Minimum: $10,000.00\n");
        
        boolean success = false;
        while(success==false){
            System.out.print(">> Account type: ");
            type = sc.nextLine().charAt(0);
            switch(Character.toUpperCase(type)){
                case 'A':
                case 'B':
                case 'C':
                    success = true;
                    break;
                default:
                    System.out.println("\nThe defined account type is not valid.");
                    System.out.println("Please enter a valid account type:\n");
            }
        }

        success = false;
        
        while(success==false){
            System.out.print(">> Initial deposit/funds for type " + type + " account: ");
            funds = sc.nextFloat();
            sc.nextLine();
            switch(Character.toUpperCase(type)){
                case 'A':
                if(funds>50000 || funds<1000){
                    System.out.println("The defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            case 'B':
                if(funds>100000 || funds<5000){
                    System.out.println("\nThe defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            default:
                if(funds<10000){
                    System.out.println("\nThe defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            }
        }

        user = new Employee(type, name, funds, ran.nextLong(11111111, 99999999));

        bank.storeUser(user);
        printheader("SIGN UP");
        System.out.println("Your account has been registered correctly with an initial account!");
        System.out.println("Press any key to return to the main menu...");
        sc.nextLine();
    }

    public static void logIn() {
        int acID;
        printheader("LOG IN");
        while(true){
            boolean found = false;
            int i = 0;
            System.out.print(">> Username: ");
            String userName = sc.nextLine();
            
            for (i = 0; i < bank.getEmployeeList().size(); i++) {
                if(userName.equalsIgnoreCase(bank.getEmployeeList().get(i).getUserName())){
                    found = true;
                    user = bank.getEmployeeList().get(i);
                    break;
                }
            }
            if(!found){
                System.out.println("User not found. Please enter a valid user:");
            }else{
                System.out.println("User " + user.getUserName() + " found");
                break;
            }
        }        

        while(true){
            System.out.print(">> Enter the account id to access: ");
            acID = sc.nextInt();
            sc.nextLine();

            if(acID < 0 || acID >= user.getAccountList().size()){
                System.out.println("Account not found. Please enter a valid ID");
            }else{
                System.out.println("Account " + acID + " found");
                System.out.println("Press enter to access your account's settings...");
                sc.nextLine();
                break;
            }
        }

        while(true){ 
            System.out.println("=========================================================");
            printheader("ACCOUNT SETTINGS");
            System.out.println("Account ID: " + acID);
            System.out.println("Account Number: " + user.getAccount(acID).getAccountNum());
            System.out.println("Account credit: $" + user.getAccount(acID).getAmmount());
            System.out.println("=========================================================");
            System.out.println("1. Withdraw money");
            System.out.println("2. Deposit money");
            System.out.println("3. Upgrade account type");
            System.out.println("4. Show actual account info");
            System.out.println("5. Create new account for user " + user.getUserName());
            System.out.println("6. Show user's accounts:");
            System.out.println("7. Return to main menu");
    
            System.out.print(">> ");
            opt = sc.nextInt();
            sc.nextLine();
    
            switch (opt) {
                case 1:
                    withdrawMoney(user, acID);
                    break;
            
                case 2:
                    depositMoney(user, acID);
                    break;
            
                case 3:
                    changeType(user, acID);
                    break;
            
                case 4:
                    printheader("ACCOUNT INFO");
                    System.out.println(user.getAccount(acID).getAccountInfo());
                    System.out.println("Press enter to return to account settings...");
                    sc.nextLine();
                    break;

                case 5:
                    createNewAccount(user);
                    break;
                
                case 6:
                    printheader(user.getUserName().toUpperCase() + "'S ACCOUNTS");
                    user.printAcList();
                    System.out.println("Press enter to return to account settings...");
                    sc.nextLine();
                default:

                    break;
            }
            if(opt>=5){
                break;
            }
        }

    }

    public static void withdrawMoney(Employee user, int id) {
        printheader("WITHDRAW MONEY");
        while(true){
            System.out.println("Please enter the amount to widthraw: ");
            System.out.print(">> ");
            float withdrawAmmount = sc.nextFloat();
            sc.nextLine();

            if(user.getAccount(id).withdraw(withdrawAmmount)==true){
                System.out.println("$" + withdrawAmmount + " were withdrawn from account #" + id);
                System.out.println("Account credit: $" + user.getAccount(id).getAmmount());
                sc.nextLine();
                break;
            }
        }   
    }

    public static void depositMoney(Employee user, int id) {
        printheader("DEPOSIT MONEY");
        while (true) {
            System.out.println("Please enter the amount to deposit");
            System.out.print(">> ");
            float depositAmmount = sc.nextFloat();
            sc.nextLine();

            if (user.getAccount(id).deposit(depositAmmount)==true) {
                System.out.println("$" + depositAmmount + " were deposited to account #" + id);
                System.out.println("Account credit: $" + user.getAccount(id).getAmmount());
                sc.nextLine();
                break;
            }
        }
    }

    public static void changeType(Employee user, int id) {
        printheader("CHANGE ACCOUNT TYPE");
        System.out.println("Current account type: " + user.getAccount(id).getType());
        while(true){
            if(Character.toUpperCase(user.getAccount(id).getType())=='C'){
                System.out.println("The account is already upgraded!");
                break;
            }else{
                System.out.println("Please enter a new account type:");
                System.out.print(">> ");
                char newType = sc.nextLine().charAt(0);
                if(user.getAccount(id).setType(user.getAccount(id).getType(), newType) == true){
                    break;
            }
            }
            
        }
        sc.nextLine();
    }

    public static void createNewAccount(Employee user) {
        printheader("CREATE NEW ACCOUNT");
        System.out.println("There are several account types you can create, which are:");
        System.out.println("TYPE A:");
        System.out.println("  > Fund limit: $50,000.00");
        System.out.println("  > Withdraw Minimum: $1,000.00");
        System.out.println("TYPE B:");
        System.out.println("  > Fund limit: $100,000.00");
        System.out.println("  > Withdraw Minimum: $5,000.00");
        System.out.println("TYPE C:");
        System.out.println("  > No fund limit");
        System.out.println("  > Withdraw Minimum: $10,000.00\n");
        
        boolean success = false;
        while(success==false){
            System.out.print(">> Account type: ");
            type = sc.nextLine().charAt(0);
            switch(Character.toUpperCase(type)){
                case 'A':
                case 'B':
                case 'C':
                    success = true;
                    break;
                default:
                    System.out.println("\nThe defined account type is not valid.");
                    System.out.println("Please enter a valid account type:\n");
            }
        }

        success = false;
        
        while(success==false){
            System.out.print(">> Initial deposit/funds for type " + type + " account: ");
            funds = sc.nextFloat();
            sc.nextLine();
            switch(Character.toUpperCase(type)){
                case 'A':
                if(funds>50000 || funds<1000){
                    System.out.println("The defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            case 'B':
                if(funds>100000 || funds<5000){
                    System.out.println("\nThe defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            default:
                if(funds<10000){
                    System.out.println("\nThe defined ammount is not valid.");
                    System.out.println("Please enter a valid ammount:");
                }else{
                    success = true;
                }
                break;
            }
        }

        user.addAccount(new BankAccount(type, user.getUserName(), funds, ran.nextLong(11111111,99999999)));

        printheader("CREATE NEW ACCOUNT");
        System.out.println("Your account has been registered correctly with an initial account!");
        System.out.println("You will be returned to the main menu");
        System.out.println("Press enter...");
        sc.nextLine();
    }

    public static void printheader(String header) {
        System.out.println("=========================================================");
        System.out.println(header);
        System.out.println("=========================================================");
    }

}
