package ru.bmstu.lab01.task_26;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 26
 */
class MainTest {

    @Test
    void shouldMultiplyPositiveValues() {
        int[] numbers = {2, 3, 4};

        long actual = Main.productModulo(numbers);

        assertEquals(24L, actual);
    }

    @Test
    void shouldReturnZeroWhenArrayContainsZero() {
        int[] numbers = {2, 0, -3};

        long actual = Main.productModulo(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldNormalizeNegativeProduct() {
        int[] numbers = {-1, 2, 3};

        long actual = Main.productModulo(numbers);

        assertEquals(1000000001L, actual);
    }

    @Test
    void shouldHandleEvenNumberOfNegativeValues() {
        int[] numbers = {-2, -3, 4};

        long actual = Main.productModulo(numbers);

        assertEquals(24L, actual);
    }

    @Test
    void shouldHandleElementEqualToModulus() {
        int[] numbers = {1000000007, 2};

        long actual = Main.productModulo(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldHandleValuesNearModulus() {
        int[] numbers = {1000000006, 1000000006};

        long actual = Main.productModulo(numbers);

        assertEquals(1L, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        long actual = Main.productModulo(numbers);

        assertEquals(1897632L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n-1 2 3\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1000000001" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
