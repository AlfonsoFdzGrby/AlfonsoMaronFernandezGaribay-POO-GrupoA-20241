package src.sistema;
import java.util.*;
import src.usuarios.*;

public class Biblioteca {
    //@Deprecated //indica un fragmento de código desactualizado
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    /*private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Trabajador> trabajadores = new ArrayList<>();
    private ArrayList<Gerente> gerentes = new ArrayList<>();*/

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    //No te escuché xd, que me dices que revise??
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
