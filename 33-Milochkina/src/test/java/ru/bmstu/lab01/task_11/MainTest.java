package ru.bmstu.lab01.task_11;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bmstu.lab01.common.ConsoleTestSupport.runProgram;
/**
 * Проверяет поиск элемента, ближайшего к среднему арифметическому
 */
class MainTest {

    @Test
    void shouldFindClosestElementToFractionalAverage() {
        int[] numbers = {1, 2, 3, 8};

        assertEquals(3, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldKeepFirstElementWhenDistancesAreEqual() {
        int[] numbers = {8, 2};

        assertEquals(8, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldReturnElementEqualToAverage() {
        int[] numbers = {1, 3, 5};

        assertEquals(3, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldHandleNegativeValues() {
        int[] numbers = {-8, -3, -1};

        assertEquals(-3, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldHandleEqualElements() {
        int[] numbers = {7, 7, 7};

        assertEquals(7, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldHandleExtremeIntegerValues() {
        int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};

        assertEquals(0, Main.findClosestToAverage(numbers));
    }

    @Test
    void shouldReadInputAndPrintClosestElement() {
        String actual = runProgram(
                "4\n1 2 3 8\n",
                () -> Main.main(new String[0]));

        assertEquals("3" + System.lineSeparator(), actual);
    }
}