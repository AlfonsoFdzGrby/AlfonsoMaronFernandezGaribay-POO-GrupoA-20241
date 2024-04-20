package usuarios;

import java.time.LocalDate;
import usuarios.utils.Rol;

public class Usuario {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String contraseña;
    private String nombreUsuario;
    private LocalDate fechaDeRegistro;
    private String numeroTelefono;

    public Usuario(String nombre, String apellido, Rol rol, String numeroTelefono, String contraseña, String nombreUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        nextID++;
        this.numeroTelefono = numeroTelefono;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
        this.fechaDeRegistro = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("ID: %d\nNombre completo: %s %s\nRol: %s\nFecha de registro: %s\n", id, nombre, apellido, rol, fechaDeRegistro.toString());
    }

    public String getContraseña(){
        return contraseña;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

}
