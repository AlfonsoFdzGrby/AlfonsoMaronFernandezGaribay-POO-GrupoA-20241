package sistema;

import java.util.Scanner;

import libros.Libro;
import usuarios.*;
import sistema.utils.*;
import utils.*;

public class Menu {
    private static Biblioteca biblioteca = new Biblioteca(true);
    private static UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    private static Scanner sc = new Scanner(System.in);

    //---------------------------------------- MENÚ PRINCIPAL ----------------------------------------

    public static void ejecutarMenu(){
        int opc = 1;
        while(opc>0 && opc<3){
            Designer.printHeader("BIBLIOTECA");
            System.out.println("Elija una opción:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir del programa");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> biblioteca.crearCuenta();
                case 2 -> biblioteca.iniciarSesion();
            }
        }
    }

    public static void menuUsuarios(){
        if(usuarioEnSesion.getUsuarioActual() instanceof Cliente){
            menuCliente();
        }else if(usuarioEnSesion.getUsuarioActual() instanceof Trabajador){
            menuTrabajador();
        }else{
            menuGerente();
        }
    }

    //---------------------------------------- MENÚS DE USUARIOS ----------------------------------------

    private static void menuCliente(){
        while(usuarioEnSesion.getUsuarioActual()!=null){
            Designer.printHeader("CLIENTE");
            System.out.println("1. Ver rentas");
            System.out.println("2. Ver info");
            System.out.println("3. Editar información");
            System.out.println("4. Ver libros disponibles");
            System.out.println("5. Cerrar Sesión"); // Regresar al menú principal
            System.out.print(">> ");
            int opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 2 -> usuarioEnSesion.getUsuarioActual().toString();
                case 3 -> Cliente.modificarCliente((Cliente)usuarioEnSesion.getUsuarioActual());
                default -> usuarioEnSesion.cerrarSesion();
            }
        }
    }

    private static void menuTrabajador(){
        while(usuarioEnSesion.getUsuarioActual()!=null){
            Designer.printHeader("TRABAJADOR");
            System.out.println("Seleccione una opción");
            System.out.println("1. Registrar"); //Libro, o usuario
            System.out.println("2. Consultar"); //Libro, cliente y propia
            System.out.println("3. Modificar"); //Información propia y de usuarios
            System.out.println("4. Eliminar"); //Clientes y libros
            System.out.println("5. Cerrar Sesión");
            System.out.print(">> ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> registrar(false);
                case 2 -> consultar(false);
                default -> usuarioEnSesion.cerrarSesion();
            }
        }
    }

    private static void menuGerente(){
        while(usuarioEnSesion.getUsuarioActual()!=null){
            Designer.printHeader("GERENTE");
            System.out.println("Seleccione una opción"); //+ Puede modificar empleados también
            System.out.println("1. Registrar");
            System.out.println("2. Consultar"); //+ mostrar registro de rentas
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Cerrar Sesión");
            System.out.print(">> ");
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> registrar(true);
                case 2 -> consultar(true);
                default -> usuarioEnSesion.cerrarSesion();
            }
        }
    }

    private static void registrar(boolean admin){
        int opc;
        if(!admin){
            Designer.printHeader("TRABAJADOR - Registrar");
            System.out.println("Seleccione un elemento a registrar");
            System.out.println("1. Libro");
            System.out.println("2. Cliente");
            System.out.println("3. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1 -> Libro.registrarLibro();
                case 2 -> Cliente.registrarCliente();
            }
        }else{
            Designer.printHeader("GERENTE - Registrar");
            System.out.println("Seleccione un elemento a registrar");
            System.out.println("1. Libro");
            System.out.println("2. Cliente");
            System.out.println("3. Trabajador");
            System.out.println("4. Gerente");
            System.out.println("5. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1 -> Libro.registrarLibro();
                case 2 -> Cliente.registrarCliente();
                case 3 -> Trabajador.registrarTrabajador();
                case 4 -> Gerente.registrarGerente();
            }
        }
    }

    private static void consultar(boolean admin){
        int opc;
        if(!admin){
            Designer.printHeader("TRABAJADOR - Consultar");
            System.out.println("Seleccione un elemento a consultar");
            System.out.println("1. Libros");
            System.out.println("2. Clientes");
            System.out.println("3. Información propia");
            System.out.println("4. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1 -> Biblioteca.listarLibros();
                case 2 -> Cliente.mostrarClientes();
                case 3 -> usuarioEnSesion.getUsuarioActual().toString();
            }
        }else{
            Designer.printHeader("GERENTE - Consultar");
            System.out.println("Seleccione un elemento a consultar");
            System.out.println("1. Libros");
            System.out.println("2. Clientes");
            System.out.println("3. Trabajadores");
            System.out.println("4. Gerentes");
            System.out.println("5. Información propia");
            System.out.println("6. Volver al menú anterior");
            System.out.print(">> ");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1 -> Biblioteca.listarLibros();
                case 2 -> Cliente.mostrarClientes();
                case 3 -> Trabajador.mostrarTrabajadores();
                case 4 -> Gerente.mostrarGerentes();
                case 5 -> usuarioEnSesion.getUsuarioActual().toString();
            }
        }
    }

    //---------------------------------------- REGISTRAR ----------------------------------------
    

}
