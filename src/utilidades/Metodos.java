package utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import database.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Metodos {

    private Conexion conexion;

    public Metodos() {
        conexion = new Conexion();
    }

    public void CargarCombobox(String sentenciaSQL, JComboBox<String> comboBox) {
        try {
            Connection cn = conexion.getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);

            comboBox.removeAllItems();

            while (rs.next()) {
                comboBox.addItem(rs.getString(2));
            }

            rs.close();
            cn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet consultaRegistroPorEmail(String correo) {
        ResultSet rs = null;
        Connection cn = conexion.getConnection();

        String sql = "SELECT * FROM USUARIOS WHERE CORREO = ?";

        if (correo.equalsIgnoreCase("TODO")) {
            sql = "SELECT * FROM USUARIOS";
        } else if (!correo.equalsIgnoreCase("")) {
            correo = correo;
        } else {
            return rs;
        }

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            if (!correo.equalsIgnoreCase("TODO")) {
                ps.setString(1, correo);
            }

            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet consultaInsumoPorNombre(String nombre) {
        ResultSet rs = null;
        Connection cn = conexion.getConnection();

        String sql = "SELECT * FROM INSUMO WHERE NOMBRE = ?";

        if (nombre.equalsIgnoreCase("TODO")) {
            sql = "SELECT * FROM INSUMO";
        } else if (!nombre.equalsIgnoreCase("")) {
            nombre = nombre;
        } else {
            return rs;
        }

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            if (!nombre.equalsIgnoreCase("TODO")) {
                ps.setString(1, nombre);
            }

            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet consultaPlagaPorNombre(String nombre) {
        ResultSet rs = null;
        Connection cn = conexion.getConnection();

        String sql = "SELECT * FROM PLAGAS WHERE NOMBRE = ?";

        if (nombre.equalsIgnoreCase("TODO")) {
            sql = "SELECT * FROM PLAGAS";
        } else if (!nombre.equalsIgnoreCase("")) {
            nombre = nombre;
        } else {
            return rs;
        }

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            if (!nombre.equalsIgnoreCase("TODO")) {
                ps.setString(1, nombre);
            }

            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet consultaActividadPorUbicacion(String ubicacion) {
        ResultSet rs = null;
        Connection cn = conexion.getConnection();

        String sql = "SELECT * FROM ACTIVIDAD WHERE UBICACION = ?";

        if (ubicacion.equalsIgnoreCase("TODO")) {
            sql = "SELECT * FROM ACTIVIDAD";
        } else if (!ubicacion.equalsIgnoreCase("")) {
            ubicacion = ubicacion;
        } else {
            return rs;
        }

        try {
            PreparedStatement ps = cn.prepareStatement(sql);

            if (!ubicacion.equalsIgnoreCase("TODO")) {
                ps.setString(1, ubicacion);
            }

            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public int obtenerIdRol(String nombreRol) {
        int idRol = -1; // Default value if the ID is not found
        Connection cn = conexion.getConnection();

        String sql = "SELECT ID FROM roles WHERE NOMBRE = ?";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombreRol);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idRol = rs.getInt("ID");
            }

            rs.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return idRol;
    }

    public ResultSet consultaInsumos(String Valor) {

        ResultSet rs = null;
        Connection cn = conexion.getConnection();
        String id = "";

        String sql = "SELECT * FROM INSUMO WHERE ID = ?";

        if (Valor.equalsIgnoreCase("TODO")) {

            sql = "SELECT * FROM INSUMO";

        } else if (!Valor.equalsIgnoreCase("")) {

            id = (Valor);
        } else {

            return rs;
        }

        try {

            PreparedStatement ps = cn.prepareStatement(sql);

            if (!Valor.equalsIgnoreCase("TODO")) {

                ps.setString(1, id);

            }

            rs = ps.executeQuery();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }
}
