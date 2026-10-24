package ru.bmstu.lab01.task_14;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки вставками в задаче 14
 */
class MainTest {

    @Test
    void shouldSortMixedArray() {
        int[] numbers = {4, -2, 9, 0, 7};
        int[] expected = {9, 7, 4, 0, -2};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] numbers = {-3, -8, -1, -5};
        int[] expected = {-1, -3, -5, -8};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortAscendingArray() {
        int[] numbers = {-2, 0, 4, 7, 9};
        int[] expected = {9, 7, 4, 0, -2};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepDescendingArray() {
        int[] numbers = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepEqualElements() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7, 7};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortRepeatedElements() {
        int[] numbers = {3, 1, 3, 1, 2};
        int[] expected = {3, 3, 2, 1, 1};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        int[] expected = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};

        Main.insertionSortDescending(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n4 -2 9 0 7\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "9 7 4 0 -2" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
