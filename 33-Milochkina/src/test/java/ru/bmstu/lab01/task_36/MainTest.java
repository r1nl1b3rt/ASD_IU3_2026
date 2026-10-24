package ru.bmstu.lab01.task_36;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 36
 */
class MainTest {

    @Test
    void shouldHandleMixedValues() {
        int[] numbers = {4, -2, 9, 0, 7};
        long[] expected = {4L, 2L, 11L, 11L, 18L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -12, -5};
        long[] expected = {-8L, -11L, -23L, -28L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 0, 0};
        long[] expected = {0L, 0L, 0L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};
        long[] expected = {7L, 14L, 21L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleOppositeValues() {
        int[] numbers = {-5, 5, -2, 2};
        long[] expected = {-5L, 0L, -2L, 0L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        long[] expected = {-2147483648L, -1L, -1L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSumsLargerThanIntegerMaximum() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        long[] expected = {2147483647L, 4294967294L, 6442450941L};

        long[] actual = Main.runningSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n4 -2 9 0 7\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "4 2 11 11 18" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
