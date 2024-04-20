package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;
import usuarios.Usuario;
import usuarios.utils.Rol;
import utils.*;

public class Menu {
    private static Biblioteca biblioteca = new Biblioteca();
    private static UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    private static Scanner sc = new Scanner(System.in);

    //---------------------------------------- MENÚ PRINCIPAL ----------------------------------------

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
                    biblioteca.crearCuenta();
                    break;
            
                case 2:
                    biblioteca.iniciarSesion();
                    break;
            
                default:
                    break;
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
            printHeader("CLIENTE");
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
                    
                    break;
            
                case 2:
                    
                    break;
            
                case 3:
                    
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

            switch (opc) {
                case 1:
                    
                    break;
            
                case 2:
                    
                    break;
            
                case 3:
                    
                    break;
            
                case 4:
                    
                    break;
            
                default:
                    usuarioEnSesion.cerrarSesion();
                    break;
            }
        }
    }

    private static void menuGerente(){
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
            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    
                    break;
            
                case 2:
                    
                    break;
            
                case 3:
                    
                    break;
            
                case 4:
                    
                    break;
            
                case 5:
                    
                    break;
            
                default:
                    usuarioEnSesion.cerrarSesion();
                    break;
            }
        }
    }

    //---------------------------------------- DISEÑO E INTERFAZ ----------------------------------------

    public static void printHeader(String header){
        System.out.println("=====================================================");
        System.out.println(header);
        System.out.println("=====================================================");
    }

    private static void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

}
