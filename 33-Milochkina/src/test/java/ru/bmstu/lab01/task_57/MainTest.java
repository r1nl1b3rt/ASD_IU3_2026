package ru.bmstu.lab01.task_57;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 57
 */
class MainTest {

    @Test
    void shouldHandleRectangularMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[] expected = {1, 2, 3, 6, 5, 4};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSquareMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[] expected = {1, 2, 4, 3};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleRow() {
        int[][] matrix = {{1, -2, 3}};
        int[] expected = {1, -2, 3};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleColumn() {
        int[][] matrix = {{1}, {-2}, {3}};
        int[] expected = {1, -2, 3};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-5, -2}, {-8, -1}};
        int[] expected = {-5, -2, -1, -8};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MIN_VALUE}};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleOddSquareWithCentralElement() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleTallRectangle() {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[] expected = {1, 2, 4, 6, 8, 7, 5, 3};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleElement() {
        int[][] matrix = {{42}};
        int[] expected = {42};

        int[] actual = Main.spiralOrder(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3 3\n1 2 3\n4 5 6\n7 8 9\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 2 3 6 9 8 7 4 5" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
