package ru.bmstu.lab01.task_12;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;
/**
 * Проверяет поиск пары с заданной суммой и выбор наименьших индексов
 */
class MainTest {

    @Test
    void shouldPreferSmallestFirstIndex() {
        int[] numbers = {1, 2, 3, 4};

        int[] actual = Main.findPairIndices(numbers, 5);

        assertArrayEquals(new int[] {0, 3}, actual);
    }

    @Test
    void shouldPreferSmallestSecondIndexForSameFirstIndex() {
        int[] numbers = {1, 4, 4};

        int[] actual = Main.findPairIndices(numbers, 5);

        assertArrayEquals(new int[] {0, 1}, actual);
    }

    @Test
    void shouldUseTwoDifferentIndicesForEqualValues() {
        int[] numbers = {2, 2};

        int[] actual = Main.findPairIndices(numbers, 4);

        assertArrayEquals(new int[] {0, 1}, actual);
    }

    @Test
    void shouldNotReuseOneElementTwice() {
        int[] numbers = {2, 7};

        int[] actual = Main.findPairIndices(numbers, 4);

        assertArrayEquals(new int[] {-1, -1}, actual);
    }

    @Test
    void shouldHandleNegativeValuesAndZeroSum() {
        int[] numbers = {-3, 8, 3, 0};

        int[] actual = Main.findPairIndices(numbers, 0);

        assertArrayEquals(new int[] {0, 2}, actual);
    }

    @Test
    void shouldAvoidFalseMatchCausedByIntegerOverflow() {
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        int[] actual = Main.findPairIndices(numbers, -2);

        assertArrayEquals(new int[] {-1, -1}, actual);
    }

    @Test
    void shouldReadInputAndPrintPairIndices() {
        String actual = runProgram(
                "5\n1 4 2 3 4\n5\n",
                () -> Main.main(new String[0]));

        assertEquals("0 1" + System.lineSeparator(), actual);
    }

    @Test
    void shouldPrintMinusOnePairWhenNoSolutionExists() {
        String actual = runProgram(
                "3\n1 2 3\n10\n",
                () -> Main.main(new String[0]));

        assertEquals("-1 -1" + System.lineSeparator(), actual);
    }
}
