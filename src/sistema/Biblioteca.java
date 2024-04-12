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
}
