package ru.bmstu.lab01.task_5;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;

import org.junit.jupiter.api.Test;
/**
 * Проверяет сумму элементов с чётными индексами
 */
class MainTest {

    @Test
    void shouldSumElementsAtEvenIndices() {
        int[] numbers = {4, 7, 2, 7, 9};

        assertEquals(15L, Main.sumAtEvenIndices(numbers));
    }

    @Test
    void shouldHandleEvenLengthArray() {
        int[] numbers = {3, 100, -5, 200};

        assertEquals(-2L, Main.sumAtEvenIndices(numbers));
    }

    @Test
    void shouldHandleTwoElements() {
        int[] numbers = {-8, 99};

        assertEquals(-8L, Main.sumAtEvenIndices(numbers));
    }

    @Test
    void shouldAvoidIntegerOverflow() {
        int[] numbers = {Integer.MAX_VALUE, 0, Integer.MAX_VALUE};

        assertEquals(4294967294L, Main.sumAtEvenIndices(numbers));
    }

    @Test
    void shouldReadInputAndPrintSum() {
        String actual = runProgram("5\n4 7 2 7 9\n", () -> Main.main(new String[0]));

        assertEquals("15" + System.lineSeparator(), actual);
    }
}
