import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureApp extends Application {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Override
    public void start(Stage stage) {
        ComboBox<String> mapTypeBox = new ComboBox<>();
        mapTypeBox.getItems().addAll("Fahrenheit to Celsius", "Celsius to Fahrenheit", "Kelvin to Celsius");
        mapTypeBox.setValue("Fahrenheit to Celsius"); // Default value

        TextField inputField = new TextField();
        inputField.setPromptText("Enter value: ");

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();
        Label statusLabel = new Label();

        // Button action
        convertButton.setOnAction(e -> {
            try {
                double value = Double.parseDouble(inputField.getText());
                String type = mapTypeBox.getValue();

                switch (type) {
                    case "Fahrenheit to Celsius":
                        double celsius = converter.fahrenheitToCelsius(value);
                        resultLabel.setText(value + " °F = " + celsius + " °C");
                        // Save: Celsius and original Fahrenheit value
                        Database.saveTemperature(celsius, value, 0, statusLabel);
                        break;
                    case "Celsius to Fahrenheit":
                        double fahrenheit = converter.celsiusToFahrenheit(value);
                        resultLabel.setText(value + " °C = " + fahrenheit + " °F");
                        // Save: original Celsius value and converted Fahrenheit
                        Database.saveTemperature(value, fahrenheit, 0, statusLabel);
                        break;
                    case "Kelvin to Celsius":
                        double celsiusFromKelvin = converter.kelvinToCelsius(value);
                        resultLabel.setText(value + " °K = " + celsiusFromKelvin + " °C");
                        // Save: Celsius and null for Fahrenheit (or 0 if your DB allows)
                        Database.saveTemperature(celsiusFromKelvin, 0, value, statusLabel);
                        break;
                    default:
                        resultLabel.setText("Unknown conversion!");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
            }
        });

        VBox vbox = new VBox(10, mapTypeBox, inputField, convertButton, resultLabel, statusLabel);
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
