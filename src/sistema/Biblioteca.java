package src.sistema;
import java.util.*;
import src.usuarios.*;

public class Biblioteca {
    //@Deprecated //indica un fragmento de código desactualizado
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
