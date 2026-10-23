package ru.bmstu.lab01.task_7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;
/**
 * Проверяет поиск второго максимума
 */
class MainTest {

    @Test
    void shouldFindSecondMaximumInMixedOrder() {
        int[] numbers = {4, 7, 2, 10, 9};

        assertEquals(9, Main.findSecondMaximum(numbers));
    }

    @Test
    void shouldHandleAscendingArray() {
        int[] numbers = {1, 2, 3, 4};

        assertEquals(3, Main.findSecondMaximum(numbers));
    }

    @Test
    void shouldHandleDescendingArray() {
        int[] numbers = {9, 7, 4, 1};

        assertEquals(7, Main.findSecondMaximum(numbers));
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -12, -5};

        assertEquals(-5, Main.findSecondMaximum(numbers));
    }

    @Test
    void shouldHandleTwoSmallestIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};

        assertEquals(Integer.MIN_VALUE, Main.findSecondMaximum(numbers));
    }

    @Test
    void shouldReadInputAndPrintSecondMaximum() {
        String actual = runProgram(
                "5\n4 7 2 10 9\n",
                () -> Main.main(new String[0]));

        assertEquals("9" + System.lineSeparator(), actual);
    }
}
