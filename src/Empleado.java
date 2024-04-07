import java.time.LocalDate;

public class Empleado extends Usuario{
    long RFC;
    float salary;
    String startTime;
    String endTime;
    LocalDate entryDate;
    String role;
    
    // CONSTRUCTOR

    public Empleado(String name, String lastName, LocalDate birthDate, String cURP, long rFC, float salary,
            String startTime, String endTime, LocalDate entryDate, String role) {
        super(name, lastName, birthDate, cURP);
        RFC = rFC;
        this.salary = salary;
        this.startTime = startTime;
        this.endTime = endTime;
        this.entryDate = entryDate;
        this.role = role;
    }

    // GETTERS

    public String getRole(){
        return role;
    }

    public long getRFC(){
        return RFC;
    }

    public float getSalary(){
        return salary;
    }

    public String getSchedule(){
        return "From " + startTime + " to " + endTime;
    }

    public void getInfo(){
        System.out.println(" * Name: " + name + " " + lastName);
        System.out.println(" * Birth Date: " + birthDate.toString());
        System.out.println(" * CURP: " + CURP);
        System.out.println(" * RFC: " + RFC);
        System.out.println(" * Salary: " + salary);
        System.out.println(" * Schedule:");
        System.out.println("     * Start time: " + startTime.toString());
        System.out.println("     * End time: " + endTime.toString());
        System.out.println(" * Entry date: " + entryDate.toString());
        System.out.println(" * Role: " + role);
    }

    // SETTERS

    public void setRFC(int rfc){
        this.RFC = rfc;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public void setStartTime(String start){
        this.startTime = start;
    }
    
    public void setEndTime(String end){
        this.endTime = end;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

}