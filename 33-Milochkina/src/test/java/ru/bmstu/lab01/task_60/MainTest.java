package ru.bmstu.lab01.task_60;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 60
 */
class MainTest {

    @Test
    void shouldCountSeparateIslands() {
        int[][] matrix = {{1, 1, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}};

        int actual = Main.countIslands(matrix);

        assertEquals(3, actual);
    }

    @Test
    void shouldReturnZeroForWaterOnly() {
        int[][] matrix = {{0, 0}, {0, 0}};

        int actual = Main.countIslands(matrix);

        assertEquals(0, actual);
    }

    @Test
    void shouldCountSolidLandAsOneIsland() {
        int[][] matrix = {{1, 1, 1}, {1, 1, 1}};

        int actual = Main.countIslands(matrix);

        assertEquals(1, actual);
    }

    @Test
    void shouldNotConnectDiagonallyTouchingCells() {
        int[][] matrix = {{1, 0}, {0, 1}};

        int actual = Main.countIslands(matrix);

        assertEquals(2, actual);
    }

    @Test
    void shouldHandleSingleRow() {
        int[][] matrix = {{1, 0, 1, 1, 0, 1}};

        int actual = Main.countIslands(matrix);

        assertEquals(3, actual);
    }

    @Test
    void shouldHandleSingleColumn() {
        int[][] matrix = {{1}, {0}, {1}, {1}};

        int actual = Main.countIslands(matrix);

        assertEquals(2, actual);
    }

    @Test
    void shouldHandleRingWithWaterInside() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        int actual = Main.countIslands(matrix);

        assertEquals(1, actual);
    }

    @Test
    void shouldHandleLongIslandWithoutRecursiveStackOverflow() {
        int[][] matrix = new int[1][20_000];
        Arrays.fill(matrix[0], 1);

        int actual = Main.countIslands(matrix);

        assertEquals(1, actual);
    }

    @Test
    void shouldKeepInputUnchanged() {
        int[][] matrix = {{1, 0}, {1, 1}};
        int[][] expected = {{1, 0}, {1, 1}};

        Main.countIslands(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3 4\n1 1 0 0\n0 1 0 1\n1 0 0 1\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "3" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
