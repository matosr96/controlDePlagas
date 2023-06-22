package servicio;

import modelo.ActividadModelo;
import entidades.Actividad;
import java.util.List;

public class ActividadServicio {

    private ActividadModelo actividadModelo;

    public ActividadServicio() {
        actividadModelo = new ActividadModelo();
    }

    public void guardarActividad(Actividad actividad) {
        actividadModelo.guardarActividad(actividad);
    }

    public void actualizarActividad(Actividad actividad) {
        actividadModelo.actualizarActividad(actividad);
    }

    public void eliminarActividad(int id) {
        actividadModelo.eliminarActividad(id);
    }

    public Actividad buscarActividadPorId(int id) {
        return actividadModelo.buscarActividadPorId(id);
    }

    public List<Actividad> obtenerTodasLasActividades() {
        return actividadModelo.obtenerTodasLasActividades();
    }
}
