package servicio;

import modelo.UsuarioModelo;
import entidades.Usuario;
import java.util.List;

public class UsuarioServicio {

    private UsuarioModelo usuarioModelo;

    public UsuarioServicio() {
        usuarioModelo = new UsuarioModelo();
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioModelo.guardarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioModelo.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioModelo.eliminarUsuario(id);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioModelo.buscarUsuarioPorId(id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioModelo.obtenerTodosLosUsuarios();
    }
}
