package ru.bmstu.lab01.task_51;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 51
 */
class MainTest {

    @Test
    void shouldHandleRectangularMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[] expected = {3, 6};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSquareMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[] expected = {2, 4};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleRow() {
        int[][] matrix = {{1, -2, 3}};
        int[] expected = {3};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleColumn() {
        int[][] matrix = {{1}, {-2}, {3}};
        int[] expected = {1, -2, 3};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-5, -2}, {-8, -1}};
        int[] expected = {-2, -1};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MIN_VALUE}};
        int[] expected = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[][] matrix = {{7, 7}, {7, 7}};
        int[] expected = {7, 7};

        int[] actual = Main.rowMaximums(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "2 3\n1 2 3\n4 5 6\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "3 6" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
