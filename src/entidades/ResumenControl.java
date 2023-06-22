package entidades;

public class ResumenControl {

    private int id;
    private double gastoInsumos;
    private double porcentajeExito;
    private int tiempoControl;
    private int controlId;

    public ResumenControl() {
    }

    public ResumenControl(int id, double gastoInsumos, double porcentajeExito, int tiempoControl, int controlId) {
        this.id = id;
        this.gastoInsumos = gastoInsumos;
        this.porcentajeExito = porcentajeExito;
        this.tiempoControl = tiempoControl;
        this.controlId = controlId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGastoInsumos() {
        return gastoInsumos;
    }

    public void setGastoInsumos(double gastoInsumos) {
        this.gastoInsumos = gastoInsumos;
    }

    public double getPorcentajeExito() {
        return porcentajeExito;
    }

    public void setPorcentajeExito(double porcentajeExito) {
        this.porcentajeExito = porcentajeExito;
    }

    public int getTiempoControl() {
        return tiempoControl;
    }

    public void setTiempoControl(int tiempoControl) {
        this.tiempoControl = tiempoControl;
    }

    public int getControlId() {
        return controlId;
    }

    public void setControlId(int controlId) {
        this.controlId = controlId;
    }
}
