package clases;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConexionR conexionR = new ConexionR();

        try {
            Connection connection = conexionR.getConnection();

            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                // Realiza las operaciones que necesites aquí
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }

            // Cierra la conexión después de usarla
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión: " + e.getMessage());
        }
    }
}

