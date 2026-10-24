package ru.bmstu.lab01.task_16;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки по модулю в задаче 16
 */
class MainTest {

    @Test
    void shouldSortByAbsoluteValue() {
        int[] numbers = {3, -1, -4, 2, 0};
        int[] expected = {0, -1, 2, 3, -4};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPutNegativeFirstForEqualAbsoluteValues() {
        int[] numbers = {2, -2, 1, -1, 0};
        int[] expected = {0, -1, 1, -2, 2};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] numbers = {-8, -2, -5, -1};
        int[] expected = {-1, -2, -5, -8};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepRepeatedElements() {
        int[] numbers = {2, -2, 2, -2};
        int[] expected = {-2, -2, 2, 2};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 1, 0, -1};
        int[] expected = {0, 0, -1, 1};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, -2147483647, 0};
        int[] expected = {0, -2147483647, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] actual = Main.sortByAbsoluteValue(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n2 -2 1 -1 0\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "0 -1 1 -2 2" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
