package ru.bmstu.lab01.task_24;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка чётно-нечётной сортировки в задаче 24
 */
class MainTest {

    @Test
    void shouldPutSortedEvenElementsBeforeDescendingOddElements() {
        int[] numbers = {5, 2, 7, 4, 1, 0};
        int[] expected = {0, 2, 4, 7, 5, 1};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortEvenArrayAscending() {
        int[] numbers = {8, -4, 2, 0};
        int[] expected = {-4, 0, 2, 8};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortOddArrayDescending() {
        int[] numbers = {1, 7, -3, 5};
        int[] expected = {7, 5, 1, -3};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-3, -2, -7, -4, -1, 0};
        int[] expected = {-4, -2, 0, -1, -3, -7};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepRepeatedElements() {
        int[] numbers = {3, 2, 3, 2, -1, -1};
        int[] expected = {2, 2, 3, 3, -1, -1};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, 2, Integer.MIN_VALUE, -1, 0};
        int[] expected = {Integer.MIN_VALUE, 0, 2, Integer.MAX_VALUE, -1};

        int[] actual = Main.sortEvenThenOdd(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6\n5 2 7 4 1 0\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "0 2 4 7 5 1" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
