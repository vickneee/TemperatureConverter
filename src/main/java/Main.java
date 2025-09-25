import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TemperatureConverter temp = new TemperatureConverter();

        System.out.println("Convert Fahrenheit to Celsius");
        System.out.println("Give temperature in Fahrenheit: ");
        int fahrenheit = scanner.nextInt();
        double celsius = (int) temp.fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " in Celsius: " + celsius);

        // 32F = 0C
        // 68F = 20C
        // 212F = 100C
        System.out.println(temp.fahrenheitToCelsius(32));
        System.out.println(temp.fahrenheitToCelsius(68));
        System.out.println(temp.fahrenheitToCelsius(212));

        // 10C = 50F
        // 20C = 68F
        // 50C = 122F
        // 100C = 212F
        System.out.println(temp.celsiusToFahrenheit(10));
        System.out.println(temp.celsiusToFahrenheit(20));
        System.out.println(temp.celsiusToFahrenheit(50));
        System.out.println(temp.celsiusToFahrenheit(100));

        System.out.println(temp.isExtremeTemperature(20));
        System.out.println(temp.isExtremeTemperature(50));
        System.out.println(temp.isExtremeTemperature(55));
        System.out.println(temp.isExtremeTemperature(-60));
        System.out.println(temp.isExtremeTemperature(-64));

        System.out.println(temp.kelvinToCelsius(200));
    }
}