package usuarios;

import java.time.LocalDate;
import java.util.*;

import sistema.Biblioteca;
import usuarios.utils.Rol;

public abstract class Usuario {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String contraseña;
    private String nombreUsuario;
    private LocalDate fechaDeRegistro;
    private LocalDate fechadeNacimiento;
    private String numeroTelefono;
    private static Scanner sc = new Scanner(System.in);

    public Usuario(String nombre, String apellido, Rol rol, String numeroTelefono, String contraseña, String nombreUsuario, LocalDate fechadeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        nextID++;
        this.numeroTelefono = numeroTelefono;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
        this.fechaDeRegistro = LocalDate.now();
        this.fechadeNacimiento = fechadeNacimiento;
    }

    public static Usuario buscarUsuario(){
        Usuario usuario = null;
        while(true){
            System.out.println("Ingrese su nombre de usuario");
            System.out.print(">> ");
            String nombreUsuario = sc.nextLine();

            for (ArrayList<Usuario> usuarios : Biblioteca.usuarios.values()) {
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

    @Override
    public String toString(){
        return String.format("ID: %d\nNombre completo: %s %s\nRol: %s\nFecha de registro: %s\n", id, nombre, apellido, rol, fechaDeRegistro.toString());
    }

    public String getContraseña(){
        return contraseña;
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public Rol getRol() {
        return rol;
    }

    public int getId() {
        return id;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
