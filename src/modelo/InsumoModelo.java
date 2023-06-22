package modelo;

import utilidades.DatabaseConfig;
import entidades.Insumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.DriverManager;

public class InsumoModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todos los insumos
    public List<Insumo> obtenerTodosLosInsumos() {
        List<Insumo> insumos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM insumo");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double cantidadDisponible = resultSet.getDouble("cantidad_disponible");
                Date fechaAdquisicion = resultSet.getDate("fecha_adquisicion");
                String nombre = resultSet.getString("nombre");

                Insumo insumo = new Insumo(id, cantidadDisponible, fechaAdquisicion, nombre);
                insumos.add(insumo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insumos;
    }

    // Método para guardar un nuevo insumo
    public void guardarInsumo(Insumo insumo) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO insumo (cantidad_disponible, fecha_adquisicion, nombre) VALUES (?, ?, ?)")) {

            statement.setDouble(1, insumo.getCantidadDisponible());
            statement.setDate(2, new java.sql.Date(insumo.getFechaAdquisicion().getTime()));
            statement.setString(3, insumo.getNombre());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un insumo existente
    public void actualizarInsumo(Insumo insumo) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE insumo SET cantidad_disponible = ?, fecha_adquisicion = ?, nombre = ? WHERE id = ?")) {

            statement.setDouble(1, insumo.getCantidadDisponible());
            statement.setDate(2, new java.sql.Date(insumo.getFechaAdquisicion().getTime()));
            statement.setString(3, insumo.getNombre());
            statement.setInt(4, insumo.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un insumo
    public void eliminarInsumo(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM insumo WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un insumo por su ID
    public Insumo buscarInsumoPorId(int id) {
        Insumo insumo = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM insumo WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double cantidadDisponible = resultSet.getDouble("cantidad_disponible");
                Date fechaAdquisicion = resultSet.getDate("fecha_adquisicion");
                String nombre = resultSet.getString("nombre");

                insumo = new Insumo(id, cantidadDisponible, fechaAdquisicion, nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return insumo;
    }
}
