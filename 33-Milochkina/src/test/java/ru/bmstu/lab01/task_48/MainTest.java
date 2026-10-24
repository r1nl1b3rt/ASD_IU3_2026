package ru.bmstu.lab01.task_48;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 48
 */
class MainTest {

    @Test
    void shouldTransposeSquareMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldHandleTwoByTwoMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] expected = {{1, 3}, {2, 4}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldKeepSymmetricMatrix() {
        int[][] matrix = {{1, 2}, {2, 3}};
        int[][] expected = {{1, 2}, {2, 3}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldHandleSingleElement() {
        int[][] matrix = {{7}};
        int[][] expected = {{7}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-1, -2}, {-3, -4}};
        int[][] expected = {{-1, -3}, {-2, -4}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {0, -1}};
        int[][] expected = {{Integer.MIN_VALUE, 0}, {Integer.MAX_VALUE, -1}};

        Main.transpose(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 2 3\n4 5 6\n7 8 9\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = String.join(System.lineSeparator(), "1 4 7", "2 5 8", "3 6 9") + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
