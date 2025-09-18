public class TemperatureConverter {

    // https://www.w3resource.com/java-exercises/datatypes/java-datatype-exercise-1.php

    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius;
        celsius = (5 * (fahrenheit - 32)) / 9;
        return celsius;
    }

    public double celsiusToFahrenheit(double celsius) {
        double fahrenheit;
        fahrenheit = ((9 * celsius) + (32 * 5)) / 5;
        return fahrenheit;
    }

    public boolean isExtremeTemperature(double celsius) {
        if (celsius <= -40 || celsius >= 50) {
            return true;
        } else {
            return false;
        }

    }

    public double kelvinToCelsius(double kelvin) {
        double celsius;
        celsius = kelvin - 273.15;
        return celsius;

    }
}
