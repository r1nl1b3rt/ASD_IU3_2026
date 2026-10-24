package ru.bmstu.lab01.task_6;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;

import org.junit.jupiter.api.Test;
/**
 * Проверяет подсчёт элементов, строго больших среднего
 */
class MainTest {

    @Test
    void shouldCountElementsStrictlyAboveAverage() {
        int[] numbers = {1, 2, 3, 6};

        assertEquals(1, Main.countAboveAverage(numbers));
    }

    @Test
    void shouldReturnZeroWhenAllElementsAreEqual() {
        int[] numbers = {7, 7, 7};

        assertEquals(0, Main.countAboveAverage(numbers));
    }

    @Test
    void shouldHandleNegativeAverage() {
        int[] numbers = {-8, -4, -3};

        assertEquals(2, Main.countAboveAverage(numbers));
    }

    @Test
    void shouldHandleZeroAverage() {
        int[] numbers = {-6, -2, 2, 6};

        assertEquals(2, Main.countAboveAverage(numbers));
    }

    @Test
    void shouldAvoidOverflowWhenCalculatingSum() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        assertEquals(0, Main.countAboveAverage(numbers));
    }

    @Test
    void shouldReadInputAndPrintCount() {
        String actual = runProgram("4\n1 2 3 6\n", () -> Main.main(new String[0]));

        assertEquals("1" + System.lineSeparator(), actual);
    }
}
