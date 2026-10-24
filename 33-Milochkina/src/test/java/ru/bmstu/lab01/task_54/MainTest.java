package ru.bmstu.lab01.task_54;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 54
 */
class MainTest {

    @Test
    void shouldProcessSquareMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(15L, actual);
    }

    @Test
    void shouldHandleTwoByTwoMatrix() {
        int[][] matrix = {{1, 2}, {3, 4}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(5L, actual);
    }

    @Test
    void shouldKeepSymmetricMatrix() {
        int[][] matrix = {{1, 2}, {2, 3}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(4L, actual);
    }

    @Test
    void shouldHandleSingleElement() {
        int[][] matrix = {{7}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(7L, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-1, -2}, {-3, -4}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(-5L, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {0, -1}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(-2147483649L, actual);
    }

    @Test
    void shouldReturnSumLargerThanIntegerMaximum() {
        int[][] matrix = {{Integer.MAX_VALUE, Integer.MAX_VALUE}, {Integer.MAX_VALUE, Integer.MAX_VALUE}};

        long actual = Main.mainDiagonalSum(matrix);

        assertEquals(4294967294L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 2 3\n4 5 6\n7 8 9\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "15" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
