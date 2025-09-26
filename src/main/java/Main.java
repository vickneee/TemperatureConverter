import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TemperatureConverter temp = new TemperatureConverter();

        System.out.println("Convert Fahrenheit to Celsius");
        System.out.println("Give temperature in Fahrenheit: ");
        int fahrenheit = scanner.nextInt();
        double celsius = (int) temp.fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit in Celsius is " + celsius);
        System.out.println();

        System.out.println("Convert Celsius to Fahrenheit");
        System.out.println("Give temperature in Celsius: ");
        int celsius1 = scanner.nextInt();
        double fahrenheit1 = (int) temp.celsiusToFahrenheit(celsius1);
        System.out.println(celsius1 + " Celsius in Fahrenheit is " + fahrenheit1);
        System.out.println();

        System.out.println("Convert Kelvin to Celsius");
        System.out.println("Give temperature in Kelvin: ");
        int kelvin = scanner.nextInt();
        double celsius2 = (int) temp.kelvinToCelsius(kelvin);
        System.out.println(kelvin + " Kelvin in Celsius is " + celsius2);
        System.out.println();

        System.out.println("Is temperature extreme? ");
        System.out.println("Give temperature in Celsius: ");
        int celsiusExtreme = scanner.nextInt();
        boolean isExtreme = temp.isExtremeTemperature(celsiusExtreme);
        System.out.println(isExtreme);
        System.out.println();
    }
}