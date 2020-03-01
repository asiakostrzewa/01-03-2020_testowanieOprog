import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalcAppTest {

    private CalcApp calcApp;

    @BeforeEach
    void setUp() {
        calcApp = new CalcApp();
    }

    //@Test
    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, 1, 8, 10, 100})
    void addValues(double expected) { //zamiast
        // double expected = 8;
        double actual = calcApp.addValues(3, 5); //current, actual value, expected value
        assertEquals(expected, actual); //zdefiniowanie aserpcji
        /*if (expected != actual){
            throw Exception();
        }*/
        //assertNotNull(actual);
    }

    @Test
    void addValuesToZero() {
        double expected = 10;
        double actual = calcApp.addValues(0, 10);
        assertEquals(
                expected,
                actual,
                "--- Added values are not as expected ---");
    }

    @Test
    void isLessThanTen() {
        boolean result = calcApp.isLessThanTen(7);
        assertTrue(result); //alternatywnie do assertEquals

        //lub assertTrue(calcApp.isLessThanTen(7));
    }

    @ParameterizedTest
    @CsvSource(value = { //używamy Csv bo będziemy przypisywać 3 wartości, a nie 1 jak w przypadku @Test
            "11:12:-1",
            "33:12:21",
            "100:-100:0"
    }, delimiter = ':') //w Csv dane różnia się na podstawie zadanego znaku, w tym wypadku ":"
    void subtValues(double val1, double val2, double expected) { //kolejność odpowiada kolejnością z Csv
        assertEquals(
                expected,
                calcApp.subtValues(val1, val2)
        );
        /*double expected = 4;
        double actual = calcApp.subtValues(10, 7);
        assertEquals(expected, actual);*/
    }

    @Test
    void subtValuesNotNull() {
        assertNotNull(calcApp.subtValues(1.0, -1.0));
    }

    @Test
    void subtValuesNotThrow() {
        assertDoesNotThrow(() -> (calcApp.subtValues(1.0, -1.0))); //operator lambda: rzutowanie na obiekt typu funkcja
    }

    @Test
    void subtValuesGreaterThanZero() {
        assertThat(calcApp.subtValues(13, 11))
                .isGreaterThan(0)
                .isLessThan(5)
                .isEqualTo(2)
                .isNotNull().
                isInstanceOf(Double.class); //funkcja zwraca obiekt Double a nie zmienną double :O
       /* assertTrue(
                calcApp.subtValues(9, 11) > 0,
                "Subtraction result is less than 0"
        );*/
    }
}