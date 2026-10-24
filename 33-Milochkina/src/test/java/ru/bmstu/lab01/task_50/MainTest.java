package ru.bmstu.lab01.task_50;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 50
 */
class MainTest {

    @Test
    void shouldHandleRectangularMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        long[] expected = {5L, 7L, 9L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSquareMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        long[] expected = {4L, 6L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleRow() {
        int[][] matrix = {{1, -2, 3}};
        long[] expected = {1L, -2L, 3L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleColumn() {
        int[][] matrix = {{1}, {-2}, {3}};
        long[] expected = {2L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-5, -2}, {-8, -1}};
        long[] expected = {-13L, -3L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MIN_VALUE}};
        long[] expected = {-1L, -1L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[][] matrix = {{7, 7}, {7, 7}};
        long[] expected = {14L, 14L};

        long[] actual = Main.columnSums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "2 3\n1 2 3\n4 5 6\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "5 7 9" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
