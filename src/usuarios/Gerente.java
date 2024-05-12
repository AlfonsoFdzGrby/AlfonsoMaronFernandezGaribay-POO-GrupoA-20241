package usuarios;

import usuarios.utils.Rol;
import java.time.*;
import java.time.format.DateTimeFormatter;

import sistema.*;
import sistema.utils.*;

import java.util.*;

public class Gerente extends Usuario {
    private String sector;
    private double salary;
    private long rfc;
    private LocalDate fechaDeAsenso;

    private static Scanner sc = new Scanner(System.in);

    public Gerente(String nombre, String apellido, String numeroTelefono, String sector, double salary, long rfc, String contraseña, String nombreUsuario, LocalDate fechaDeNacimiento) {
        super(nombre, apellido, Rol.GERENTE, numeroTelefono, contraseña, nombreUsuario, fechaDeNacimiento);
        this.sector = sector;
        this.salary = salary;
        this.rfc = rfc;
        this.fechaDeAsenso = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("%sSector: %s\nSalario: %.2f\nRFC: %d\nFecha de asenso: %s", super.toString(), this.sector, this.salary, this.rfc, this.fechaDeAsenso.toString());
    }

    public static void registrarGerente(){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String numTelefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.println("Ingrese su fecha de nacimiento (ÚNICAMENTE CON NÚMEROS)");
        System.out.print("Día: ");
        int dia = ConsoleReader.nextInt();
        System.out.print("Mes: ");
        int mes = ConsoleReader.nextInt();
        System.out.print("Año: ");
        int año = ConsoleReader.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
        System.out.println("Ingrese su sector");
        System.out.print(">> ");
        String sector = sc.nextLine();
        System.out.println("Ingrese su RFC");
        System.out.print(">> ");
        long rfc = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingrese su salario mensual");
        System.out.print(">> ");
        double salary = sc.nextDouble();
        sc.nextLine();
        Gerente gerente = new Gerente(nombre, apellido, numTelefono, sector, salary, rfc, contraseña, nombreUsuario, fechaNacimiento);
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("¡El gerente ha sido registrado exitosamente!");
        System.out.println("ID de usuario: " + gerente.getId());
        Designer.continuar();
    }

    public static void modificarGerente(Gerente ger){
        Gerente gerente = null;
        if(ger==null){
            Designer.printHeader("MODIFICAR GERENTE");
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Gerente)){
                    System.out.println("El usuario encontrado no es un gerente");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    gerente = (Gerente)usuario;
                    Biblioteca.usuarios.get(Rol.GERENTE).remove(usuario);
                    break;
                }
            }
        }else{
            gerente = ger;
        }

        Designer.printHeader("MODIFICAR GERENTE");
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre y apellido");
        System.out.println("2. Número del teléfono");
        System.out.println("3. Nombre de usuario");
        System.out.println("4. Contraseña");
        System.out.println("5. Sector");
        System.out.println("6. Salario");
        System.out.println("7. RFC");
        System.out.println("8. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();
        switch (opc) {
            case 1:
                Designer.printHeader("MODIFICAR NOMBRE Y APELLIDO");
                System.out.println("Nombre completo actual: " + gerente.getNombreCompleto());
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el nuevo apellido:");
                String apellido = sc.nextLine();
                gerente.setNombre(nombre);
                gerente.setApellido(apellido);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El nombre y apellido ha sido modificados correctamente!");
                Designer.continuar();
                break;
        
            case 2:
                Designer.printHeader("MODIFICAR NÚMERO DE TELÉFONO");
                System.out.println("Número de teléfono actual: " + gerente.getNumeroTelefono());
                System.out.print("Ingrese el nuevo número de teléfono: ");
                String telefono = sc.nextLine();
                gerente.setNumeroTelefono(telefono);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El número de teléfono ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 3:
                Designer.printHeader("MODIFICAR NOMBRE DE USUARIO");
                System.out.println("Nombre de usuario actual: " + gerente.getNombreUsuario());
                System.out.print("Ingrese el nuevo nombre de usuario: ");
                String nombreUsuario = sc.nextLine();
                gerente.setNombreUsuario(nombreUsuario);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El nombre de usuario ha sido modificado correctamente!");
                Designer.continuar();
                break;

            case 4:
                String validacion = "";
                Designer.printHeader("MODIFICAR CONTRASEÑA");
                System.out.println("Contraseña actual: " + gerente.getContraseña());
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

                gerente.setContraseña(contraseña);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡La contraseña ha sido modificada correctamente!");
                Designer.continuar();
                break;
        
            case 5:
                Designer.printHeader("MODIFICAR SECTOR");
                System.out.println("Sector actual: " + gerente.getSector());
                System.out.print("Ingrese el nuevo sector: ");
                String sector = sc.nextLine();
                gerente.setSector(sector);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El sector ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 6:
                Designer.printHeader("MODIFICAR SALARIO");
                System.out.println("Salario actual: " + gerente.getSalary());
                System.out.print("Ingrese el nuevo salario: ");
                double salario = sc.nextDouble();
                gerente.setSalary(salario);
                sc.nextLine();
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El salario ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 7:
                Designer.printHeader("MODIFICAR RFC");
                System.out.println("RFC actual: " + gerente.getRfc());
                System.out.print("Ingrese el nuevo RFC: ");
                long rfc = sc.nextLong();
                sc.nextLine();
                gerente.setRfc(rfc);
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                System.out.println("¡El RFC ha sido modificado exitosamente!");
                Designer.continuar();
                break;
        
            default:
                Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
                break;
        }
    }

    public static void eliminarGerente(Gerente ger){
        Gerente gerente = null;
        if(ger==null){
            Designer.printHeader("MODIFICAR GERENTE");
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Gerente)){
                    System.out.println("El usuario encontrado no es un gerente");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    gerente = (Gerente)usuario;
                    Biblioteca.usuarios.get(Rol.GERENTE).remove(usuario);
                    break;
                }
            }
        }else{
            gerente = ger;
        }

        Designer.printHeader("ELIMINAR GERENTE");
        System.out.println("¿Está seguro de que quiere eliminar a este gerente? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        if(Designer.yesOrNo(opc)){
            Biblioteca.usuarios.get(Rol.GERENTE).remove(gerente);
            System.out.println("El gerente ha sido eliminado correctamente");
        }else{
            System.out.println("El gerente no ha sido eliminado");
        }
        Designer.continuar();
    }

    public static void checarEntrada(Gerente gerente){
        LocalDateTime entrada = LocalDateTime.now();
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/YYY a las HH:mm");
        System.out.println("Hora de entrada del gerente " + gerente.getNombreCompleto() + ": " + entrada.format(formatoFechaHora));
        Designer.continuar();
    }

    public static void checarSalida(Gerente gerente){
        LocalDateTime salida = LocalDateTime.now();
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/YYY a las HH:mm");
        System.out.println("Hora de salida del gerente " + gerente.getNombreCompleto() + ": " + salida.format(formatoFechaHora));
        Designer.continuar();
    }

    public static void mostrarGerentes(){
        System.out.println("GERENTES");
        for (Usuario usuarioAMostrar : Biblioteca.usuarios.get(Rol.GERENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
        Designer.continuar();
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRfc(long rfc) {
        this.rfc = rfc;
    }

    public long getRfc() {
        return rfc;
    }

}
