package ru.bmstu.lab01.task_13;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки выбором в задаче 13
 */
class MainTest {

    @Test
    void shouldSortMixedArray() {
        int[] numbers = {4, -2, 9, 0, 7};
        int[] expected = {-2, 0, 4, 7, 9};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] numbers = {-3, -8, -1, -5};
        int[] expected = {-8, -5, -3, -1};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepSortedArray() {
        int[] numbers = {-2, 0, 4, 7, 9};
        int[] expected = {-2, 0, 4, 7, 9};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortDescendingArray() {
        int[] numbers = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepEqualElements() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7, 7};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortRepeatedElements() {
        int[] numbers = {3, 1, 3, 1, 2};
        int[] expected = {1, 1, 2, 3, 3};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        int[] expected = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};

        Main.selectionSort(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n4 -2 9 0 7\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "-2 0 4 7 9" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
