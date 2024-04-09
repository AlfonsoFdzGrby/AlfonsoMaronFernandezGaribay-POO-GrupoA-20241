public class Persona {
    String nombre;
    String CURP;
    String fechaNacimiento;

    public Persona(String nombre, String cURP, String fechaNacimiento) {
        this.nombre = nombre;
        CURP = cURP;
        this.fechaNacimiento = fechaNacimiento;
    }

    protected String getNombre(){
        return nombre;
    }
    
}
