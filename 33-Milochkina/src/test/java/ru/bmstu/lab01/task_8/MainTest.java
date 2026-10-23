package ru.bmstu.lab01.task_8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;
/**
 * Проверяет разделение элементов по знаку с сохранением порядка
 */
class MainTest {

    @Test
    void shouldPreserveOrderAndExcludeZeros() {
        int[] numbers = {4, -2, 0, 7, -9, 0};

        int[][] actual = Main.filterBySign(numbers);

        assertEquals(2, actual.length);
        assertArrayEquals(new int[] {4, 7}, actual[0]);
        assertArrayEquals(new int[] {-2, -9}, actual[1]);
    }

    @Test
    void shouldHandleOnlyPositiveElements() {
        int[][] actual = Main.filterBySign(new int[] {8, 2, 5});

        assertArrayEquals(new int[] {8, 2, 5}, actual[0]);
        assertArrayEquals(new int[0], actual[1]);
    }

    @Test
    void shouldHandleOnlyNegativeElements() {
        int[][] actual = Main.filterBySign(new int[] {-8, -2});

        assertArrayEquals(new int[0], actual[0]);
        assertArrayEquals(new int[] {-8, -2}, actual[1]);
    }

    @Test
    void shouldReturnEmptyGroupsForZeros() {
        int[][] actual = Main.filterBySign(new int[] {0, 0});

        assertArrayEquals(new int[0], actual[0]);
        assertArrayEquals(new int[0], actual[1]);
    }

    @Test
    void shouldPrintGroupsOnSeparateLines() {
        String actual = runProgram(
                "6\n4 -2 0 7 -9 0\n",
                () -> Main.main(new String[0]));
        String expected = "4 7" + System.lineSeparator()
                + "-2 -9" + System.lineSeparator();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintEmptyLinesForEmptyGroups() {
        String actual = runProgram(
                "2\n0 0\n",
                () -> Main.main(new String[0]));
        String expected = System.lineSeparator() + System.lineSeparator();

        assertEquals(expected, actual);
    }
}
