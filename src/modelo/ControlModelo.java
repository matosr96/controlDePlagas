package modelo;

import utilidades.DatabaseConfig;
import entidades.Control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;

public class ControlModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todos los controles
    public List<Control> obtenerTodosLosControles() {
        List<Control> controles = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM control");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int actividadId = resultSet.getInt("actividad_id");
                int insumoId = resultSet.getInt("insumo_id");

                Control control = new Control(id, actividadId, insumoId);
                controles.add(control);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return controles;
    }

    // Método para guardar un nuevo control
    public void guardarControl(Control control) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO control (actividad_id, insumo_id) VALUES (?, ?)")) {

            statement.setInt(1, control.getActividadId());
            statement.setInt(2, control.getInsumoId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un control existente
    public void actualizarControl(Control control) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE control SET actividad_id = ?, insumo_id = ? WHERE id = ?")) {

            statement.setInt(1, control.getActividadId());
            statement.setInt(2, control.getInsumoId());
            statement.setInt(3, control.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un control
    public void eliminarControl(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM control WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un control por su ID
    public Control buscarControlPorId(int id) {
        Control control = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM control WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int actividadId = resultSet.getInt("actividad_id");
                int insumoId = resultSet.getInt("insumo_id");

                control = new Control(id, actividadId, insumoId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return control;
    }
}
