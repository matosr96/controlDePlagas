package servicio;

import modelo.ResumenControlModelo;
import entidades.ResumenControl;
import java.util.List;

public class ResumenControlServicio {

    private ResumenControlModelo resumenControlModelo;

    public ResumenControlServicio() {
        resumenControlModelo = new ResumenControlModelo();
    }

    public void guardarResumenControl(ResumenControl resumenControl) {
        resumenControlModelo.guardarResumenControl(resumenControl);
    }

    public void actualizarResumenControl(ResumenControl resumenControl) {
        resumenControlModelo.actualizarResumenControl(resumenControl);
    }

    public void eliminarResumenControl(int id) {
        resumenControlModelo.eliminarResumenControl(id);
    }

    public ResumenControl buscarResumenControlPorId(int id) {
        return resumenControlModelo.buscarResumenControlPorId(id);
    }

    public List<ResumenControl> obtenerTodosLosResumenControl() {
        return resumenControlModelo.obtenerTodosLosResumenesControl();
    }
}
