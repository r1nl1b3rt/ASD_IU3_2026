package ru.bmstu.lab01.task_40;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 40
 */
class MainTest {

    @Test
    void shouldRemoveRepeatedValues() {
        int[] numbers = {1, 1, 2, 2, 3};
        int[] expected = {1, 2, 3};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldKeepUniqueValues() {
        int[] numbers = {-3, 0, 4, 8};
        int[] expected = {-3, 0, 4, 8};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldKeepOneOfEqualValues() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-5, -5, -2, -2, -1};
        int[] expected = {-5, -2, -1};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] numbers = {};
        int[] expected = {};

        int actualLength = Main.removeDuplicates(numbers);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n1 1 2 2 3\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 2 3" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
