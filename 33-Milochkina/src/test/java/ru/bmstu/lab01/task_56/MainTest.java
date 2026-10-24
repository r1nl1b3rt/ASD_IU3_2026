package ru.bmstu.lab01.task_56;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 56
 */
class MainTest {

    @Test
    void shouldMultiplyRectangularMatrices() {
        int[][] first = {{1, 2, 3}, {4, 5, 6}};
        int[][] second = {{7, 8}, {9, 10}, {11, 12}};
        BigInteger[][] expected = {{new BigInteger("58"), new BigInteger("64")},
            {new BigInteger("139"), new BigInteger("154")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMultiplyByIdentity() {
        int[][] first = {{2, -3}, {4, 5}};
        int[][] second = {{1, 0}, {0, 1}};
        BigInteger[][] expected = {{new BigInteger("2"), new BigInteger("-3")},
            {new BigInteger("4"), new BigInteger("5")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMultiplyByZeroMatrix() {
        int[][] first = {{1, 2}, {3, 4}};
        int[][] second = {{0, 0}, {0, 0}};
        BigInteger[][] expected = {{new BigInteger("0"), new BigInteger("0")},
            {new BigInteger("0"), new BigInteger("0")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[][] first = {{-1, 2}, {-3, 4}};
        int[][] second = {{5, -6}, {7, -8}};
        BigInteger[][] expected = {{new BigInteger("9"), new BigInteger("-10")},
            {new BigInteger("13"), new BigInteger("-14")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleRowAndColumn() {
        int[][] first = {{1, 2, 3}};
        int[][] second = {{4}, {5}, {6}};
        BigInteger[][] expected = {{new BigInteger("32")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleSingleElementMatrices() {
        int[][] first = {{-2}};
        int[][] second = {{5}};
        BigInteger[][] expected = {{new BigInteger("-10")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnValuesLargerThanLongMaximum() {
        int[][] first = {{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}};
        int[][] second = {{Integer.MIN_VALUE}, {Integer.MIN_VALUE}, {Integer.MIN_VALUE}};
        BigInteger[][] expected = {{new BigInteger("13835058055282163712")}};

        BigInteger[][] actual = Main.multiply(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "2 3\n1 2 3\n4 5 6\n3 2\n7 8\n9 10\n11 12\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = String.join(System.lineSeparator(), "58 64", "139 154") + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
