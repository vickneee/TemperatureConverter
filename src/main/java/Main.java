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

        System.out.println("Convert Fahrenheit to Celsius");
        System.out.println("Give temperature in Fahrenheit: ");
        int celsius1 = scanner.nextInt();
        double fahrenheit1 = (int) temp.celsiusToFahrenheit(celsius1);
        System.out.println(celsius1 + " in Fahrenheit: " + fahrenheit1);
        System.out.println();

        System.out.println(temp.isExtremeTemperature(20));
        System.out.println(temp.isExtremeTemperature(50));
        System.out.println(temp.isExtremeTemperature(55));
        System.out.println(temp.isExtremeTemperature(-60));
        System.out.println(temp.isExtremeTemperature(-64));

        System.out.println(temp.kelvinToCelsius(200));
    }
}