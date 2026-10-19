package ru.bmstu.lab01.task_2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Проверка поиска индекса первого вхождения в задаче 2
 */
class MainTest {

    @Test
    void shouldReturnFirstIndexWhenTargetOccursSeveralTimes() {
        int[] numbers = {4, 7, 2, 7, 9};

        int actual = Main.findFirstIndex(numbers, 7);

        assertEquals(1, actual);
    }

    @Test
    void shouldReturnZeroWhenTargetIsFirst() {
        int[] numbers = {-3, 5, 8};

        int actual = Main.findFirstIndex(numbers, -3);

        assertEquals(0, actual);
    }

    @Test
    void shouldReturnLastIndexWhenTargetIsLast() {
        int[] numbers = {4, 7, 9};

        int actual = Main.findFirstIndex(numbers, 9);

        assertEquals(2, actual);
    }

    @Test
    void shouldReturnMinusOneWhenTargetIsAbsent() {
        int[] numbers = {4, 7, 9};

        int actual = Main.findFirstIndex(numbers, 2);

        assertEquals(-1, actual);
    }

    @Test
    void shouldHandleTwoEqualElements() {
        int[] numbers = {7, 7};

        int actual = Main.findFirstIndex(numbers, 7);

        assertEquals(0, actual);
    }

    @Test
    void shouldReadInputAndPrintFirstIndex() {
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

            String expected = "1" + System.lineSeparator();
            String actual = output.toString(StandardCharsets.UTF_8);
            assertEquals(expected, actual);
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }
}