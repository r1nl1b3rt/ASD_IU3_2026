package ru.bmstu.lab01.task_22;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки по частоте в задаче 22
 */
class MainTest {

    @Test
    void shouldSortByDescendingFrequency() {
        int[] numbers = {4, 1, 4, 2, 1, 4};
        int[] expected = {4, 4, 4, 1, 1, 2};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortEqualFrequenciesByValue() {
        int[] numbers = {3, -1, 2, 3, 2, -1};
        int[] expected = {-1, -1, 2, 2, 3, 3};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortDistinctElementsByValue() {
        int[] numbers = {4, -2, 9, 0};
        int[] expected = {-2, 0, 4, 9};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepEqualElements() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7, 7};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValuesAndZero() {
        int[] numbers = {0, -2, 0, -2, -2, 1};
        int[] expected = {-2, -2, -2, 0, 0, 1};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] expected = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0};

        int[] actual = Main.sortByFrequency(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6\n4 1 4 2 1 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "4 4 4 1 1 2" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
