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
    private static Biblioteca bibiloteca = new Biblioteca();
    private static UsuarioEnSesion usuarioEnSesion = null;
    private static Scanner sc = new Scanner(System.in);

    public static void printHeader(String header){
        System.out.println("=====================================================");
        System.out.println(header);
        System.out.println("=====================================================");
    }

    private static void continuar(){
        System.out.print("Presione enter para continuar...");
        sc.nextLine();
    }

    public static void ejecutarMenuu(){
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

    // MENÚS: GENERAL

    private static void crearCuenta(){
        ArrayList<String> datosComun = new ArrayList<>();
        String nombre, apellido, numTelefono, nombreUsuario, contraseña;
        printHeader("CREAR CUENTA");
        System.out.println("Seleccione el tipo de cuenta a crear");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.println("4. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();

        if(opc==1){
            datosComun = bibiloteca.obtenerDatosComun(Rol.CLIENTE);
            nombre = datosComun.get(0);
            apellido = datosComun.get(1);
            numTelefono = datosComun.get(3);
            nombreUsuario = datosComun.get(4);
            contraseña = datosComun.get(5);
            bibiloteca.agregarUsuario(new Cliente(nombre, apellido, numTelefono, contraseña, nombreUsuario), Rol.CLIENTE);
            System.out.println("¡El cliente ha sido registrado exitosamente!");
            continuar();
        }else if(opc==2){
            datosComun = bibiloteca.obtenerDatosComun(Rol.TRABAJADOR);
            nombre = datosComun.get(0);
            apellido = datosComun.get(1);
            numTelefono = datosComun.get(3);
            nombreUsuario = datosComun.get(4);
            contraseña = datosComun.get(5);
            System.out.print(">> ");
            long rfc = sc.nextLong();
            sc.nextLine();
            System.out.println("Ingrese su salario mensual");
            System.out.print(">> ");
            double salary = sc.nextDouble();
            sc.nextLine();
            bibiloteca.agregarUsuario(new Trabajador(nombre, apellido, numTelefono, rfc, salary, contraseña, nombreUsuario), Rol.TRABAJADOR);
            System.out.println("¡El trabajador ha sido registrado exitosamente!");
            continuar();
        }else if(opc==3){
            datosComun = bibiloteca.obtenerDatosComun(Rol.GERENTE);
            nombre = datosComun.get(0);
            apellido = datosComun.get(1);
            numTelefono = datosComun.get(3);
            nombreUsuario = datosComun.get(4);
            contraseña = datosComun.get(5);
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
            bibiloteca.agregarUsuario(new Gerente(nombre, apellido, numTelefono, sector, salary, rfc, contraseña, nombreUsuario), Rol.GERENTE);
            System.out.println("¡El gerente ha sido registrado exitosamente!");
            continuar();
        }
    }

    private static void iniciarSesion(){
        printHeader("INICIAR SESIÓN");
        Usuario usuario = null;
        int intentos = 3;

        if(bibiloteca.getUsuarios().isEmpty()){
            System.out.println("No hay usuarios registrados aún");
            System.out.println("Por favor registre al meno sun usuario antes de iniciar sesión...");
            continuar();
        }else{
            usuario = bibiloteca.buscarUsuario();
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
                    //menuUsuarios();
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
}
