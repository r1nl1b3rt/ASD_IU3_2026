package ru.bmstu.lab01.task_20;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки подсчётом в задаче 20
 */
class MainTest {

    @Test
    void shouldSortMixedArray() {
        int[] numbers = {4, -2, 9, 0, 7};
        int[] expected = {-2, 0, 4, 7, 9};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] numbers = {-3, -8, -1, -5};
        int[] expected = {-8, -5, -3, -1};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepSortedArray() {
        int[] numbers = {-2, 0, 4, 7, 9};
        int[] expected = {-2, 0, 4, 7, 9};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortDescendingArray() {
        int[] numbers = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepEqualElements() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7, 7};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortRepeatedElements() {
        int[] numbers = {3, 1, 3, 1, 2};
        int[] expected = {1, 1, 2, 3, 3};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] numbers = {};
        int[] expected = {};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortValuesNearIntegerMinimum() {
        int[] numbers = {-2147483646, Integer.MIN_VALUE, -2147483647};
        int[] expected = {Integer.MIN_VALUE, -2147483647, -2147483646};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortValuesNearIntegerMaximum() {
        int[] numbers = {Integer.MAX_VALUE, 2147483645, 2147483646};
        int[] expected = {2147483645, 2147483646, Integer.MAX_VALUE};

        Main.countingSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "7\n3 -2 0 3 -5 -2 1\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "-5 -2 -2 0 1 3 3" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
