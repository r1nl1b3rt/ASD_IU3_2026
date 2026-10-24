package ru.bmstu.lab01.task_28;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 28
 */
class MainTest {

    private static final double DELTA = 1e-9;

    @Test
    void shouldFindMedianForOddLength() {
        int[] numbers = {9, 1, 5, 3, 7};

        double actual = Main.median(numbers);

        assertEquals(5.0, actual, DELTA);
    }

    @Test
    void shouldFindFractionalMedianForEvenLength() {
        int[] numbers = {4, 1, 3, 2};

        double actual = Main.median(numbers);

        assertEquals(2.5, actual, DELTA);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -5, -1};

        double actual = Main.median(numbers);

        assertEquals(-4.0, actual, DELTA);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};

        double actual = Main.median(numbers);

        assertEquals(7.0, actual, DELTA);
    }

    @Test
    void shouldHandleTwoElements() {
        int[] numbers = {9, -2};

        double actual = Main.median(numbers);

        assertEquals(3.5, actual, DELTA);
    }

    @Test
    void shouldAvoidOverflowForLargeCentralValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        double actual = Main.median(numbers);

        assertEquals(2147483647.0, actual, DELTA);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        double actual = Main.median(numbers);

        assertEquals(-0.5, actual, DELTA);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n4 1 3 2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "2.5" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
