import java.util.*;
public class BankAccount {
    private char type;
    private String user;
    private float ammount;
    private float withdrawLimit;
    private float depositLimit;
    private long accountNum;

    Scanner sc = new Scanner(System.in);

    public BankAccount(char type, String user, float ammount, long accountNum){
        switch (Character.toUpperCase(type)) {
            case 'A':
            case 'B':
            case 'C':
                this.type = Character.toUpperCase(type);
                this.user = user;
                this.ammount = ammount;
                this.accountNum = accountNum;
                break;
            default:
                break;
        }
    }

    public boolean setType(char originalType, char newType) {
        boolean success = false;
        switch (Character.toUpperCase(newType)) {
            case 'A':
                if(Character.toUpperCase(originalType)=='B' || Character.toUpperCase(originalType)=='C'){
                    System.out.println("Account cannot be downgraded");
                    break;
                }else{
                    this.type = Character.toUpperCase(newType);
                    success = true;
                    System.out.println("The account has been upgraded succesfully!");
                    break;
                }
            case 'B':
                if(Character.toUpperCase(originalType)=='C'){
                    System.out.println("Account cannot be downgraded");
                    break;
                }else{
                    this.type = Character.toUpperCase(newType);
                    success = true;
                    System.out.println("The account has been upgraded succesfully!");
                    break;
                }
            case 'C':
                this.type = Character.toUpperCase(newType);
                success = true;
                System.out.println("The account has been upgraded succesfully!");
                break;
            default:
                System.out.println("The entered account type is not allowed");
                break;
        }
        return success;
    }

    public boolean deposit(float ammount) {
        boolean success=false;
        switch (this.type) {
            case 'A':
                depositLimit = 50000;
                if(ammount>depositLimit || (ammount+this.ammount)>depositLimit || ammount<=0){
                    System.out.println("The entered amount is not valid");
                }else{
                    this.ammount += ammount;
                    success = true;
                }
                break;
            case 'B':
                depositLimit = 100000;
                if(ammount>depositLimit || (ammount+this.ammount)>depositLimit || ammount<=0){
                    System.out.println("The entered amount is not valid");
                }else{
                    this.ammount += ammount;
                    success = true;
                }
                break;
            default:
                if(ammount<=0){
                    System.out.println("The entered amount is not valid");
                }else{
                    this.ammount += ammount;
                    success = true;
                }
                break;
        }
        return success;
    }

    public boolean withdraw(float ammount) {
        boolean success = false;
        switch (this.type) {
            case 'A':
                withdrawLimit = 1000;
                if(ammount<withdrawLimit || ammount>this.ammount || ammount<=0){
                    System.out.println("The specified amount is not valid");
                    System.out.println("The withdraw minimum of this type " + Character.toUpperCase(this.type) + " account is " + withdrawLimit);
                    System.out.println("Please enter a valid amount");
                }else{
                    this.ammount-=ammount;
                    success = true;
                }
                break;
            case 'B':
                withdrawLimit = 5000;
                if(ammount<withdrawLimit || ammount>this.ammount || ammount<=0){
                    System.out.println("The specified amount is not valid");
                    System.out.println("The withdraw minimum of this type " + Character.toUpperCase(this.type) + " account is " + withdrawLimit);
                    System.out.println("Please enter a valid amount");
                }else{
                    this.ammount-=ammount;
                    success = true;
                }
                break;
            default:
                withdrawLimit = 10000;
                if(ammount<withdrawLimit || ammount>this.ammount || ammount<=0){
                    System.out.println("The specified amount is not valid");
                    System.out.println("The withdraw minimum of this type " + Character.toUpperCase(this.type) + " account is " + withdrawLimit);
                    System.out.println("Please enter a valid amount");
                }else{
                    this.ammount-=ammount;
                    success = true;
                }
                break;
        }
        return success;
    }

    public String getAccountInfo() {
        String accountInfo = String.format("\nUser: %s\nAccount Number: %d\nAccount Type: %c\nFunds: $%.2f\n", getUser(), getAccountNum(), getType(), getAmmount());
        return accountInfo;
    }

    public long getAccountNum() {
        return accountNum;
    }

    public char getType() {
        return type;
    }

    public float getAmmount() {
        return ammount;
    }

    public String getUser() {
        return user;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
