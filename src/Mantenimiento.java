import java.util.*;
import java.time.LocalDate;

public class Mantenimiento {
    static int nextID=0;
    int id;
    Empleado empInCharge;
    Animal animal;
    String processMade;
    LocalDate processDate;
    ArrayList<String> observations = new ArrayList<>();

    // CONSTRUCTOR

    public Mantenimiento(Empleado empInCharge, Animal animal, String processMade, LocalDate processDate,
            ArrayList<String> observations) {
        this.empInCharge = empInCharge;
        this.animal = animal;
        this.processMade = processMade;
        this.processDate = processDate;
        this.observations = observations;
        this.id = nextID;
        nextID++;
    }

    // GETTERS

    public int getID(){
        return id;
    }

    public String getEmployeeNames(){
        return empInCharge.getFullName();
    }

    public String getAnimalKind(){
        return animal.getKind();
    }

    public String getProcessMade(){
        return processMade;
    }

    public LocalDate getProcessDate(){
        return processDate;
    }

    // OTHERS

    public void printObservationList(){
        System.out.println("OBSERVATIONS: ");
        for (int i = 0; i < observations.size(); i++) {
            System.out.println("   * Observation #" + i + ": " + observations.get(i)); 
        }
    }

    public void printInfo(){
        System.out.println("MAINTENANCE RECORD INFO:");
        System.out.println("   * Record ID: " + id);
        System.out.println("   * Employee in charge: " + empInCharge.getFullName());
        System.out.println("   * Animal treated: " + animal.getKind());
        System.out.println("   * Process made: " + processMade);
        System.out.println("   * Process date: " + processDate.toString());
        printObservationList();
    }
}
