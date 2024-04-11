package src.sistema;
import java.util.Scanner;
import src.usuarios.utils.*;
import src.usuarios.Usuario;

//CRUD: Create, Read, Update, Delete

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

        bibiloteca.agregarUsuario(new Usuario(nombre, apellido, rol, contraseña, nombreUsuario));
        System.out.println("¡La cuenta ha sido registrado correctamente!");
        continuar();
    }

    private static void iniciarSesion(){
        printHeader("INICIAR SESION");
        Usuario usuario = null;

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
            System.out.print(">> ");
            String contraseña = sc.nextLine();
            if(contraseña.equals(usuario.getContraseña())){
                System.out.println("¡La contraseña es correcta!");
                continuar();
                menuUsuarios(usuario);
                break;
            }else{
                System.out.println("La contraseña no es correcta");
            }
        }
    }

    private static void menuUsuarios(Usuario usuario){
        switch (usuario.getRol()) {
            case CLIENTE -> menuCliente();
            case TRABAJADOR -> menuTrabajador();
            default -> menuGerente();
        }
    }

    private static void menuCliente(){
        printHeader("CLIENTE");
        System.out.println("Seleccione una opción");
        System.out.println("1. Ver rentas");
        System.out.println("2. Ver info");
        System.out.println("3. Ver libros disponibles");
        System.out.print(">> ");
        //TODO: Menú cliente
    }

    private static void menuTrabajador(){
        printHeader("TRABAJADOR");
        System.out.println("Seleccione una opción");
        System.out.println("1. Crear");
        System.out.println("2. Mostrar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print(">> ");
        //TODO: Menú Trabajador
    }

    private static void menuGerente(){
        printHeader("GERENTE");
        System.out.println("Seleccione una opción");
        System.out.println("1. Crear");
        System.out.println("2. Mostrar"); //+ mostrar registro de rentas
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.print(">> ");
        //TODO: Menú Gerente
    }

    // MÉTODO PÚBLICO

    public void ejecutarMenu(){
        int opc = 1;
        while((opc>0 && opc<3)){
            printHeader("BIBLIOTECA");
            System.out.println("Elija una opción:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir del programa");
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
