package ru.bmstu.lab01.task_31;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 31
 */
class MainTest {

    @Test
    void shouldMultiplyCorrespondingElements() {
        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};
        BigInteger expected = new BigInteger("32");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] first = {-1, -2};
        int[] second = {3, 4};
        BigInteger expected = new BigInteger("-11");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleMixedSigns() {
        int[] first = {2, -3, 4};
        int[] second = {-5, 6, 7};
        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroForZeroArray() {
        int[] first = {1, 2, 3};
        int[] second = {0, 0, 0};
        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnZeroForCancellingProducts() {
        int[] first = {1, 1};
        int[] second = {5, -5};
        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnValueLargerThanLongMaximum() {
        int[] first = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] second = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        BigInteger expected = new BigInteger("13835058055282163712");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleOppositeExtremeValues() {
        int[] first = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] second = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        BigInteger expected = new BigInteger("-9223372032559808512");

        BigInteger actual = Main.dotProduct(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 2 3\n3\n4 5 6\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "32" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
