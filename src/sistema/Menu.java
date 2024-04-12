package src.sistema;
import java.util.Scanner;
import src.usuarios.utils.*;
import src.usuarios.*;

public class Menu {
    private static Biblioteca bibiloteca = new Biblioteca();

    private static Scanner sc = new Scanner(System.in);

    private static void printHeader(String header){
        System.out.println("======================================================");
        System.out.println(header);
        System.out.println("======================================================");
    }

    private static void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    private static void crearCuenta(){
        printHeader("CREAR CUENTA");
        System.out.println("Ingrese su nombre");
        System.out.print(">> ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido");
        System.out.print(">> ");
        String apellido = sc.nextLine();
        System.out.println("Seleccione su rol:");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();

        Rol rol;

        switch (opc) {
            case 2 -> rol = Rol.TRABAJADOR;
            case 3 -> rol = Rol.GERENTE;
            default -> rol = Rol.CLIENTE;
        }

        System.out.println("Ingrese su nuevo nombre de usuario");
        System.out.print(">> ");
        String nombreUsuario = sc.nextLine();

        System.out.println("Ingrese su nueva contraseña");
        System.out.print(">> ");
        String contraseña = sc.nextLine();

        switch (rol) {
            case Rol.CLIENTE -> bibiloteca.agregarUsuario(new Cliente(nombre, apellido, contraseña, nombreUsuario));
            case Rol.TRABAJADOR -> bibiloteca.agregarUsuario(new Trabajador(nombre, apellido, opc, opc, contraseña, nombreUsuario));
            case Rol.GERENTE -> bibiloteca.agregarUsuario(new Gerente(nombre, apellido, apellido, opc, opc, contraseña, nombreUsuario));
        }

        System.out.println("¡La cuenta ha sido registrado correctamente!");
        continuar();
    }

    private static void iniciarSesion(){
        printHeader("INICIAR SESION");
        Usuario usuario = null;
        int intentos = 3;

        if(bibiloteca.getUsuarios().isEmpty()){
            System.out.println("No hay usuarios registrados aún");
            System.out.println("Por favor registre al menos un usuario antes de iniciar sesión...");
            continuar();
        }else{
            while(true){
                System.out.println("Ingrese su nombre de usuario");
                System.out.print(">> ");
                String nombreUsuario = sc.nextLine();
    
                for (int i = 0; i < bibiloteca.getUsuarios().size(); i++) {
                    if(nombreUsuario.equals(bibiloteca.getUsuarios().get(i).getNombreUsuario())){
                        usuario = bibiloteca.getUsuarios().get(i);
                        break;
                    }
                }
    
                if(usuario!=null){
                    System.out.println("¡Usuario encontrado!");
                    break;
                }else{
                    System.out.println("Usuario no encontrado");
                }
            }
            
            while(true){
                System.out.println("Ingrese la contraseña");
                System.out.println("Tiene " + intentos + " intentos restantes");
                System.out.print(">> ");
                String contraseña = sc.nextLine();
                if(contraseña.equals(usuario.getContraseña())){
                    System.out.println("¡La contraseña es correcta!");
                    continuar();
                    menuUsuarios(usuario);
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

    private static void menuUsuarios(Usuario usuario){

        Cliente cliente = null;
        Trabajador trabajador = null;
        Gerente gerente = null;

        if(usuario instanceof Cliente){
            cliente = (Cliente)usuario;
            menuCliente(cliente);
        }else if(usuario instanceof Trabajador){
            trabajador = (Trabajador)usuario;
            menuTrabajador(trabajador);
        }else{
            gerente = (Gerente)usuario;
            menuGerente(gerente);
        }

    }

    private static void menuCliente(Cliente cliente){
        //Meter menú a un while(true)
        printHeader("CLIENTE");
        System.out.println("Seleccione una opción");
        System.out.println("1. Ver rentas");
        System.out.println("2. Ver info");
        System.out.println("3. Ver libros disponibles");
        System.out.println("4. Cerrar Sesión"); // Regresar al menú principal
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();
        //TODO: Menú cliente
        switch (opc) {
            case 1: 
                //clienteVerRentas();
                break;
            
            case 2:
                //clienteVerInfo();
                break;
            
            case 3:
                //clienteVerLibrosDisponibles();
                break;
            
            default:
                break;
        }
    }

    private static void menuTrabajador(Trabajador trabajador){
        printHeader("TRABAJADOR");
        System.out.println("Seleccione una opción");
        System.out.println("1. Crear");
        System.out.println("2. Mostrar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("5. Cerrar Sesión");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();
        //TODO: Menú Trabajador

        switch (opc) {
            case 1:
                //trabajadorCrear();
                break;
        
            case 2:
                //trabajadorMostrar();
                break;
        
            case 3:
                //trabajadorActualizar();
                break;
        
            case 4:
                //trabajadorEliminar();
                break;
        
            default:
                break;
        }
    }

    private static void menuGerente(Gerente gerente){
        printHeader("GERENTE");
        System.out.println("Seleccione una opción"); //+ Puede modificar empleados también
        System.out.println("1. Crear");
        System.out.println("2. Mostrar"); //+ mostrar registro de rentas
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("5. Cerrar Sesión");
        System.out.print(">> ");
        //TODO: Menú Gerente
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                //gerenteCrear();
                break;
        
            case 2:
                //gerenteMostrar();
                break;
        
            case 3:
                //gerenteActualizar();
                break;
        
            case 4:
                //gerenteEliminar();
                break;
        
            default:
                break;
        }
    }

    // MÉTODO PÚBLICO

    public static void ejecutarMenu(){
        int opc = 1;
        while(opc>0 && opc<3){

            printHeader("BIBLIOTECA");
            System.out.println("Elija una opción:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir del programa");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    crearCuenta();
                    break;
            
                case 2:
                    iniciarSesion();
                    break;
            
                default:
                    break;
            }
        }
    }
}
