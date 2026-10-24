package ru.bmstu.lab01.task_21;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка поиска k-го наименьшего элемента в задаче 21
 */
class MainTest {

    @Test
    void shouldFindMiddleElement() {
        int[] numbers = {9, -2, 4, 0, 7};

        int actual = Main.findKthSmallest(numbers, 3);

        assertEquals(4, actual);
    }

    @Test
    void shouldFindMinimum() {
        int[] numbers = {9, -2, 4, 0, 7};

        int actual = Main.findKthSmallest(numbers, 1);

        assertEquals(-2, actual);
    }

    @Test
    void shouldFindMaximum() {
        int[] numbers = {9, -2, 4, 0, 7};

        int actual = Main.findKthSmallest(numbers, 5);

        assertEquals(9, actual);
    }

    @Test
    void shouldCountRepeatedElementsSeparately() {
        int[] numbers = {3, 1, 1, 2};

        int actual = Main.findKthSmallest(numbers, 2);

        assertEquals(1, actual);
    }

    @Test
    void shouldHandleEqualElements() {
        int[] numbers = {7, 7, 7};

        int actual = Main.findKthSmallest(numbers, 2);

        assertEquals(7, actual);
    }

    @Test
    void shouldHandleNegativeArray() {
        int[] numbers = {-3, -8, -1, -5};

        int actual = Main.findKthSmallest(numbers, 2);

        assertEquals(-5, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int actual = Main.findKthSmallest(numbers, 2);

        assertEquals(0, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n9 -2 4 0 7\n3\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "4" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
