package ru.bmstu.lab01.task_17;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка сортировки по сумме цифр в задаче 17
 */
class MainTest {

    @Test
    void shouldSortByDigitSum() {
        int[] numbers = {99, 10, 123, 2, 0};
        int[] expected = {0, 10, 2, 123, 99};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPreserveOrderForEqualDigitSums() {
        int[] numbers = {21, 12, 30, 3, 102};
        int[] expected = {21, 12, 30, 3, 102};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPreserveTiesWhileSorting() {
        int[] numbers = {22, 21, 13, 12, 4, 30};
        int[] expected = {21, 12, 30, 22, 13, 4};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {10, 0, 1, 0};
        int[] expected = {0, 0, 10, 1};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepEqualElements() {
        int[] numbers = {77, 77, 77};
        int[] expected = {77, 77, 77};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleMaximumIntegerValue() {
        int[] numbers = {Integer.MAX_VALUE, 9, 1000000000, 0};
        int[] expected = {0, 1000000000, 9, Integer.MAX_VALUE};

        int[] actual = Main.sortByDigitSum(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "6\n22 21 13 12 4 30\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "21 12 30 22 13 4" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
