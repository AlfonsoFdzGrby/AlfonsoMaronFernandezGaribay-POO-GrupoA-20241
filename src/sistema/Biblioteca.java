package src.sistema;
import java.util.*;
import src.usuarios.*;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void mostrarListaUsuarios(){
        System.out.println("CLIENTES:");
        for (Usuario usuarioAMostrar : usuarios) {
            if (usuarioAMostrar instanceof Cliente) 
                System.out.println("   * " + usuarioAMostrar.getNombreUsuario());
        }

        System.out.println("TRABAJADORES:");
        for (Usuario usuarioAMostrar : usuarios) {
            if (usuarioAMostrar instanceof Trabajador) 
                System.out.println("   * " + usuarioAMostrar.getNombreUsuario());
        }

        System.out.println("GERENTES:");
        for (Usuario usuarioAMostrar : usuarios) {
            if (usuarioAMostrar instanceof Gerente) 
                System.out.println("   * " + usuarioAMostrar.getNombreUsuario());
        }
    }
}
