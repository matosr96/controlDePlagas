package entidades;

import java.util.Date;

public class Insumo {

    private int id;
    private double cantidadDisponible;
    private Date fechaAdquisicion;
    private String nombre;

    public Insumo() {
    }

    public Insumo(int id, double cantidadDisponible, Date fechaAdquisicion, String nombre) {
        this.id = id;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaAdquisicion = fechaAdquisicion;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
