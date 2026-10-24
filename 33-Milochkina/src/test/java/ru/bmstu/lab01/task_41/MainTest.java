package ru.bmstu.lab01.task_41;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 41
 */
class MainTest {

    @Test
    void shouldRemoveAllOccurrences() {
        int[] numbers = {2, 1, 2, 3, 2};
        int[] expected = {1, 3};

        int actualLength = Main.removeElement(numbers, 2);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldKeepArrayWithoutTarget() {
        int[] numbers = {1, 2, 3};
        int[] expected = {1, 2, 3};

        int actualLength = Main.removeElement(numbers, 7);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldRemoveEveryElement() {
        int[] numbers = {7, 7, 7};
        int[] expected = {};

        int actualLength = Main.removeElement(numbers, 7);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldRemoveTargetAtBothEnds() {
        int[] numbers = {2, 1, 3, 2};
        int[] expected = {1, 3};

        int actualLength = Main.removeElement(numbers, 2);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-2, 0, -2, -1};
        int[] expected = {0, -1};

        int actualLength = Main.removeElement(numbers, -2);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] expected = {Integer.MAX_VALUE};

        int actualLength = Main.removeElement(numbers, Integer.MIN_VALUE);

        assertEquals(expected.length, actualLength);
        assertArrayEquals(expected, Arrays.copyOf(numbers, actualLength));
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "5\n2 1 2 3 2\n2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "1 3" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintEmptyLineWhenAllElementsAreRemoved() {
        String actual = ConsoleTestSupport.runProgram("3\n7 7 7\n7\n", () -> Main.main(new String[0]));

        assertEquals(System.lineSeparator(), actual);
    }
}
