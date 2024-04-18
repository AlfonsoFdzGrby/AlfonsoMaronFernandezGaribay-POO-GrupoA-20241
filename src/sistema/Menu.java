package src.sistema;
import java.util.Scanner;
import src.usuarios.utils.*;
import src.usuarios.*;
import src.utils.UsuarioEnSesion;

/* Tarea 15-04-24: Registro de cliente, trabajador y gerente, su consulta (mostrar todos) 
 * MUST - Consulta individual
 * NICE TO HAVE - Tratar de implementar el inicio de sesión con el SINGLETON (en el menú o en la biblioteca)
*/

public class Menu {
    private static Biblioteca bibiloteca = new Biblioteca();
    private static UsuarioEnSesion usuarioEnSesion = null;
    private static Scanner sc = new Scanner(System.in);

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

    // MENÚES: GENERAL

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

        String numTelefono = null;

        while(true){
            boolean repetido = false;
            System.out.println("Ingrese su número de teléfono:");
            System.out.print(">> ");
            numTelefono = sc.nextLine();

            for (Usuario user : bibiloteca.getUsuarios()) {
                if(user.getNumeroTelefono().equalsIgnoreCase(numTelefono)){
                    System.out.println("El teléfono registrado ya existe");
                    repetido = true;
                    break;
                }
            }

            if(repetido==false){
                break;
            }
        }

