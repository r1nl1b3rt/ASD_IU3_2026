package ru.bmstu.lab01.task_35;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 35
 */
class MainTest {

    @Test
    void shouldBuildPrefixSumsForMixedValues() {
        int[] numbers = {4, -2, 9, 0, 7};
        long[] expected = {0L, 4L, 2L, 11L, 11L, 18L};

        long[] actual = Main.buildPrefixSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBuildPrefixSumsForNegativeValues() {
        int[] numbers = {-8, -3, -12};
        long[] expected = {0L, -8L, -11L, -23L};

        long[] actual = Main.buildPrefixSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBuildPrefixSumsWithoutIntegerOverflow() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        long[] expected = {0L, 2147483647L, 4294967294L};

        long[] actual = Main.buildPrefixSums(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSumOfWholeArray() {
        long[] prefixSums = {0L, 4L, 2L, 11L, 11L, 18L};

        long actual = Main.rangeSum(prefixSums, 0, 4);

        assertEquals(18L, actual);
    }

    @Test
    void shouldFindSumOfMiddleRange() {
        long[] prefixSums = {0L, 4L, 2L, 11L, 11L, 18L};

        long actual = Main.rangeSum(prefixSums, 1, 3);

        assertEquals(7L, actual);
    }

    @Test
    void shouldFindSumOfSingleElement() {
        long[] prefixSums = {0L, 4L, 2L, 11L, 11L, 18L};

        long actual = Main.rangeSum(prefixSums, 2, 2);

        assertEquals(9L, actual);
    }

    @Test
    void shouldIncludeLeftBoundary() {
        long[] prefixSums = {0L, 4L, 2L, 11L, 11L, 18L};

        long actual = Main.rangeSum(prefixSums, 0, 1);

        assertEquals(2L, actual);
    }

    @Test
    void shouldIncludeRightBoundary() {
        long[] prefixSums = {0L, 4L, 2L, 11L, 11L, 18L};

        long actual = Main.rangeSum(prefixSums, 3, 4);

        assertEquals(7L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n4 -2 9 0 7\n4\n0 4\n1 3\n2 2\n3 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = String.join(System.lineSeparator(), "18", "7", "9", "7") + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
