package ru.bmstu.lab01.task_43;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 43
 */
class MainTest {

    @Test
    void shouldMoveZerosAndKeepOtherOrder() {
        int[] numbers = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepArrayWithoutZeros() {
        int[] numbers = {-2, 1, -3};
        int[] expected = {-2, 1, -3};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleAllZeros() {
        int[] numbers = {0, 0, 0};
        int[] expected = {0, 0, 0};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldKeepZerosAtEnd() {
        int[] numbers = {1, 2, 0, 0};
        int[] expected = {1, 2, 0, 0};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleZerosAtBeginning() {
        int[] numbers = {0, 0, -1, -2};
        int[] expected = {-1, -2, 0, 0};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {0, Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0};

        Main.moveZerosToEnd(numbers);

        assertArrayEquals(expected, numbers);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n0 1 0 3 12\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 3 12 0 0" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
