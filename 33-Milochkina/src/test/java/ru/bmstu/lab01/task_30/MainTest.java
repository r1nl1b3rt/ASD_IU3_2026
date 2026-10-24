package ru.bmstu.lab01.task_30;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 30
 */
class MainTest {

    private static final double DELTA = 1e-9;

    @Test
    void shouldFindVarianceForPositiveValues() {
        int[] numbers = {1, 2, 3, 4};

        double actual = Main.variance(numbers);

        assertEquals(1.25, actual, DELTA);
    }

    @Test
    void shouldDivideByArrayLength() {
        int[] numbers = {2, 4};

        double actual = Main.variance(numbers);

        assertEquals(1.0, actual, DELTA);
    }

    @Test
    void shouldReturnZeroForEqualValues() {
        int[] numbers = {7, 7, 7};

        double actual = Main.variance(numbers);

        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-1, -2, -3, -4};

        double actual = Main.variance(numbers);

        assertEquals(1.25, actual, DELTA);
    }

    @Test
    void shouldHandleMixedSigns() {
        int[] numbers = {-2, 0, 2};

        double actual = Main.variance(numbers);

        assertEquals(2.6666666666666665, actual, DELTA);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 0, 0};

        double actual = Main.variance(numbers);

        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void shouldAvoidCancellationForLargeCloseValues() {
        int[] numbers = {2147483645, Integer.MAX_VALUE};

        double actual = Main.variance(numbers);

        assertEquals(1.0, actual, DELTA);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n1 2 3 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1.25" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
