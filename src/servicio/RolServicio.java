package servicio;

import modelo.RolModelo;
import entidades.Rol;
import java.util.List;

public class RolServicio {

    private RolModelo rolModelo;

    public RolServicio() {
        rolModelo = new RolModelo();
    }

    public void guardarRol(Rol rol) {
        rolModelo.guardarRol(rol);
    }

    public void actualizarRol(Rol rol) {
        rolModelo.actualizarRol(rol);
    }

    public void eliminarRol(int id) {
        rolModelo.eliminarRol(id);
    }

    public Rol buscarRolPorId(int id) {
        return rolModelo.buscarRolPorId(id);
    }

    public List<Rol> obtenerTodosLosRoles() {
        return rolModelo.obtenerTodosLosRoles();
    }
}
