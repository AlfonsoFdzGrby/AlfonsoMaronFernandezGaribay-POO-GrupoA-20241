public class Empleado extends Persona {
    double salario;
    int RFC;

    public Empleado(String nombre, String cURP, String fechaNacimiento, double salario, int rFC) {
        super(nombre, cURP, fechaNacimiento);
        this.salario = salario;
        RFC = rFC;
    }

}
