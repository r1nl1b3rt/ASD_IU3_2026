package ru.bmstu.lab01.task_27;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 27
 */
class MainTest {

    @Test
    void shouldHandleMixedValues() {
        int[] numbers = {4, -2, 9, 0, 7};

        BigInteger expected = new BigInteger("150");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -12, -5};

        BigInteger expected = new BigInteger("242");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 0, 0};

        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};

        BigInteger expected = new BigInteger("147");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleOppositeValues() {
        int[] numbers = {-5, 5, -2, 2};

        BigInteger expected = new BigInteger("58");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        BigInteger expected = new BigInteger("9223372032559808513");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSumLargerThanLongMaximum() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        BigInteger expected = new BigInteger("13835058055282163712");

        BigInteger actual = Main.sumSquares(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n-2 0 3 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "29" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
