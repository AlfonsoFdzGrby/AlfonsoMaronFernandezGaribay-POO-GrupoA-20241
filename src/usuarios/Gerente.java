package src.usuarios;

import src.usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private String jerarquia;
    private double salary;
    private long rfc;
    private LocalDate fechaDeAsenso;

    public Gerente(String nombre, String apellido, String jerarquia, double salary, long rfc, String contraseña, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, contraseña, nombreUsuario);
        this.jerarquia = jerarquia;
        this.salary = salary;
        this.rfc = rfc;
        this.fechaDeAsenso = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("%sJerarquía: %s\nSalario: %.2f\nRFC: %d\nFecha de asenso: %s", super.toString(), this.jerarquia, this.salary, this.rfc, this.fechaDeAsenso.toString());
    }

}
