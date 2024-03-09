import java.util.ArrayList;

public class Employee {
    private String userName;
    private BankAccount account;
    public ArrayList<BankAccount> accountList = new ArrayList<>();

    public Employee(char type, String userName, float ammount, long accountNum) {
        account = new BankAccount(type, userName, ammount, accountNum);
        accountList.add(account);
        this.userName = userName;
    }

    public BankAccount getAccount(int id) {
        return accountList.get(id);
    }

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }

    public void addAccount(BankAccount account) {
        accountList.add(account);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void printAcList(){
        System.out.println(userName+"'s accounts:");
        for (int index = 0; index < accountList.size(); index++) {
            System.out.println("Account #" + index);
            System.out.println("  * Number: " + accountList.get(index).getAccountNum());
            System.out.println("  * Type: " + accountList.get(index).getType());
            System.out.println("  * Funds: $" + accountList.get(index).getAmmount());
            System.out.println();
        }
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

}
