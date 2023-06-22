package modelo;

import utilidades.DatabaseConfig;
import entidades.ResumenControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;

public class ResumenControlModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todos los resúmenes de control
    public List<ResumenControl> obtenerTodosLosResumenesControl() {
        List<ResumenControl> resumenesControl = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM resumencontrol");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double gastoInsumos = resultSet.getDouble("gasto_insumos");
                double porcentajeExito = resultSet.getDouble("porcentaje_exito");
                int tiempoControl = resultSet.getInt("tiempo_control");
                int controlId = resultSet.getInt("control_id");

                ResumenControl resumenControl = new ResumenControl(id, gastoInsumos, porcentajeExito, tiempoControl, controlId);
                resumenesControl.add(resumenControl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resumenesControl;
    }

    // Método para guardar un nuevo resumen de control
    public void guardarResumenControl(ResumenControl resumenControl) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO resumencontrol (gasto_insumos, porcentaje_exito, tiempo_control, control_id) VALUES (?, ?, ?, ?)")) {

            statement.setDouble(1, resumenControl.getGastoInsumos());
            statement.setDouble(2, resumenControl.getPorcentajeExito());
            statement.setInt(3, resumenControl.getTiempoControl());
            statement.setInt(4, resumenControl.getControlId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un resumen de control existente
    public void actualizarResumenControl(ResumenControl resumenControl) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE resumencontrol SET gasto_insumos = ?, porcentaje_exito = ?, tiempo_control = ?, control_id = ? WHERE id = ?")) {

            statement.setDouble(1, resumenControl.getGastoInsumos());
            statement.setDouble(2, resumenControl.getPorcentajeExito());
            statement.setInt(3, resumenControl.getTiempoControl());
            statement.setInt(4, resumenControl.getControlId());
            statement.setInt(5, resumenControl.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un resumen de control
    public void eliminarResumenControl(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM resumencontrol WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un resumen de control por su ID
    public ResumenControl buscarResumenControlPorId(int id) {
        ResumenControl resumenControl = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM resumencontrol WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double gastoInsumos = resultSet.getDouble("gasto_insumos");
                double porcentajeExito = resultSet.getDouble("porcentaje_exito");
                int tiempoControl = resultSet.getInt("tiempo_control");
                int controlId = resultSet.getInt("control_id");

                resumenControl = new ResumenControl(id, gastoInsumos, porcentajeExito, tiempoControl, controlId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resumenControl;
    }
}
