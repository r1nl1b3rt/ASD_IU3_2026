package ru.bmstu.lab01.task_23;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка перестановок массивов в задаче 23
 */
class MainTest {

    @Test
    void shouldRecognizePermutation() {
        int[] first = {4, -2, 9, 0};
        int[] second = {9, 0, -2, 4};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(true, actual);
    }

    @Test
    void shouldRecognizeIdenticalArrays() {
        int[] first = {1, 2, 3};
        int[] second = {1, 2, 3};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(true, actual);
    }

    @Test
    void shouldRecognizePermutationWithRepeatedElements() {
        int[] first = {1, 2, 1, 3};
        int[] second = {3, 1, 2, 1};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(true, actual);
    }

    @Test
    void shouldRejectDifferentValues() {
        int[] first = {1, 2, 3};
        int[] second = {1, 2, 4};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(false, actual);
    }

    @Test
    void shouldRejectDifferentOccurrenceCounts() {
        int[] first = {1, 1, 2};
        int[] second = {1, 2, 2};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(false, actual);
    }

    @Test
    void shouldRejectDifferentArraysWithEqualSum() {
        int[] first = {1, 4};
        int[] second = {2, 3};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(false, actual);
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] first = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        int[] second = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        boolean actual = Main.arePermutations(first, second);

        assertEquals(true, actual);
    }

    @Test
    void shouldPrintExpectedResult() {
        String input = "4\n4 -2 9 0\n4\n9 0 -2 4\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "YES" + System.lineSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void shouldPrintNoForDifferentArrays() {
        String input = "3\n1 1 2\n3\n1 2 2\n";

        String actual = ConsoleTestSupport.runProgram(input, () -> Main.main(new String[0]));

        String expected = "NO" + System.lineSeparator();
        assertEquals(expected, actual);
    }
}
