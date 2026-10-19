package ru.bmstu.lab01.task_3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Проверяет подсчёт вхождений числа в задаче 3
 */
class MainTest {

    @Test
    void shouldCountSeveralOccurrences() {
        int[] numbers = {4, 7, 2, 7, 9};

        int actual = Main.countOccurrences(numbers, 7);

        assertEquals(2, actual);
    }

    @Test
    void shouldReturnZeroWhenTargetIsAbsent() {
        int[] numbers = {4, 7, 9};

        int actual = Main.countOccurrences(numbers, 2);

        assertEquals(0, actual);
    }

    @Test
    void shouldCountAllElementsWhenAllMatch() {
        int[] numbers = {7, 7, 7};

        int actual = Main.countOccurrences(numbers, 7);

        assertEquals(3, actual);
    }

    @Test
    void shouldCountNegativeValues() {
        int[] numbers = {-3, 5, -3, 0};

        int actual = Main.countOccurrences(numbers, -3);

        assertEquals(2, actual);
    }

    @Test
    void shouldCountZerosInTwoElementArray() {
        int[] numbers = {0, 0};

        int actual = Main.countOccurrences(numbers, 0);

        assertEquals(2, actual);
    }

    @Test
    void shouldReadInputAndPrintOccurrenceCount() {
        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;
        String input = "5\n4 7 2 7 9\n7\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOutput =
                     new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(testOutput);

            Main.main(new String[0]);

            String expected = "2" + System.lineSeparator();
            String actual = output.toString(StandardCharsets.UTF_8);
            assertEquals(expected, actual);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}
