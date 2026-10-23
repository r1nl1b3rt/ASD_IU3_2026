package ru.bmstu.lab01.task_4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Проверяет поиск всех индексов заданного числа в задаче 4.
 */
class MainTest {

    @Test
    void shouldReturnAllMatchingIndicesInAscendingOrder() {
        int[] numbers = {4, 7, 2, 7, 9};
        int[] expected = {1, 3};

        int[] actual = Main.findAllIndices(numbers, 7);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWhenTargetIsAbsent() {
        int[] numbers = {4, 7, 9};
        int[] expected = {};

        int[] actual = Main.findAllIndices(numbers, 2);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEveryIndexWhenAllElementsMatch() {
        int[] numbers = {7, 7, 7};
        int[] expected = {0, 1, 2};

        int[] actual = Main.findAllIndices(numbers, 7);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindMatchesAtBothEnds() {
        int[] numbers = {-3, 5, 0, -3};
        int[] expected = {0, 3};

        int[] actual = Main.findAllIndices(numbers, -3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindZeroInTwoElementArray() {
        int[] numbers = {5, 0};
        int[] expected = {1};

        int[] actual = Main.findAllIndices(numbers, 0);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReadInputAndPrintMatchingIndices() {
        String actual = runProgram("5\n4 7 2 7 9\n7\n");
        String expected = "1 3" + System.lineSeparator();

        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintEmptyLineWhenTargetIsAbsent() {
        String actual = runProgram("3\n4 7 9\n2\n");
        String expected = System.lineSeparator();

        assertEquals(expected, actual);
    }

    private String runProgram(String input) {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOutput =
                     new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(testOutput);

            Main.main(new String[0]);

            return output.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
