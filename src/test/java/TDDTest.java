import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TDDTest {

    private TDD tdd;

    @BeforeEach
    void setUp() {
        tdd = new TDD();
    }

    @Test
    void powValue() {
        int expected = 16;
        double actual = tdd.powValue(4, 2);
        assertEquals(expected, actual);
    }

    @Test
    void divValues() {
        assertThat(tdd.divValue(16, 4))
                .isGreaterThan(0)
                .isEqualTo(4)
                .isNotNull();
        /*void divValue(double v1, double v2, double expected)
        double actual = 0;
        try {
        actual = ttd.divValue(v1, v2);
        assertEquals(expected, actual);
        } catch (Exception ex) {
        fail();
        }*/
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4:16",
            "0:5",
            "-10:100"
    }, delimiter = ':')
    void sqrtValue(double val, double expected) {
        assertEquals(
                expected,
                tdd.sqrtValue(val)
        );
    }
}