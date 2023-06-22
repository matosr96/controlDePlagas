package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "plagasdb";
    private static Integer portnumber = 3306;
    private static String password = "12345678";

    public static Connection getConnection() {
        Connection cnx = null;

        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setCharacterEncoding("UTF-8");

        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cnx;
    }
}
