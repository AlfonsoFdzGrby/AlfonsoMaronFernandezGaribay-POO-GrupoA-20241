package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import usuarios.*;
import sistema.utils.*;
import usuarios.utils.*;
import utils.UsuarioEnSesion;

public class Biblioteca {

    private Scanner sc = new Scanner(System.in);
    private UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();

    public Biblioteca(){
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        agregarUsuario(new Cliente("Cliente", "1", "443566", "12345", "cliente1"), Rol.CLIENTE);
        agregarUsuario(new Cliente("Cliente", "2", "443562", "12345", "cliente2"), Rol.CLIENTE);
        agregarUsuario(new Trabajador("Trabajador", "1", "5316456", 1234529, 15000, "12345", "trabajador1"), Rol.TRABAJADOR);
        agregarUsuario(new Trabajador("Trabajador", "2", "5316488", 1254529, 15000, "12345", "trabajador2"), Rol.TRABAJADOR);
        agregarUsuario(new Gerente("Gerente", "1", "8798465", "El mero mero", 50000, 828288, "12345", "gerente1"), Rol.GERENTE);
    }

    //---------------------------------------- MÉTODOS PÚBLICOS ----------------------------------------

    public void crearCuenta(){
        Designer.printHeader("CREAR CUENTA");
        System.out.println("Seleccione el tipo de cuenta a crear");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.println("4. Volver al menú anterior");
        System.out.print(">> ");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1 -> Cliente.registrarCliente();
            case 2 -> Trabajador.registrarTrabajador();
            case 3 -> Gerente.registrarGerente();
        }
    }
    
    public void iniciarSesion(){
        Designer.printHeader("INICIAR SESIÓN");
        Usuario usuario = null;
        int intentos = 3;

        if(usuarios.get(Rol.CLIENTE).isEmpty() && usuarios.get(Rol.GERENTE).isEmpty() && usuarios.get(Rol.TRABAJADOR).isEmpty()){
            System.out.println("No hay usuarios registrados aún");
            System.out.println("Por favor registre al menos un usuario antes de iniciar sesión...");
            Designer.continuar();
        }else{
            usuario = Usuario.buscarUsuario();
            while(true){
                System.out.println("Ingrese la contraseña");
                System.out.println("Tiene " + intentos + " intentos restantes");
                System.out.print(">> ");
                String contraseña = sc.nextLine();
                if(contraseña.equals(usuario.getContraseña())){
                    System.out.println("¡La contraseña es correcta!");
                    Designer.continuar();
                    usuarioEnSesion = UsuarioEnSesion.getInstancia();
                    usuarioEnSesion.setUsuario(usuario);
                    Menu.menuUsuarios();
                    break;
                }else{
                    System.out.println("La contraseña no es correcta");
                    intentos--;
                    if(intentos==0){
                        System.out.println("Sus intentos se han agotado.");
                        Designer.continuar();
                        break;
                    }
                }
            }
        }
    }

    //---------------------------------------- GETTERS / SETTERS ----------------------------------------

    public HashMap<Rol, ArrayList<Usuario>> getUsuarios() {
        return usuarios;
    }

    public void agregarUsuario(Usuario usuario, Rol rol){
        usuarios.get(rol).add(usuario);
    }

}
