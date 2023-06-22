package modelo;

import utilidades.DatabaseConfig;
import entidades.Actividad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.sql.DriverManager;

public class ActividadModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todas las actividades
    public List<Actividad> obtenerTodasLasActividades() {
        List<Actividad> actividades = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM actividad");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date fecha = resultSet.getDate("fecha");
                String lugarAplicacion = resultSet.getString("lugar_aplicacion");
                String tipo = resultSet.getString("tipo");

                Actividad actividad = new Actividad(id, fecha, lugarAplicacion, tipo);
                actividades.add(actividad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actividades;
    }

    // Método para guardar una nueva actividad
    public void guardarActividad(Actividad actividad) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO actividad (fecha, lugar_aplicacion, tipo) VALUES (?, ?, ?)")) {

            statement.setDate(1, new java.sql.Date(actividad.getFecha().getTime()));
            statement.setString(2, actividad.getLugarAplicacion());
            statement.setString(3, actividad.getTipo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una actividad existente
    public void actualizarActividad(Actividad actividad) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE actividad SET fecha = ?, lugar_aplicacion = ?, tipo = ? WHERE id = ?")) {

            statement.setDate(1, new java.sql.Date(actividad.getFecha().getTime()));
            statement.setString(2, actividad.getLugarAplicacion());
            statement.setString(3, actividad.getTipo());
            statement.setInt(4, actividad.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una actividad
    public void eliminarActividad(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM actividad WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar una actividad por su ID
    public Actividad buscarActividadPorId(int id) {
        Actividad actividad = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM actividad WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Date fecha = resultSet.getDate("fecha");
                String lugarAplicacion = resultSet.getString("lugar_aplicacion");
                String tipo = resultSet.getString("tipo");

                actividad = new Actividad(id, fecha, lugarAplicacion, tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actividad;
    }

}
