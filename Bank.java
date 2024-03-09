import java.util.*;
public class Bank {
    public static ArrayList<Employee> employeeList = new ArrayList<>();

    public void listEmployees() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(" * "+employeeList.get(i).getUserName());
        }
    }

    public Employee getUser(){
        return employeeList.get(0);
    }

    public boolean checkUser(String emp){
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if(emp.equals(employeeList.get(i).getUserName())){
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean checkAccountID(Employee emp, int id){
        boolean found = false;
        if(id < 0 || id > emp.getAccountList().size()){
            found = false;
        }else{
            found = true;
        }
        return found;
    }

    public void storeUser(Employee user) {
        employeeList.add(user);
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
