package ru.bmstu.lab01.task_15;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка пузырьковой сортировки и количества обменов в задаче 15
 */
class MainTest {

    @Test
    void shouldSortMixedArrayAndCountSwaps() {
        int[] numbers = {4, -2, 9, 0, 7};
        int[] expected = {-2, 0, 4, 7, 9};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(4L, actualSwaps);
    }

    @Test
    void shouldCountAllSwapsInDescendingArray() {
        int[] numbers = {4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(6L, actualSwaps);
    }

    @Test
    void shouldReturnZeroForSortedArray() {
        int[] numbers = {-2, 0, 4, 7};
        int[] expected = {-2, 0, 4, 7};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(0L, actualSwaps);
    }

    @Test
    void shouldNotSwapEqualElements() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7, 7};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(0L, actualSwaps);
    }

    @Test
    void shouldCountSwapsWithRepeatedElements() {
        int[] numbers = {2, 1, 2, 1};
        int[] expected = {1, 1, 2, 2};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(3L, actualSwaps);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] numbers = {-1, -3, -2};
        int[] expected = {-3, -2, -1};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(2L, actualSwaps);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        long actualSwaps = Main.bubbleSortAndCount(numbers);

        assertArrayEquals(expected, numbers);
        assertEquals(1L, actualSwaps);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n4 3 2 1\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 2 3 4" + System.lineSeparator() + "6" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
