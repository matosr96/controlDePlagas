package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ConsultaRegistro {

    public static List<Map<String, Object>> consultaRegistro(String valor, String consultaSQL, Connection cn) {
        List<Map<String, Object>> registros = new ArrayList<>();

        try (PreparedStatement ps = cn.prepareStatement(consultaSQL)) {
            if (valor != null && !valor.isEmpty()) {
                ps.setString(1, valor);
            }

            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Map<String, Object> registro = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = rs.getObject(i);
                        registro.put(columnName, value);
                    }
                    registros.add(registro);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return registros;
    }
}
