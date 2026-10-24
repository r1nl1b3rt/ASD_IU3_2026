package ru.bmstu.lab01.task_39;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 39
 */
class MainTest {

    @Test
    void shouldRotateByTwoPositions() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] expected = {4, 5, 1, 2, 3};

        Main.rotateRight(numbers, 2);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepArrayForZeroShift() {
        int[] numbers = {1, 2, 3};
        int[] expected = {1, 2, 3};

        Main.rotateRight(numbers, 0);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepArrayForFullLengthShift() {
        int[] numbers = {1, 2, 3};
        int[] expected = {1, 2, 3};

        Main.rotateRight(numbers, 3);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldNormalizeShiftLargerThanLength() {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] expected = {4, 5, 1, 2, 3};

        Main.rotateRight(numbers, 12);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleMaximumIntegerShift() {
        int[] numbers = {1, 2, 3};
        int[] expected = {3, 1, 2};

        Main.rotateRight(numbers, Integer.MAX_VALUE);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleNegativeAndRepeatedValues() {
        int[] numbers = {-2, 0, -2, 3};
        int[] expected = {3, -2, 0, -2};

        Main.rotateRight(numbers, 1);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleEmptyArray() {
        int[] numbers = {};
        int[] expected = {};

        Main.rotateRight(numbers, 5);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n1 2 3 4 5\n2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "4 5 1 2 3" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
