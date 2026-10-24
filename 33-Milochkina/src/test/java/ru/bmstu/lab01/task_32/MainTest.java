package ru.bmstu.lab01.task_32;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 32
 */
class MainTest {

    @Test
    void shouldSumAllDistinctIndexPairs() {
        int[] numbers = {1, 2, 3};

        BigInteger expected = new BigInteger("11");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleMixedSigns() {
        int[] numbers = {2, -3, 4};

        BigInteger expected = new BigInteger("-10");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleTwoElements() {
        int[] numbers = {-2, 5};

        BigInteger expected = new BigInteger("-10");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleRepeatedValues() {
        int[] numbers = {3, 3, 3, 3};

        BigInteger expected = new BigInteger("54");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {0, 0, 0};

        BigInteger expected = new BigInteger("0");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-1, -2, -3};

        BigInteger expected = new BigInteger("11");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnValueLargerThanLongMaximum() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        BigInteger expected = new BigInteger("13835058055282163712");

        BigInteger actual = Main.sumPairProducts(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 2 3\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "11" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
