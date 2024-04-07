import java.time.LocalDate;

public class Usuario {
    String name;
    String lastName;
    LocalDate birthDate;
    String CURP;

    // CONSTRUCTOR

    public Usuario(String name, String lastName, LocalDate birthDate, String cURP) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        CURP = cURP;
    }
    
    // GETTERS

    public String getFullName(){
        return name + " " + lastName;
    }

    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public String getCURP(){
        return CURP;
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    // SETTERS

    public void setCURP(String curp){
        this.CURP = curp;
    }

    public void setBirthDate(LocalDate date){
        this.birthDate = date;
    }

    public void setNames(String first, String last){
        this.name = first;
        this.lastName = last;
    }

}
