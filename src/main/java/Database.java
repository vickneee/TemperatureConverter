import io.github.cdimascio.dotenv.Dotenv;
import javafx.scene.control.Label;

import java.sql.*;

public class Database {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");;

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