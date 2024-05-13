package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import libros.Genero;
import libros.Libro;
import libros.Subgenero;
import usuarios.*;
import sistema.utils.*;
import usuarios.utils.*;
import utils.Tools;
import utils.UsuarioEnSesion;

public class Biblioteca {

    private Scanner sc = new Scanner(System.in);
    private UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<Genero, ArrayList<Libro>>();

    public Biblioteca(){
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        agregarUsuario(new Cliente("Cliente", "1", "443566", "12345", "cliente1", LocalDate.of(05, 4, 1980)), Rol.CLIENTE);
        agregarUsuario(new Cliente("Cliente", "2", "443562", "12345", "cliente2", LocalDate.of(05, 4, 1980)), Rol.CLIENTE);
        agregarUsuario(new Trabajador("Trabajador", "1", "5316456", 1234529, 15000, "12345", "trabajador1", LocalDate.of(05, 4, 1980)), Rol.TRABAJADOR);
        agregarUsuario(new Trabajador("Trabajador", "2", "5316488", 1254529, 15000, "12345", "trabajador2", LocalDate.of(23, 10, 2000)), Rol.TRABAJADOR);
        agregarUsuario(new Gerente("Gerente", "1", "8798465", "El mero mero", 50000, 828288, "12345", "gerente1", LocalDate.of(05, 4, 1980)), Rol.GERENTE);
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

    public void agregarLibro(Libro libro, Genero genero){
        libros.get(genero).add(libro);
    }

    public static void listarLibros(){
        System.out.println("");
        Tools.printHeader("LIBROS");

        System.out.println("ACCIÓN");
        System.out.println("   * ID\t| Libro");
        for (Libro libro : libros.get(Genero.Acción)) {
            System.out.println("   * " + libro.getId() + "\t " + libro.getInfoBasica());
        }

        System.out.println("COMEDIA");
        System.out.println("   * ID\t| Libro");
        for (Libro libro : libros.get(Genero.Comedia)) {
            System.out.println("   * " + libro.getId() + "\t " + libro.getInfoBasica());
        }

        System.out.println("TERROR");
        System.out.println("   * ID\t| Libro");
        for (Libro libro : libros.get(Genero.Terror)) {
            System.out.println("   * " + libro.getId() + "\t " + libro.getInfoBasica());
        }
    }

    public static void filtarLibrosPorStock(Genero genero, int stock){
        List<Libro> librosStock = libros.get(genero)
        .stream()
        .filter(libro -> libro.getStock()>stock)
        .collect(Collectors.toList());
    }

    public static void filtrarLibrosPorSubGenero(Genero genero, Subgenero subgenero){
        List<Libro> librosSubgen = libros.get(genero)
        .stream()
        .filter(libro -> libro.getSubgenero().equals(subgenero))
        .collect(Collectors.toList());
    }

    public static void filtarLibrosPorPrimeraLetra(Genero genero, char letra){
        List<Libro> librosLetra = libros.get(genero)
        .stream()
        .filter(libro -> libro.getTitulo().charAt(0)==letra)
        .collect(Collectors.toList());
    }

}
