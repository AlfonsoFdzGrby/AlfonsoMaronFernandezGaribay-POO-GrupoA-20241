package utils.JSON.models;

import java.util.ArrayList;

import usuarios.Usuario;

public class UsusariosModel {
    private ArrayList<Usuario> CLIENTE;
    private ArrayList<Usuario> TRABAJADOR;
    private ArrayList<Usuario> GERENTE;
    
    public ArrayList<Usuario> getCLIENTE() {
        return CLIENTE;
    }
    public ArrayList<Usuario> getTRABAJADOR() {
        return TRABAJADOR;
    }
    public ArrayList<Usuario> getGERENTE() {
        return GERENTE;
    }

    
}
