package sistema;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import usuarios.*;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;

public class Biblioteca {

    private Scanner sc = new Scanner(System.in);
    private UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    private HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Biblioteca(){
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
    }

    //---------------------------------------- MÉTODOS PÚBLICOS ----------------------------------------

    public void crearCuenta(){
        printHeader("CREAR CUENTA");
        System.out.println("Seleccione el tipo de cuenta a crear");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.println("4. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1 -> registrarCliente();
            case 2 -> registrarTrabajador();
            case 3 -> registrarGerente();
        }
    }
    
    public void iniciarSesion(){
        printHeader("INICIAR SESIÓN");
        Usuario usuario = null;
        int intentos = 3;

        if(usuarios.get(Rol.CLIENTE).isEmpty() && usuarios.get(Rol.GERENTE).isEmpty() && usuarios.get(Rol.TRABAJADOR).isEmpty()){
            System.out.println("No hay usuarios registrados aún");
            System.out.println("Por favor registre al menos un usuario antes de iniciar sesión...");
            continuar();
        }else{
            usuario = buscarUsuario();
            while(true){
                System.out.println("Ingrese la contraseña");
                System.out.println("Tiene " + intentos + " intentos restantes");
                System.out.print(">> ");
                String contraseña = sc.nextLine();
                if(contraseña.equals(usuario.getContraseña())){
                    System.out.println("¡La contraseña es correcta!");
                    continuar();
                    usuarioEnSesion = UsuarioEnSesion.getInstancia();
                    usuarioEnSesion.setUsuario(usuario);
                    Menu.menuUsuarios();
                    break;
                }else{
                    System.out.println("La contraseña no es correcta");
                    intentos--;
                    if(intentos==0){
                        System.out.println("Sus intentos se han agotado.");
                        continuar();
                        break;
                    }
                }
            }
        }
    }

    //---------------------------------------- MENÚS DE USUARIOS -----------------------------------------



    //---------------------------------------- OBTENCIÓN DE DATOS ----------------------------------------

    private Usuario buscarUsuario(){
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

    private String obtenerNumeroTelefono(){
        String numero = "";
        
        while(true){
            boolean encontrado = false;
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

    private String obtenerNombreUsuario(){
        String nombreUsuario = "";
        
        while(true){
            boolean encontrado = false;
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

    private ArrayList<String> obtenerDatosComun(Rol rol){
        ArrayList<String> datosComun = new ArrayList<>();
        String rolActual = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        System.out.println(String.format("REGISTRAR %s", rolActual.toUpperCase()));
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

    //---------------------------------------- REGISTRO DE USUARIOS ----------------------------------------

    private void registrarCliente(){
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

    private void registrarTrabajador(){
        ArrayList<String> datosComun = obtenerDatosComun(Rol.TRABAJADOR);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String numTelefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contraseña = datosComun.get(5);
        System.out.print(">> ");
        long rfc = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingrese su salario mensual");
        System.out.print(">> ");
        double salary = sc.nextDouble();
        sc.nextLine();
        agregarUsuario(new Trabajador(nombre, apellido, numTelefono, rfc, salary, contraseña, nombreUsuario), Rol.TRABAJADOR);
        System.out.println("¡El trabajador ha sido registrado exitosamente!");
        continuar();
    }

    private void registrarGerente(){
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String numTelefono = datosComun.get(3);
        String nombreUsuario = datosComun.get(4);
        String contraseña = datosComun.get(5);
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
        agregarUsuario(new Gerente(nombre, apellido, numTelefono, sector, salary, rfc, contraseña, nombreUsuario), Rol.GERENTE);
        System.out.println("¡El gerente ha sido registrado exitosamente!");
        continuar();
    }

    //---------------------------------------- MUESTRA DE DATOS ----------------------------------------

    private void mostrarClientes(){
        System.out.println("CLIENTES:");
        for (Usuario usuarioAMostrar : usuarios.get(Rol.CLIENTE)) {
            System.out.println("   * " + usuarioAMostrar.getNombreUsuario());
        }
        continuar();
    }

    //---------------------------------------- DISEÑO E INTERFAZ ----------------------------------------

    private void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    private void printHeader(String header){
        System.out.println("=============================================");
        System.out.println(header);
        System.out.println("=============================================");
    }

    //---------------------------------------- GETTERS / SETTERS ----------------------------------------

    public HashMap<Rol, ArrayList<Usuario>> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario, Rol rol){
        usuarios.get(rol).add(usuario);
    }

}
