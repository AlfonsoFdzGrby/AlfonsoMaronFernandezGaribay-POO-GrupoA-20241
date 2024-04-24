package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import sistema.*;
import sistema.utils.DatosComun;
import sistema.utils.Designer;

public class Trabajador extends Usuario {
    private long rfc;
    private LocalDate fechaDeContratacion;
    private double salary;

    private static Scanner sc = new Scanner(System.in);

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

    public static void registrarTrabajador(){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String numTelefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.print(">> ");
        long rfc = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingrese su salario mensual");
        System.out.print(">> ");
        double salary = sc.nextDouble();
        sc.nextLine();
        Trabajador trabajador = new Trabajador(nombre, apellido, numTelefono, rfc, salary, contraseña, nombreUsuario);
        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
        System.out.println("¡El trabajador ha sido registrado exitosamente!");
        System.out.println("ID de usuario: " + trabajador.getId());
        Designer.continuar();
    }

    public static void modificarTrabajador(Trabajador trabaj){
        Trabajador trabajador = null;
        if(trabaj==null){
            Designer.printHeader("MODIFICAR TRABAJADOR");  
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Trabajador)){
                    System.out.println("El usuario encontrado no es un trabajador");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    trabajador = (Trabajador)usuario;
                    Biblioteca.usuarios.get(Rol.TRABAJADOR).remove(usuario);
                    break;
                }
            }
        }else{
            trabajador = trabaj;
        }
        Designer.printHeader("MODIFICAR TRABAJADOR");
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre y apellido");
        System.out.println("2. Número de teléfono");
        System.out.println("3. Nombre de usuario");
        System.out.println("4. Contraseña");
        System.out.println("5. RFC");
        System.out.println("6. Salario");
        System.out.println("7. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                Designer.printHeader("MODIFICAR NOMBRE");
                System.out.println("Nombre completo actual: " + trabajador.getNombreCompleto());
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el nuevo apellido:");
                String apellido = sc.nextLine();
                trabajador.setNombre(nombre);
                trabajador.setApellido(apellido);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡El nombre y apellido han sido modificados correctamente!");
                Designer.continuar();
                break;
        
            case 2:
                Designer.printHeader("MODIFICAR NÚMERO DE TELÉFONO");
                System.out.println("Número de teléfono actual: " + trabajador.getNumeroTelefono());
                System.out.print("Ingrese el nuevo número de teléfono: ");
                String telefono = sc.nextLine();
                trabajador.setNumeroTelefono(telefono);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡El número de teléfono ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 3:
                Designer.printHeader("MODIFICAR NOMBRE DE USUARIO");
                System.out.println("Nombre de usuario actual: " + trabajador.getNombreUsuario());
                System.out.print("Ingrese el nuevo nombre de usuario: ");
                String nombreUsuario = sc.nextLine();
                trabajador.setNombreUsuario(nombreUsuario);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡El nombre de usuario ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 4:
                String validacion = "";
                Designer.printHeader("MODIFICAR CONTRASEÑA");
                System.out.println("Contraseña actual: " + trabajador.getContraseña());
                System.out.print("Ingrese la nueva contraseña: ");
                String contraseña = sc.nextLine();
                
                while(true){
                    System.out.print("Ingrese la contraseña de nuevo: ");
                    validacion = sc.nextLine();
                    if(validacion!=contraseña){
                        System.out.println("La contraseña ingresada no coincide");
                    }else{
                        break;
                    }
                }

                trabajador.setContraseña(contraseña);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡La contraseña ha sido modificada correctamente!");
                Designer.continuar();
                break;
        
            case 5:
                Designer.printHeader("MODIFICAR RFC");
                System.out.println("RFC actual: " + trabajador.getRfc());
                System.out.print("Ingrese el nuevo RFC: ");
                long nuevoRFC = sc.nextLong();
                sc.nextLine();
                trabajador.setRfc(nuevoRFC);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡El nuevo RFC ha sido registrado correctamente!");
                Designer.continuar();
                break;
        
            case 6:
                Designer.printHeader("MODIFICAR SALARIO");
                System.out.println("Salario actual: " + trabajador.getSalary());
                System.out.print("Ingrese el nuevo salario: ");
                double newSalary = sc.nextDouble();
                trabajador.setSalary(newSalary);
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                System.out.println("¡El nuevo salario ha sido registrado correctamente!");
                Designer.continuar();
                break;
        
            default:
                Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
                break;
        }
    }

    public static void eliminarTrabajador(Trabajador trabaj){
        Trabajador trabajador = null;
        if(trabaj==null){
            Designer.printHeader("ELIMINAR TRABAJADOR");
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Trabajador)){
                    System.out.println("El usuario encontrado no es un cliente");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    trabajador = (Trabajador)usuario;
                    Biblioteca.usuarios.get(Rol.TRABAJADOR).remove(usuario);
                    break;
                }
            }
        }else{
            trabajador = trabaj;
        }
        Designer.printHeader("ELIMINAR TRABAJADOR");
        System.out.println("¿Está seguro de que quiere eliminar a este trabajador? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        if(Designer.yesOrNo(opc)){
            Biblioteca.usuarios.get(Rol.TRABAJADOR).remove(trabajador);
            System.out.println("El trabajador ha sido eliminado correctamente");
        }else{
            System.out.println("El trabajador no ha sido eliminado");
        }
        Designer.continuar();
    }

    public static void mostrarTrabajadores(){
        System.out.println("TRABAJADORES:");
        for (Usuario usuarioAMostrar : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
        Designer.continuar();
    }

    public long getRfc() {
        return rfc;
    }

    public void setRfc(long rfc) {
        this.rfc = rfc;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
