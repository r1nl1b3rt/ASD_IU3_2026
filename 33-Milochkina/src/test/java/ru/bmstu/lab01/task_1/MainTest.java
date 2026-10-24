package ru.bmstu.lab01.task_1;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
/**
 * Проверка нахождения минимального и максимального элементов в задаче 1
 */
class MainTest {

    @Test
    void shouldFindMinAndMaxInMixedArray() {
        int[] numbers = {4, -2, 9, 0, 7};
        int[] expected = {-2, 9};

        int[] actual = Main.findMinMax(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindMinAndMaxInNegativeArray() {
        int[] numbers = {-8, -3, -12, -5};
        int[] expected = {-12, -3};

        int[] actual = Main.findMinMax(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEqualMinAndMaxWhenAllElementsAreEqual() {
        int[] numbers = {7, 7, 7};
        int[] expected = {7, 7};

        int[] actual = Main.findMinMax(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleTwoElementsInDescendingOrder() {
        int[] numbers = {9, -2};
        int[] expected = {-2, 9};

        int[] actual = Main.findMinMax(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int[] expected = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        int[] actual = Main.findMinMax(numbers);

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldReadArrayAndPrintMinAndMax() {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        String input = "5\n4 -2 9 0 7\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOutput = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(testOutput);

            Main.main(new String[0]);

            String expected = "-2 9" + System.lineSeparator();
            String actual = output.toString(StandardCharsets.UTF_8);
            assertEquals(expected, actual);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
