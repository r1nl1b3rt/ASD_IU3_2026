package ru.bmstu.lab01.task_42;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 42
 */
class MainTest {

    @Test
    void shouldInsertInMiddle() {
        int[] numbers = {1, 3, 5};
        int[] expected = {1, 3, 4, 5};

        int[] actual = Main.insertSorted(numbers, 4);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertBeforeFirstElement() {
        int[] numbers = {1, 3, 5};
        int[] expected = {-2, 1, 3, 5};

        int[] actual = Main.insertSorted(numbers, -2);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertAfterLastElement() {
        int[] numbers = {1, 3, 5};
        int[] expected = {1, 3, 5, 8};

        int[] actual = Main.insertSorted(numbers, 8);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertRepeatedValue() {
        int[] numbers = {1, 2, 2, 4};
        int[] expected = {1, 2, 2, 2, 4};

        int[] actual = Main.insertSorted(numbers, 2);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -4, -1};
        int[] expected = {-8, -5, -4, -1};

        int[] actual = Main.insertSorted(numbers, -5);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertMinimumInteger() {
        int[] numbers = {0, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};

        int[] actual = Main.insertSorted(numbers, Integer.MIN_VALUE);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldInsertIntoEmptyArray() {
        int[] numbers = {};
        int[] expected = {5};

        int[] actual = Main.insertSorted(numbers, 5);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 3 5\n4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 3 4 5" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
