package ru.bmstu.lab01.task_59;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 59
 */
class MainTest {

    @Test
    void shouldFindDeterminant() {
        int[][] matrix = {{6, 1, 1}, {4, -2, 5}, {2, 8, 7}};
        BigInteger expected = new BigInteger("-306");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOneForIdentity() {
        int[][] matrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        BigInteger expected = new BigInteger("1");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroForDependentRows() {
        int[][] matrix = {{1, 2, 3}, {2, 4, 6}, {4, 5, 6}};
        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMultiplyDiagonalForTriangularMatrix() {
        int[][] matrix = {{2, 5, -1}, {0, -3, 7}, {0, 0, 4}};
        BigInteger expected = new BigInteger("-24");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeDeterminant() {
        int[][] matrix = {{0, 1, 0}, {1, 0, 0}, {0, 0, 1}};
        BigInteger expected = new BigInteger("-1");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnValueLargerThanLongMaximum() {
        int[][] matrix = {{Integer.MAX_VALUE, 0, 0}, {0, Integer.MAX_VALUE, 0}, {0, 0, Integer.MAX_VALUE}};
        BigInteger expected = new BigInteger("9903520300447984150353281023");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleMinimumIntegerValues() {
        int[][] matrix = {{Integer.MIN_VALUE, 0, 0}, {0, Integer.MIN_VALUE, 0}, {0, 0, Integer.MIN_VALUE}};
        BigInteger expected = new BigInteger("-9903520314283042199192993792");

        BigInteger actual = Main.determinant(matrix);

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6 1 1\n4 -2 5\n2 8 7\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "-306" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
