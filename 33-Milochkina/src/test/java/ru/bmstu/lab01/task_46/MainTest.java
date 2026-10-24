package ru.bmstu.lab01.task_46;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 46
 */
class MainTest {

    @Test
    void shouldMatchExample() {
        int[] numbers = {100, 50, 100, 300};
        int[] expected = {1, 0, 1, 2};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-5, -1, -5, -3};
        int[] expected = {0, 2, 0, 1};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAssignZeroToEqualValues() {
        int[] numbers = {7, 7, 7};
        int[] expected = {0, 0, 0};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepAlreadyRankedValues() {
        int[] numbers = {0, 1, 2, 3};
        int[] expected = {0, 1, 2, 3};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleDescendingValues() {
        int[] numbers = {9, 5, 2};
        int[] expected = {2, 1, 0};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, Integer.MIN_VALUE};
        int[] expected = {2, 0, 1, 0};

        int[] actual = Main.compressCoordinates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n100 50 100 300\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 0 1 2" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
