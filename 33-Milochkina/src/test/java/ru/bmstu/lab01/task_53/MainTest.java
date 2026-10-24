package ru.bmstu.lab01.task_53;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 53
 */
class MainTest {

    @Test
    void shouldFindSingleSaddlePoint() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        int[][] expected = {{1, 0, 4}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNoPointsWhenNoneExist() {
        int[][] matrix = {{1, 3}, {4, 2}};
        int[][] expected = {};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllPointsForEqualValues() {
        int[][] matrix = {{7, 7}, {7, 7}};
        int[][] expected = {{0, 0, 7}, {0, 1, 7}, {1, 0, 7}, {1, 1, 7}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindRepeatedRowMinimums() {
        int[][] matrix = {{3, 3, 5}, {2, 2, 4}};
        int[][] expected = {{0, 0, 3}, {0, 1, 3}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] matrix = {{-5, -2}, {-3, -1}};
        int[][] expected = {{1, 0, -3}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleColumn() {
        int[][] matrix = {{-2}, {5}, {5}};
        int[][] expected = {{1, 0, 5}, {2, 0, 5}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[][] matrix = {{Integer.MIN_VALUE, Integer.MAX_VALUE}, {Integer.MIN_VALUE, Integer.MAX_VALUE}};
        int[][] expected = {{0, 0, Integer.MIN_VALUE}, {1, 0, Integer.MIN_VALUE}};

        int[][] actual = Main.findSaddlePoints(matrix);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "2 3\n1 2 3\n4 5 6\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "(1, 0, 4)" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintNothingWhenNoSaddlePointsExist() {
        String input = "2 2\n1 3\n4 2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        assertEquals("", actual);
    }
}
