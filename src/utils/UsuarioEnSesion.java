//CLASE SINGLETON

package src.utils;

import src.usuarios.Usuario;

public final class UsuarioEnSesion {
    private static UsuarioEnSesion instancia;
    private Usuario usuarioActual;

    private UsuarioEnSesion(){}

    public static UsuarioEnSesion getInstancia(){
        if(instancia==null){
            instancia = new UsuarioEnSesion();
        }
        return instancia;
    }

    public Usuario getUsuarioActual(){
        return usuarioActual;
    }

    public void setUsuario(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }

    public boolean usuarioEnSesion(){
        return usuarioActual != null;
    }

    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }

}