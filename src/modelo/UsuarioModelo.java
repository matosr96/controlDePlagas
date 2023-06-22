package modelo;

import utilidades.DatabaseConfig;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import java.sql.DriverManager;

public class UsuarioModelo {

    private static final String URL = DatabaseConfig.getUrl();
    private static final String USERNAME = DatabaseConfig.getUsername();
    private static final String PASSWORD = DatabaseConfig.getPassword();

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String correo = resultSet.getString("correo");
                String contraseña = resultSet.getString("contraseña");
                int rolId = resultSet.getInt("rol_id");

                Usuario usuario = new Usuario(id, nombre, apellido, correo, contraseña, rolId);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Método para guardar un nuevo usuario
    public void guardarUsuario(Usuario usuario) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario (nombre, apellido, correo, contraseña, rol_id, created_at) VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContraseña());
            statement.setInt(5, usuario.getRolId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un usuario existente
    public void actualizarUsuario(Usuario usuario) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET nombre = ?, apellido = ?, correo = ?, contraseña = ?, rol_id = ?, created_at = ? WHERE id = ?")) {

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContraseña());
            statement.setInt(5, usuario.getRolId());

            statement.setInt(7, usuario.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un usuario por su ID
    public Usuario buscarUsuarioPorId(int id) {
        Usuario usuario = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String correo = resultSet.getString("correo");
                String contraseña = resultSet.getString("contraseña");
                int rolId = resultSet.getInt("rol_id");

                usuario = new Usuario(id, nombre, apellido, correo, contraseña, rolId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
