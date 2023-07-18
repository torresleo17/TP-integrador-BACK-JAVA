package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionR {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/escuela?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "";

    public Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Error al establecer la conexión: " + e.getMessage());
        }

        return connection;
    }
}
