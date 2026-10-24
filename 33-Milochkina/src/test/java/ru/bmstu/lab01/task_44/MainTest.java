package ru.bmstu.lab01.task_44;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 44
 */
class MainTest {

    @Test
    void shouldAlternateGroupedSigns() {
        int[] numbers = {1, 2, 3, -1, -2, -3};
        int[] expected = {1, -1, 2, -2, 3, -3};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldStartWithPositiveWhenNegativeComesFirst() {
        int[] numbers = {-1, -2, 3, 4};
        int[] expected = {3, -1, 4, -2};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPreserveOrderWithinSigns() {
        int[] numbers = {-5, 7, 3, -2, -9, 4};
        int[] expected = {7, -5, 3, -2, 4, -9};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepAlreadyAlternatingArray() {
        int[] numbers = {1, -1, 2, -2};
        int[] expected = {1, -1, 2, -2};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleRepeatedValues() {
        int[] numbers = {-2, -2, 3, 3};
        int[] expected = {3, -2, 3, -2};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] expected = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] actual = Main.alternateSigns(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6\n1 2 3 -1 -2 -3\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 -1 2 -2 3 -3" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
