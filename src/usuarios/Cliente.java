package usuarios;
import java.time.LocalDate;

import sistema.*;
import sistema.utils.*;
import java.util.*;

import usuarios.utils.Rol;

public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;
    private static Scanner sc = new Scanner(System.in);

    public Cliente(String nombre, String apellido, String numeroTelefono, String contraseña, String nombreUsuario, LocalDate fechadeNacimiento) {
        super(nombre, apellido, Rol.CLIENTE, numeroTelefono, contraseña, nombreUsuario, fechadeNacimiento);
        this.fechaDeRegistro = LocalDate.now();
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString(){
        return String.format("%sFecha de Registro %s\n", super.toString(), fechaDeRegistro.toString());
    }
    
    public static void registrarCliente(){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreusuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.println("Ingrese su fecha de nacimiento (ÚNICAMENTE CON NÚMEROS)");
        System.out.print("Día: ");
        int dia = ConsoleReader.nextInt();
        System.out.print("Mes: ");
        int mes = ConsoleReader.nextInt();
        System.out.print("Año: ");
        int año = ConsoleReader.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
        Cliente cliente = new Cliente(nombre, apellido, telefono, contraseña, nombreusuario, fechaNacimiento);

        Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("¡El cliente ha sido registrado correctamente!");
        System.out.println("ID de usuario: " + cliente.getId());
        Designer.continuar();
    }

    public static void modificarCliente(Cliente client){
        Cliente cliente = null;
        if(client==null){
            Designer.printHeader("MODIFICAR CLIENTE");
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Cliente)){
                    System.out.println("El usuario encontrado no es un cliente");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    cliente = (Cliente)usuario;
                    Biblioteca.usuarios.get(Rol.CLIENTE).remove(usuario);
                    break;
                }
            }
        }else{
            cliente = client;
        }
        
        Designer.printHeader("MODIFICAR CLIENTE");
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre y apellido");
        System.out.println("2. Número del teléfono");
        System.out.println("3. Nombre de usuario");
        System.out.println("4. Contraseña");
        System.out.println("5. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                Designer.printHeader("MODIFICAR NOMBRE Y APELLIDO");
                System.out.println("Nombre completo actual: " + cliente.getNombreCompleto());
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el nuevo apellido:");
                String apellido = sc.nextLine();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
                System.out.println("¡El nombre y apellido ha sido modificados correctamente!");
                Designer.continuar();
                break;
        
            case 2:
                Designer.printHeader("MODIFICAR NÚMERO DE TELÉFONO");
                System.out.println("Número de teléfono actual: " + cliente.getNumeroTelefono());
                System.out.print("Ingrese el nuevo número de teléfono: ");
                String telefono = sc.nextLine();
                cliente.setNumeroTelefono(telefono);
                Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
                System.out.println("¡El número de teléfono ha sido modificado correctamente!");
                Designer.continuar();
                break;
        
            case 3:
                Designer.printHeader("MODIFICAR NOMBRE DE USUARIO");
                System.out.println("Nombre de usuario actual: " + cliente.getNombreUsuario());
                System.out.print("Ingrese el nuevo nombre de usuario: ");
                String nombreUsuario = sc.nextLine();
                cliente.setNombreUsuario(nombreUsuario);
                Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
                System.out.println("¡El nombre de usuario ha sido modificado correctamente!");
                Designer.continuar();
                break;

            case 4:
                String validacion = "";
                Designer.printHeader("MODIFICAR CONTRASEÑA");
                System.out.println("Contraseña actual: " + cliente.getContraseña());
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

                cliente.setContraseña(contraseña);
                Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
                System.out.println("¡La contraseña ha sido modificada correctamente!");
                Designer.continuar();
                break;
        
            default:
                Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
                break;
        }
    }

    public static void eliminarCliente(Cliente client){
        Cliente cliente = null;
        if(client==null){
            Designer.printHeader("ELIMINAR CLIENTE");
            while(true){
                Usuario usuario = buscarUsuario();
                if(!(usuario instanceof Cliente)){
                    System.out.println("El usuario encontrado no es un cliente");
                    System.out.println("Ingrese un usuario válido");
                }else{
                    cliente = (Cliente)usuario;
                    Biblioteca.usuarios.get(Rol.CLIENTE).remove(usuario);
                    break;
                }
            }
        }else{
            cliente = client;
        }

        Designer.printHeader("ELIMINAR CLIENTE");
        System.out.println("¿Está seguro de que quiere eliminar a este cliente? (s/n)");
        System.out.print(">> ");
        char opc = sc.nextLine().charAt(0);
        if(Designer.yesOrNo(opc)){
            Biblioteca.usuarios.get(Rol.CLIENTE).remove(cliente);
            System.out.println("El cliente ha sido eliminado correctamente");
        }else{
            System.out.println("El cliente no ha sido eliminado");
        }
        Designer.continuar();
    }

    public static void mostrarClientes(){
        System.out.println("CLIENTES:");
        for (Usuario usuarioAMostrar : Biblioteca.usuarios.get(Rol.CLIENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
        Designer.continuar();
    }

}
