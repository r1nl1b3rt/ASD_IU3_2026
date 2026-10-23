package ru.bmstu.lab01.task_8;
import java.util.Arrays;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 8. Получить массивы положительных и отрицательных элементов
 * в исходном порядке, исключив нули.
 */
public class Main {
    /**
     * Выводит положительные элементы, затем отрицательные отдельной строкой
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int[][] groups = filterBySign(numbers);

        ArrayIo.printArray(groups[0]);
        ArrayIo.printArray(groups[1]);
    }
    /**
     * Разделяет элементы по знаку, сохраняя порядок
     * @param numbers - исходный массив
     * @return - два массива: положительные, затем отрицательные элементы
     */
    public static int[][] filterBySign(int[] numbers) {
        int[] positives = new int[numbers.length];
        int[] negatives = new int[numbers.length];
        int positiveCount = 0;
        int negativeCount = 0;

        for (int number : numbers) {
            if (number > 0) {
                positives[positiveCount] = number;
                positiveCount++;
            } else if (number < 0) {
                negatives[negativeCount] = number;
                negativeCount++;
            }
        }

        return new int[][] {
                Arrays.copyOf(positives, positiveCount),
                Arrays.copyOf(negatives, negativeCount)
        };
    }
}
