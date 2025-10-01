import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureApp extends Application {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Override
    public void start(Stage stage) {
        Label inputLabel = new Label("Enter Fahrenheit: ");
        TextField inputField = new TextField();
        Button convertButton = new Button("Convert to Celsius");
        Label resultLabel = new Label();

        // Button action
        convertButton.setOnAction(e -> {
            try {
                double fahrenheit = Double.parseDouble(inputField.getText());
                double celsius = converter.fahrenheitToCelsius(fahrenheit); // Converter method
                resultLabel.setText(fahrenheit + " °F = " + celsius + " °C");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
            }
        });

        VBox vbox = new VBox(10, inputLabel, inputField, convertButton, resultLabel);
        vbox.setPadding(new Insets(15));

        Scene scene = new Scene(vbox, 300,300);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
