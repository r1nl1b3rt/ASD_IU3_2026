package ru.bmstu.lab01.task_1;
import java.util.Scanner;

/**
 * Задача 1. Найти максимальный и минимальный элементы массива из n целых чисел.
 */
public class Main {
    /**
     * Функция, считывающая размер и элементы массива, выводит минимум и максимум
     * @param args аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int index = 0; index < size; index++) {
            numbers[index] = scanner.nextInt();
        }

        int[] result = findMinMax(numbers);
        System.out.println(result[0] + " " + result[1]);
    }
    /**
     * Находит минимум и максимум непустого массива
     * @param numbers - массив целых чисел
     * @return - возвращает массив из двух значений: сначала минимум, потом максимум
     */
    public static int[] findMinMax(int[] numbers) {
        int minimum = numbers[0];
        int maximum = numbers[0];

        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] < minimum) {
                minimum = numbers[index];
            }
            if (numbers[index] > maximum) {
                maximum = numbers[index];
            }
        }

        return new int[]{minimum, maximum};
    }
}
