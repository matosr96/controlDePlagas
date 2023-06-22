package servicio;

import modelo.PlagaModelo;
import entidades.Plaga;
import java.util.List;

public class PlagaServicio {

    private PlagaModelo plagaModelo;

    public PlagaServicio() {
        plagaModelo = new PlagaModelo();
    }

    public void guardarPlaga(Plaga plaga) {
        plagaModelo.guardarPlaga(plaga);
    }

    public void actualizarPlaga(Plaga plaga) {
        plagaModelo.actualizarPlaga(plaga);
    }

    public void eliminarPlaga(int id) {
        plagaModelo.eliminarPlaga(id);
    }

    public Plaga buscarPlagaPorId(int id) {
        return plagaModelo.buscarPlagaPorId(id);
    }

    public List<Plaga> obtenerTodasLasPlagas() {
        return plagaModelo.obtenerTodasLasPlagas();
    }
}
