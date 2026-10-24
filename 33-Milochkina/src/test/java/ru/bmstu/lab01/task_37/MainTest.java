package ru.bmstu.lab01.task_37;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 37
 */
class MainTest {

    @Test
    void shouldReverseOddLengthArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldReverseEvenLengthArray() {
        int[] numbers = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-1, -3, -2};
        int[] expected = {-2, -3, -1};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleRepeatedValues() {
        int[] numbers = {2, 1, 2, 1};
        int[] expected = {1, 2, 1, 2};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        int[] expected = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] numbers = {};
        int[] expected = {};

        Main.reverse(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n1 2 3 4 5\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "5 4 3 2 1" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
