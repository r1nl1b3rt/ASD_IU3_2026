package ru.bmstu.lab01.task_33;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 33
 */
class MainTest {

    @Test
    void shouldCountInversionsInMixedArray() {
        int[] numbers = {2, 4, 1, 3, 5};

        long actual = Main.countInversions(numbers);

        assertEquals(3L, actual);
    }

    @Test
    void shouldReturnZeroForSortedArray() {
        int[] numbers = {-2, 0, 3, 8};

        long actual = Main.countInversions(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldCountAllPairsInDescendingArray() {
        int[] numbers = {5, 4, 3, 2, 1};

        long actual = Main.countInversions(numbers);

        assertEquals(10L, actual);
    }

    @Test
    void shouldNotCountEqualElementsAsInversions() {
        int[] numbers = {7, 7, 7};

        long actual = Main.countInversions(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldCountInversionsWithRepeatedValues() {
        int[] numbers = {2, 1, 2, 1};

        long actual = Main.countInversions(numbers);

        assertEquals(3L, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-1, -3, -2};

        long actual = Main.countInversions(numbers);

        assertEquals(2L, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};

        long actual = Main.countInversions(numbers);

        assertEquals(3L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n2 4 1 3 5\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "3" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCountMoreInversionsThanIntegerMaximum() {
        int size = 65_537;
        int[] numbers = new int[size];
        for (int index = 0; index < size; index++) {
            numbers[index] = size - index;
        }
        long expected = (long) size * (size - 1) / 2;

        long actual = Main.countInversions(numbers);

        assertEquals(expected, actual);
    }
}
