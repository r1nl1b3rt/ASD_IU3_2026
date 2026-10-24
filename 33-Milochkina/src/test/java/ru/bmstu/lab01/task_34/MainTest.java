package ru.bmstu.lab01.task_34;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 34
 */
class MainTest {

    @Test
    void shouldFindMaximumInsideArray() {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(6L, actual);
    }

    @Test
    void shouldChooseLargestNegativeElement() {
        int[] numbers = {-8, -3, -12, -5};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(-3L, actual);
    }

    @Test
    void shouldSumAllPositiveElements() {
        int[] numbers = {1, 2, 3, 4};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(10L, actual);
    }

    @Test
    void shouldHandleZeroValues() {
        int[] numbers = {-2, 0, -1, 0};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(0L, actual);
    }

    @Test
    void shouldFindMaximumAtBeginning() {
        int[] numbers = {5, 4, -20, 1};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(9L, actual);
    }

    @Test
    void shouldFindMaximumAtEnd() {
        int[] numbers = {-20, 1, 2, 3};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(6L, actual);
    }

    @Test
    void shouldReturnValueLargerThanIntegerMaximum() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(4294967294L, actual);
    }

    @Test
    void shouldHandleMinimumIntegerValue() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MIN_VALUE};

        long actual = Main.maxSubarraySum(numbers);

        assertEquals(-2147483648L, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "9\n-2 1 -3 4 -1 2 1 -5 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "6" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
