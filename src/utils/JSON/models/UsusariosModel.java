package utils.JSON.models;

import java.util.ArrayList;

import usuarios.Usuario;

public class UsusariosModel {
    private ArrayList<Usuario> clientes;
    private ArrayList<Usuario> trabajadores;
    private ArrayList<Usuario> gerentes;

    public ArrayList<Usuario> getClientes() {
        return clientes;
    }
    public ArrayList<Usuario> getTrabajadores() {
        return trabajadores;
    }
    public ArrayList<Usuario> getGerentes() {
        return gerentes;
    }
}
