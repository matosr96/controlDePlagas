package modelo;

import entidades.Rol;
import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;

public class RolModelo {
// Método para obtener todos los roles

    public List<Rol> obtenerTodosLosRoles() {
        List<Rol> roles = new ArrayList<>();

        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM rol");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");

                Rol rol = new Rol(id, nombre);
                roles.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    // Método para guardar un nuevo rol
    public void guardarRol(Rol rol) {
        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO rol (nombre) VALUES (?)")) {

            statement.setString(1, rol.getNombre());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un rol existente
    public void actualizarRol(Rol rol) {
        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement("UPDATE rol SET nombre = ? WHERE id = ?")) {

            statement.setString(1, rol.getNombre());
            statement.setInt(2, rol.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un rol
    public void eliminarRol(int id) {
        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM rol WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un rol por su ID
    public Rol buscarRolPorId(int id) {
        Rol rol = null;

        try (Connection connection = Conexion.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM rol WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");

                rol = new Rol(id, nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rol;
    }
}
