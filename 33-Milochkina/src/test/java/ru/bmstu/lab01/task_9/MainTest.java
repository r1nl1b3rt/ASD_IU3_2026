package ru.bmstu.lab01.task_9;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;
/**
 * Проверяет неубывающий порядок элементов массива
 */
class MainTest {

    @Test
    void shouldAcceptIncreasingArray() {
        assertTrue(Main.isNonDecreasing(new int[] {-3, 0, 2, 9}));
    }

    @Test
    void shouldAcceptEqualNeighbors() {
        assertTrue(Main.isNonDecreasing(new int[] {1, 2, 2, 5}));
    }

    @Test
    void shouldAcceptAllEqualElements() {
        assertTrue(Main.isNonDecreasing(new int[] {7, 7}));
    }

    @Test
    void shouldRejectDecreaseAtBeginning() {
        assertFalse(Main.isNonDecreasing(new int[] {3, 1, 5}));
    }

    @Test
    void shouldRejectDecreaseAtEnd() {
        assertFalse(Main.isNonDecreasing(new int[] {1, 5, 4}));
    }

    @Test
    void shouldPrintYesForNonDecreasingArray() {
        String actual = runProgram(
                "4\n1 2 2 5\n",
                () -> Main.main(new String[0]));

        assertEquals("YES" + System.lineSeparator(), actual);
    }

    @Test
    void shouldPrintNoForUnsortedArray() {
        String actual = runProgram(
                "3\n1 5 4\n",
                () -> Main.main(new String[0]));

        assertEquals("NO" + System.lineSeparator(), actual);
    }
}
