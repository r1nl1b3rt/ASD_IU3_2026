package ru.bmstu.lab01.task_58;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 58
 */
class MainTest {

    @Test
    void shouldFillRectangularMatrix() {
        long[][] expected = {{1L, 2L, 3L, 4L}, {8L, 7L, 6L, 5L}, {9L, 10L, 11L, 12L}};

        long[][] actual = Main.fillSnake(3, 4);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillSquareMatrix() {
        long[][] expected = {{1L, 2L, 3L}, {6L, 5L, 4L}, {7L, 8L, 9L}};

        long[][] actual = Main.fillSnake(3, 3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillSingleRow() {
        long[][] expected = {{1L, 2L, 3L, 4L}};

        long[][] actual = Main.fillSnake(1, 4);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillSingleColumn() {
        long[][] expected = {{1L}, {2L}, {3L}, {4L}};

        long[][] actual = Main.fillSnake(4, 1);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillSingleElement() {
        long[][] expected = {{1L}};

        long[][] actual = Main.fillSnake(1, 1);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFillTwoByTwoMatrix() {
        long[][] expected = {{1L, 2L}, {4L, 3L}};

        long[][] actual = Main.fillSnake(2, 2);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "3 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = String.join(System.lineSeparator(), "1 2 3 4", "8 7 6 5", "9 10 11 12")
                + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
