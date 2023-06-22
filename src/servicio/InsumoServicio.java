package servicio;

import modelo.InsumoModelo;
import entidades.Insumo;
import java.util.List;

public class InsumoServicio {

    private InsumoModelo insumoModelo;

    public InsumoServicio() {
        insumoModelo = new InsumoModelo();
    }

    public void guardarInsumo(Insumo insumo) {
        insumoModelo.guardarInsumo(insumo);
    }

    public void actualizarInsumo(Insumo insumo) {
        insumoModelo.actualizarInsumo(insumo);
    }

    public void eliminarInsumo(int id) {
        insumoModelo.eliminarInsumo(id);
    }

    public Insumo buscarInsumoPorId(int id) {
        return insumoModelo.buscarInsumoPorId(id);
    }

    public List<Insumo> obtenerTodosLosInsumos() {
        return insumoModelo.obtenerTodosLosInsumos();
    }
}
