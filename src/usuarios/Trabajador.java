package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;

public class Trabajador extends Usuario {
    private long rfc;
    private LocalDate fechaDeContratacion;
    private double salary;

    public Trabajador(String nombre, String apellido, String numeroTelefono, long rfc, double salary, String contraseña, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, numeroTelefono, contraseña, nombreUsuario);
        this.rfc = rfc;
        this.salary = salary;
        this.fechaDeContratacion = LocalDate.now();
    }
    
    @Override
    public String toString(){
        return String.format("%sRFC: %d\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.rfc, this.fechaDeContratacion.toString(), this.salary);
    }

}
