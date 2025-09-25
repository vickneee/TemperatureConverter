import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter temp = new TemperatureConverter();

    @Test
    void fahrenheitToCelsius() {
        assertEquals(0.0, temp.fahrenheitToCelsius(32));
        assertEquals(20.0, temp.fahrenheitToCelsius(68));
        assertEquals(100.0, temp.fahrenheitToCelsius(212));
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(50.0, temp.celsiusToFahrenheit(10));
        assertEquals(68.0, temp.celsiusToFahrenheit(20));
        assertEquals(122.0, temp.celsiusToFahrenheit(50));
        assertEquals(212.0, temp.celsiusToFahrenheit(100));
    }

    @Test
    void isExtremeTemperature() {
        assertTrue(temp.isExtremeTemperature(-40));
        assertFalse(temp.isExtremeTemperature(20));
        assertFalse(temp.isExtremeTemperature(49));
        assertTrue(temp.isExtremeTemperature(50));
        assertTrue(temp.isExtremeTemperature(55));
        assertFalse(temp.isExtremeTemperature(49));
    }

    @Test
    void kelvinToCelsius() {
        assertEquals(26.85, temp.kelvinToCelsius(300), 0.00001);
    }
}