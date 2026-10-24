package ru.bmstu.lab01.task_10;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;

import org.junit.jupiter.api.Test;
/**
 * Проверяет поиск индекса последнего элемента, кратного делителю
 */
class MainTest {

    @Test
    void shouldReturnLastMatchingIndex() {
        int[] numbers = {6, 5, 9, 4, 7};

        assertEquals(2, Main.findLastMultipleIndex(numbers, 3));
    }

    @Test
    void shouldFindMatchAtLastPosition() {
        int[] numbers = {5, 6};

        assertEquals(1, Main.findLastMultipleIndex(numbers, 3));
    }

    @Test
    void shouldFindMatchAtFirstPosition() {
        int[] numbers = {6, 5, 7};

        assertEquals(0, Main.findLastMultipleIndex(numbers, 3));
    }

    @Test
    void shouldReturnMinusOneWhenNoElementMatches() {
        int[] numbers = {5, 7};

        assertEquals(-1, Main.findLastMultipleIndex(numbers, 3));
    }

    @Test
    void shouldTreatZeroAsMultipleOfNonzeroDivisor() {
        int[] numbers = {6, 0, 5};

        assertEquals(1, Main.findLastMultipleIndex(numbers, 3));
    }

    @Test
    void shouldHandleNegativeDivisorAndElements() {
        int[] numbers = {-6, 5, -9, 7};

        assertEquals(2, Main.findLastMultipleIndex(numbers, -3));
    }

    @Test
    void shouldReadInputAndPrintIndex() {
        String actual = runProgram("5\n6 5 9 4 7\n3\n", () -> Main.main(new String[0]));

        assertEquals("2" + System.lineSeparator(), actual);
    }
}
