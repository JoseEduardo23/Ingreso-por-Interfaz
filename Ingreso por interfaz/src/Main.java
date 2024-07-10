import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes";
        String user = "root";
        String password = "j.eduardo23";

        String nombre = "Marmol Rondon";
        String cedula = "0000000050";
        Double B1 = 18.4;
        Double B2 = 14.0;

        String sql = "INSERT INTO estudiantes (Cedula_EST, Nombre_EST, B1, B2) VALUES (?, ?, ?, ?)";

        try {
            // Cargar el controlador MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

                cadenaPreparada.setString(1, cedula);
                cadenaPreparada.setString(2, nombre);
                cadenaPreparada.setDouble(3, B1);
                cadenaPreparada.setDouble(4, B2);

                int filasInsertadas = cadenaPreparada.executeUpdate();
                if (filasInsertadas > 0) {
                    System.out.println("Se ha insertado correctamente el estudiante.");
                } else {
                    System.out.println("No se ha podido insertar el estudiante.");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}