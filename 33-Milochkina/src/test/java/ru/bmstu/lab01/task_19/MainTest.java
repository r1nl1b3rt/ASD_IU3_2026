package ru.bmstu.lab01.task_19;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка слияния отсортированных массивов в задаче 19
 */
class MainTest {

    @Test
    void shouldMergeInterleavedArrays() {
        int[] first = {1, 3, 5};
        int[] second = {2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAppendRemainingFirstElements() {
        int[] first = {1, 5, 7, 9};
        int[] second = {2, 3};
        int[] expected = {1, 2, 3, 5, 7, 9};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAppendRemainingSecondElements() {
        int[] first = {1, 2};
        int[] second = {3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldKeepRepeatedElements() {
        int[] first = {1, 2, 2};
        int[] second = {1, 2, 3};
        int[] expected = {1, 1, 2, 2, 2, 3};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMergeNegativeArrays() {
        int[] first = {-9, -3};
        int[] second = {-8, -5, -1};
        int[] expected = {-9, -8, -5, -3, -1};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] first = {Integer.MIN_VALUE, 0};
        int[] second = {-1, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE};

        int[] actual = Main.mergeSorted(first, second);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3\n1 3 5\n3\n2 4 6\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 2 3 4 5 6" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
