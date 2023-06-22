package entidades;

import java.util.Date;

public class Actividad {

    private int id;
    private Date fecha;
    private String lugarAplicacion;
    private String tipo;

    public Actividad() {
    }

    public Actividad(int id, Date fecha, String lugarAplicacion, String tipo) {
        this.id = id;
        this.fecha = fecha;
        this.lugarAplicacion = lugarAplicacion;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugarAplicacion() {
        return lugarAplicacion;
    }

    public void setLugarAplicacion(String lugarAplicacion) {
        this.lugarAplicacion = lugarAplicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
