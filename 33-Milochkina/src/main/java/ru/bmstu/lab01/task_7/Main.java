package ru.bmstu.lab01.task_7;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 7. Найти второй по величине элемент массива.
 * По условию все элементы различны.
 */
public class Main {

    /**
     * Считывает массив и выводит второй максимум
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(findSecondMaximum(numbers));
    }
    /**
     * Находит второй по величине элемент
     * @param numbers - массив минимум из двух различных элементов
     * @return - второй максимум
     */
    public static int findSecondMaximum(int[] numbers) {
        int maximum = Math.max(numbers[0], numbers[1]);
        int secondMaximum = Math.min(numbers[0], numbers[1]);

        for (int index = 2; index < numbers.length; index++) {
            int current = numbers[index];

            if (current > maximum) {
                secondMaximum = maximum;
                maximum = current;
            } else if (current > secondMaximum) {
                secondMaximum = current;
            }
        }

        return secondMaximum;
    }
}
