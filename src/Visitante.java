import java.time.LocalDate;

public class Visitante extends Usuario {
    int numVisitas = 0;
    LocalDate fechaDeRegistro;
    
    // CONSTRUCTOR

    public Visitante(String name, String lastName, LocalDate birthDate, String cURP,
            LocalDate fechaDeRegistro) {
        super(name, lastName, birthDate, cURP);
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public void añadirVisita(){
        numVisitas++;
    }

    // GETTER

    public int getVisitNum(){
        return numVisitas;
    }

    public void getInfo(){
        System.out.println(" * Name: " + name + " " + lastName);
        System.out.println(" * Birth Date: " + birthDate.toString());
        System.out.println(" * CURP: " + CURP);
        System.out.println(" * Registration date: " + fechaDeRegistro.toString());
    }

}