package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private String sector;
    private double salary;
    private long rfc;
    private LocalDate fechaDeAsenso;

    public Gerente(String nombre, String apellido, String numeroTelefono, String sector, double salary, long rfc, String contraseña, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, numeroTelefono, contraseña, nombreUsuario);
        this.sector = sector;
        this.salary = salary;
        this.rfc = rfc;
        this.fechaDeAsenso = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("%sSector: %s\nSalario: %.2f\nRFC: %d\nFecha de asenso: %s", super.toString(), this.sector, this.salary, this.rfc, this.fechaDeAsenso.toString());
    }

}
