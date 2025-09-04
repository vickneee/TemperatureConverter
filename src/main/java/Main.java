public class Main {
    public static void main(String[] args) {

        TemperatureConverter temp = new TemperatureConverter();

        // https://www.nfcacademy.com/wp-content/uploads/1/2/8/6/12864732/celsius-to-fahrenheit-conversion-chart-5s.pdf

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
    }
}