package ru.bmstu.lab01.task_45;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ru.bmstu.lab01.common.ConsoleTestSupport;
/**
 * Проверка решения задачи 45
 */
class MainTest {

    @Test
    void shouldPartitionMixedValues() {
        int[] numbers = {3, 1, 2, 3, 4, 0};
        int[] expectedValues = {0, 1, 2, 3, 3, 4};

        Main.partition(numbers, 3);

        assertPartitioned(numbers, 3, expectedValues);
    }

    @Test
    void shouldHandleOnlySmallerValues() {
        int[] numbers = {2, 0, -1};
        int[] expectedValues = {-1, 0, 2};

        Main.partition(numbers, 5);

        assertPartitioned(numbers, 5, expectedValues);
    }

    @Test
    void shouldHandleOnlyLargerValues() {
        int[] numbers = {5, 4, 3};
        int[] expectedValues = {3, 4, 5};

        Main.partition(numbers, 1);

        assertPartitioned(numbers, 1, expectedValues);
    }

    @Test
    void shouldHandleEqualValues() {
        int[] numbers = {7, 7, 7};
        int[] expectedValues = {7, 7, 7};

        Main.partition(numbers, 7);

        assertPartitioned(numbers, 7, expectedValues);
    }

    @Test
    void shouldHandleMissingPivot() {
        int[] numbers = {4, -2, 3, -1};
        int[] expectedValues = {-2, -1, 3, 4};

        Main.partition(numbers, 0);

        assertPartitioned(numbers, 0, expectedValues);
    }

    @Test
    void shouldHandleExtremeValues() {
        int[] numbers = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE};
        int[] expectedValues = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};

        Main.partition(numbers, 0);

        assertPartitioned(numbers, 0, expectedValues);
    }

    @Test
    void shouldPrintPartitionedArray() {
        String actual = ConsoleTestSupport.runProgram("6\n3 1 2 3 4 0\n3\n", () -> Main.main(new String[0]));
        int[] numbers = Arrays.stream(actual.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] expectedValues = {0, 1, 2, 3, 3, 4};

        assertPartitioned(numbers, 3, expectedValues);
    }

    private static void assertPartitioned(int[] numbers, int pivot, int[] expectedValues) {
        int[] actualValues = numbers.clone();
        Arrays.sort(actualValues);
        assertArrayEquals(expectedValues, actualValues);
        int previousGroup = 0;
        for (int number : numbers) {
            int group = Integer.compare(number, pivot) + 1;
            assertTrue(group >= previousGroup);
            previousGroup = group;
        }
    }
}
