import java.util.*;
import java.time.LocalDate;

public class Visita {
    static int nextID = 0;
    int id;
    Empleado guide;
    ArrayList<Visitante> visitorList = new ArrayList<>();
    float total;
    LocalDate visitDate;
    int children;
    int adults;

    // CONSTRUCTOR

    public Visita(Empleado guide, ArrayList<Visitante> visitorList, LocalDate visitDate) {
        this.guide = guide;
        this.visitorList = visitorList;
        this.visitDate = visitDate;
        for (int i = 0; i < visitorList.size(); i++) {
            if(visitorList.get(i).getBirthDate().getYear()<2006){
                adults++;
                if(visitorList.get(i).numVisitas%5==0){
                    total+=80;
                }else{
                    total+=100;
                }
            }else{
                children++;
                if(visitorList.get(i).numVisitas%5==0){
                    total+=40;
                }else{
                    total+=50;
                }
            }
        }
        this.id = nextID;
        nextID++;
    }

    // GETTERS

    public int getID(){
        return this.id;
    }

    public ArrayList<Visitante> getVisitorList(){
        return visitorList;
    }

    public LocalDate getVisitDate(){
        return visitDate;
    }

    public void getVisitInfo(){
        System.out.println("   * ID: " + id);
        System.out.println("   * Guide in charge: " + this.guide.getFullName());
        System.out.println("   * Visitors:");
        for (int i = 0; i < visitorList.size(); i++) {
            System.out.println("     * " + visitorList.get(i).getFullName());
        }
        System.out.println("   * Tickets:");
        System.out.println("     * Children ($50 MXN):");
        for (int i = 0; i < visitorList.size(); i++) {
            if(visitorList.get(i).getBirthDate().getYear()>2006){
                System.out.println("       * " + visitorList.get(i).getFullName());
            }
        }
        System.out.println("     * Number of children: " + children);
        System.out.println("     * Adults ($100 MXN)");
        for (int i = 0; i < visitorList.size(); i++) {
            if(visitorList.get(i).getBirthDate().getYear()<2006){
                System.out.println("       * " + visitorList.get(i).getFullName());
            }
        }
        System.out.println("     * Number of adults: " + adults);
        System.out.println("   * Total: $" + total);
    }

}
