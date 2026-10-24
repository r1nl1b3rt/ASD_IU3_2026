package ru.bmstu.lab01.task_25;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 25
 */
class MainTest {

    @Test
    void shouldHandleMixedValues() {
        int[] numbers = {4, -2, 9, 0, 7};

        long actual = Main.sum(numbers);

        assertEquals(18L, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -12, -5};

        long actual = Main.sum(numbers);

        assertEquals(-28L, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 0, 0};

        long actual = Main.sum(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};

        long actual = Main.sum(numbers);

        assertEquals(21L, actual);
    }

    @Test
    void shouldHandleOppositeValues() {
        int[] numbers = {-5, 5, -2, 2};

        long actual = Main.sum(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        long actual = Main.sum(numbers);

        assertEquals(-1L, actual);
    }

    @Test
    void shouldReturnSumLargerThanIntegerMaximum() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        long actual = Main.sum(numbers);

        assertEquals(6442450941L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n4 -2 9 0 7\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "18" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