        switch (rol) {
            case Rol.CLIENTE -> bibiloteca.agregarUsuario(new Cliente(nombre, apellido, numTelefono, contraseña, nombreUsuario));
            case Rol.TRABAJADOR -> bibiloteca.agregarUsuario(new Trabajador(nombre, apellido, numTelefono, opc, opc, contraseña, nombreUsuario));
            case Rol.GERENTE -> bibiloteca.agregarUsuario(new Gerente(nombre, apellido, numTelefono, numTelefono, opc, opc, contraseña, nombreUsuario));
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
            usuario = buscarUsuario(false);
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
                    menuUsuarios();
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

    private static void menuUsuarios(){
        if(usuarioEnSesion.getUsuarioActual() instanceof Cliente){
            menuCliente();
        }else if(usuarioEnSesion.getUsuarioActual() instanceof Trabajador){
            menuTrabajador();
        }else{
            menuGerente();
        }
        
    }

    private static void menuCliente(){
        Cliente cliente = (Cliente)usuarioEnSesion.getUsuarioActual();

        while(usuarioEnSesion.getUsuarioActual()!=null){
            printHeader("CLIENTE");
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver rentas");
            System.out.println("2. Ver info");
            System.out.println("3. Editar información");
            System.out.println("4. Ver libros disponibles");
            System.out.println("5. Cerrar Sesión"); // Regresar al menú principal
            System.out.print(">> ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1: 
                    //clienteVerRentas();
                    break;
                
                case 2:
                    printHeader("CLIENTE - VER INFO");
                    System.out.println(cliente.toString());
                    continuar();
                    break;
                
                case 3:
                    //clienteVerLibrosDisponibles();
                    break;
                
                case 4:

                    break;

                default:
                    usuarioEnSesion.cerrarSesion();
                    break;
            }
        }
    }

    private static void menuTrabajador(){
        Trabajador trabajador = (Trabajador)usuarioEnSesion.getUsuarioActual();

        while(usuarioEnSesion.getUsuarioActual()!=null){
            printHeader("TRABAJADOR");
            System.out.println("Seleccione una opción");
            System.out.println("1. Crear"); //Libro, o usuario
            System.out.println("2. Mostrar"); //Libro, cliente y propia
            System.out.println("3. Actualizar"); //Información propia y de usuarios
            System.out.println("4. Eliminar"); //Clientes y libros
            System.out.println("5. Cerrar Sesión");
            System.out.print(">> ");
            int opc = sc.nextInt();
            sc.nextLine();
            //TODO: Menú Trabajador
    
            switch (opc) {
                case 1:
                    printHeader("TRABAJADOR - CREAR");
                    System.out.println("Seleccione una opción");
                    System.out.println("1. Registrar un nuevo libro");
                    System.out.println("2. Registrar un nuevo usuario");
                    System.out.println("3. Volver al menú anterior");
                    int subOpc = sc.nextInt();
                    sc.nextLine();
                    switch (subOpc) {
                        case 1:
                            //registrarLibro();
                            break;
                    
                        case 2:
                            crearCuenta();
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                case 2:
                    trabajadorMostrar();
                    break;
            
                case 3:
                    //trabajadorActualizar();
                    break;
            
                case 4:
                    //trabajadorEliminar();
                    break;
            
                default:
                    usuarioEnSesion.cerrarSesion();
                    break;
            }
        }
    }

    private static void menuGerente(){

        Gerente gerente = (Gerente)usuarioEnSesion.getUsuarioActual();

        while(usuarioEnSesion.getUsuarioActual()!=null){
            printHeader("GERENTE");
            System.out.println("Seleccione una opción"); //+ Puede modificar empleados también
            System.out.println("1. Crear");
            System.out.println("2. Mostrar"); //+ mostrar registro de rentas
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Mostrar a todos los usuarios");
            System.out.println("6. Cerrar Sesión");
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
                
                case 5:
                    bibiloteca.mostrarListaUsuarios();
                    break;    

                default:
                    usuarioEnSesion.cerrarSesion();
                    break;
            }
        }
    }

    // MENÚES INDEPENDIENTES: TRABAJADOR

    private static void trabajadorMostrar(){
        Trabajador trabajador = (Trabajador)usuarioEnSesion.getUsuarioActual();
        int opc = 1;
        while(opc<4 && opc>0){
            printHeader("TRABAJADOR - MOSTRAR");
            System.out.println("Seleccione una opción");
            System.out.println("1. Libros de la biblioteca");
            System.out.println("2. Clientes registrados");
            System.out.println("3. Información propia");
            System.out.println("4. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    //mostrarLibros();
                    break;
            
                case 2:
                    //mostrarClientes();
                    break;
            
                case 3:
                    printHeader("TRABAJADOR - MOSTRAR INFO PROPIA");
                    System.out.println(trabajador.toString());
                    continuar();
                    break;
            
                default:
                    break;
            }
        }
    }

    private static void trabajadorActualizar(){
        int opc = 1;
        while(opc<4 && opc>0){    
            printHeader("TRABAJADOR - ACTUALIZAR");
            System.out.println("Seleccione una opción");
            System.out.println("1. Actualizar cliente");
            System.out.println("2. Actualizar información propia");
            System.out.println("3. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Usuario usuario;
                    Cliente cliente;
                    while(true){
                        usuario = buscarUsuario(true);
                        if(usuario instanceof Cliente){
                            cliente = (Cliente)usuario;
                            break;
                        }else{
                            System.out.println("El usuario especificado no es un cliente");
                        }
                    }
                    System.out.println("Ingrese el atributo que quiera actualizar");
                    System.out.println("1. Nombre y apellido");
                    System.out.println("2. Nombre de usuario");
                    System.out.println("3. Contraseña");
                    System.out.print(">> ");
                    System.out.println("NOMBRE");
                    System.out.println("Nombre actual: " + cliente.getNombreUsuario());
                    System.out.print("Ingrese el nuevo nombre (ingrese 'exit' para no cambiar): ");
                    System.out.println("APELLIDO");
                    System.out.println("Apellido actual: " + cliente.getApellido());
                    System.out.print("Ingrese el nuevo apellido (ingrese 'exit' para no cambiar): ");
                    System.out.println("");
                    
                    break;
            
                case 2:
                    
                    break;
            
                default:
                    break;
            }
        }
    }

    // DISEÑO E INTERFAZ:

    private static void printHeader(String header){
        System.out.println("======================================================");
        System.out.println(header);
        System.out.println("======================================================");
    }

    private static void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    // FUNCIONALIDAD:

    private static Usuario buscarUsuario(boolean modificar){
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
        return usuario;
    }

}
