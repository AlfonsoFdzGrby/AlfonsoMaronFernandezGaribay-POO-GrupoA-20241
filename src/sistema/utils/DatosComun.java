package sistema.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import sistema.Biblioteca;
import usuarios.Usuario;
import usuarios.utils.Rol;
import sistema.utils.*;

public class DatosComun {

    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> obtenerDatosComun(Rol rol){
        ArrayList<String> datosComun = new ArrayList<>();
        String rolActual = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        Designer.printHeader(String.format("REGISTRAR %s", rolActual.toUpperCase()));
        System.out.println("Ingrese su nombre");
        System.out.print(">> ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido");
        System.out.print(">> ");
        String apellido = sc.nextLine();
        String numTelefono = obtenerNumeroTelefono();
        String nombreUsuario = obtenerNombreUsuario();
        System.out.println("Ingrese su contraseña");
        System.out.print(">> ");
        String contraseña = sc.nextLine();
        datosComun.addAll(Arrays.asList(nombre, apellido, numTelefono, nombreUsuario, contraseña));
        return datosComun;
    }

    public static String obtenerNumeroTelefono(){
        String numero = "";
        
        while(true){
            boolean encontrado = false;
            System.out.println("Ingrese su número de teléfono: ");
            System.out.print(">> ");
            numero = sc.nextLine();
            for (ArrayList<Usuario> usuarios : Biblioteca.usuarios.values()) {
                for (Usuario usuario : usuarios) {
                    if(usuario.getNumeroTelefono().equals(numero)){
                        encontrado = true;
                        break;
                    }
                }
                if(encontrado){
                    break;
                }
            }
            if(encontrado){
                System.out.println("El teléfono ya está registrado");
            }else{
                System.out.println("¡El teléfono ha sido asignado correctamente!");
                break;
            }
        }
        return numero;
    }

    public static String obtenerNombreUsuario(){
        String nombreUsuario = "";
        
        while(true){
            boolean encontrado = false;
            System.out.println("Ingrese su nombre de usuario: ");
            System.out.print(">> ");
            nombreUsuario = sc.nextLine();
            for (ArrayList<Usuario> usuarios : Biblioteca.usuarios.values()) {
                for (Usuario usuario : usuarios) {
                    if(usuario.getNombreUsuario().equals(nombreUsuario)){
                        encontrado = true;
                        break;
                    }
                }
                if(encontrado){
                    break;
                }
            }
            if(encontrado){
                System.out.println("El nombre de usuario ya está registrado");
            }else{
                System.out.println("¡El nombre de usuario ha sido asignado correctamente!");
                break;
            }
        }
        return nombreUsuario;
    }
}
