package ru.bmstu.lab01.task_18;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки только чётных элементов в задаче 18
 */
class MainTest {

    @Test
    void shouldSortEvenElementsAndKeepOddPositions() {
        int[] numbers = {8, 3, 2, 7, 4, 1};
        int[] expected = {2, 3, 4, 7, 8, 1};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepArrayWithoutEvenElements() {
        int[] numbers = {7, -3, 5, 1};
        int[] expected = {7, -3, 5, 1};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldSortArrayOfEvenElements() {
        int[] numbers = {8, -4, 2, 0};
        int[] expected = {-4, 0, 2, 8};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-2, -3, -8, -1, -4};
        int[] expected = {-8, -3, -4, -1, -2};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleRepeatedEvenElements() {
        int[] numbers = {4, 1, 2, 3, 4, 2};
        int[] expected = {2, 1, 2, 3, 4, 4};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {2, Integer.MAX_VALUE, Integer.MIN_VALUE, -1, 0};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, -1, 2};

        Main.sortEvenElements(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6\n8 3 2 7 4 1\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "2 3 4 7 8 1" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
