package entidades;

public class Control {

    private int id;
    private int actividadId;
    private int insumoId;

    public Control() {
    }

    public Control(int id, int actividadId, int insumoId) {
        this.id = id;
        this.actividadId = actividadId;
        this.insumoId = insumoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public int getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(int insumoId) {
        this.insumoId = insumoId;
    }
}
