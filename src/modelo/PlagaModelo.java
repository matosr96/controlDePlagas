package modelo;

import utilidades.DatabaseConfig;
import entidades.Plaga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;

public class PlagaModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todas las plagas
    public List<Plaga> obtenerTodasLasPlagas() {
        List<Plaga> plagas = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM plaga");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                Plaga plaga = new Plaga(id, nombre);
                plagas.add(plaga);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plagas;
    }

    // Método para guardar una nueva plaga
    public void guardarPlaga(Plaga plaga) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO plaga (nombre) VALUES (?)")) {

            statement.setString(1, plaga.getNombre());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una plaga existente
    public void actualizarPlaga(Plaga plaga) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE plaga SET nombre = ? WHERE id = ?")) {

            statement.setString(1, plaga.getNombre());
            statement.setInt(2, plaga.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una plaga
    public void eliminarPlaga(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM plaga WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar una plaga por su ID
    public Plaga buscarPlagaPorId(int id) {
        Plaga plaga = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM plaga WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");

                plaga = new Plaga(id, nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plaga;
    }
}
