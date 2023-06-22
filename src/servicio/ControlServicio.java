package servicio;

import modelo.ControlModelo;
import entidades.Control;
import java.util.List;

public class ControlServicio {

    private ControlModelo controlModelo;

    public ControlServicio() {
        controlModelo = new ControlModelo();
    }

    public void guardarControl(Control control) {
        controlModelo.guardarControl(control);
    }

    public void actualizarControl(Control control) {
        controlModelo.actualizarControl(control);
    }

    public void eliminarControl(int id) {
        controlModelo.eliminarControl(id);
    }

    public Control buscarControlPorId(int id) {
        return controlModelo.buscarControlPorId(id);
    }

    public List<Control> obtenerTodosLosControles() {
        return controlModelo.obtenerTodosLosControles();
    }
}
