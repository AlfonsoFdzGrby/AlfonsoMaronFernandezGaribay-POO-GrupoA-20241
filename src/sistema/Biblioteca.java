package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import usuarios.*;
import usuarios.utils.Rol;

public class Biblioteca {

    private Scanner sc = new Scanner(System.in);
    private HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Biblioteca(){
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
    }

    private String obtenerNumeroTelefono(){
        boolean encontrado = false;
        String numero = "";
        
        while(encontrado == false){
            System.out.println("Ingrese su número de teléfono: ");
            System.out.print(">> ");
            numero = sc.nextLine();
            for (ArrayList<Usuario> usuarios : usuarios.values()) {
                for (Usuario usuario : usuarios) {
                    if(usuario.getNumeroTelefono().equals(numero)){
                        encontrado = true;
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
        }

        return numero;
        
    }

    private String obtenerNombreUsuario(){
        boolean encontrado = false;
        String nombreUsuario = "";
        
        while(encontrado == false){
            System.out.println("Ingrese su nombre de usuario: ");
            System.out.print(">> ");
            nombreUsuario = sc.nextLine();
            for (ArrayList<Usuario> usuarios : usuarios.values()) {
                for (Usuario usuario : usuarios) {
                    if(usuario.getNombreUsuario().equals(nombreUsuario)){
                        encontrado = true;
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
        }

        return nombreUsuario;

    }

    public ArrayList<String> obtenerDatosComun(Rol rol){
        ArrayList<String> datosComun = new ArrayList<>();
        String rolActual = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        System.out.println(String.format("Registrar %s", rolActual));
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

    public void registrarCliente(){
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreusuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        Cliente cliente = new Cliente(nombre, apellido, telefono, contraseña, nombreusuario);

        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("¡El cliente ha sido registrado correctamente!");
        continuar();
    }

    public Usuario buscarUsuario(){
        Usuario usuario = null;
        while(true){
            System.out.println("Ingrese su nombre de usuario");
            System.out.print(">> ");
            String nombreUsuario = sc.nextLine();

            for (ArrayList<Usuario> usuarios : usuarios.values()) {
                for (Usuario usuarioABuscar : usuarios) {
                    if(usuarioABuscar.getNombreUsuario().equals(nombreUsuario)){
                        usuario = usuarioABuscar;
                    }
                }
            }

            if(usuario!=null){
                System.out.println("¡Usuario encontrado!");
                break;
            }else{
                System.out.println("Usuario no encontrado");
            }
        }
        return usuario;
    }


    public void mostrarClientes(){
        System.out.println("CLIENTES:");
        for (Usuario usuarioAMostrar : usuarios.get(Rol.CLIENTE)) {
            System.out.println("   * " + usuarioAMostrar.getNombreUsuario());
        }
        continuar();
    }

    public HashMap<Rol, ArrayList<Usuario>> getUsuarios() {
        return usuarios;
    }

    private void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    public void agregarUsuario(Usuario usuario, Rol rol){
        usuarios.get(rol).add(usuario);
    }

}
