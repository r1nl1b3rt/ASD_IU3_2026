package ru.bmstu.lab01.task_29;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 29
 */
class MainTest {

    @Test
    void shouldFindMostFrequentValue() {
        int[] numbers = {3, 1, 3, 2, 3, 2};

        int actual = Main.mode(numbers);

        assertEquals(3, actual);
    }

    @Test
    void shouldChooseSmallestValueWhenFrequenciesAreEqual() {
        int[] numbers = {5, 2, 5, 2};

        int actual = Main.mode(numbers);

        assertEquals(2, actual);
    }

    @Test
    void shouldChooseMinimumWhenAllValuesAreDistinct() {
        int[] numbers = {8, -3, 5, 0};

        int actual = Main.mode(numbers);

        assertEquals(-3, actual);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};

        int actual = Main.mode(numbers);

        assertEquals(7, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-1, -3, -1, -3, -2};

        int actual = Main.mode(numbers);

        assertEquals(-3, actual);
    }

    @Test
    void shouldHandleSingleElement() {
        int[] numbers = {42};

        int actual = Main.mode(numbers);

        assertEquals(42, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int actual = Main.mode(numbers);

        assertEquals(Integer.MIN_VALUE, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n5 2 5 2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "2" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
