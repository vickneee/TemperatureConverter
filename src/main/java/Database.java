import javafx.scene.control.Label;

import java.sql.*;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/temperatureconverter_mariadb";
    private static final String USER = "victoria";
    private static final String PASSWORD = "victoria";

    public static void saveTemperature(double celsius, double fahrenheit, double kelvin, Label statusLabel) {
        String sql = "INSERT INTO temperature_log (celsius, fahrenheit, kelvin) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, celsius);
            stmt.setDouble(2, fahrenheit);
            stmt.setDouble(3, kelvin);

            stmt.executeUpdate();
            statusLabel.setText("Saved to database!");

        } catch (SQLException e) {
            statusLabel.setText("DB Error: " + e.getMessage());
        }
    }
}