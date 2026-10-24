package ru.bmstu.lab01.task_20;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 20 — сортировка массива целых чисел по неубыванию методом подсчёта
 */
public class Main {
    /**
     * Считывает массив, сортирует его и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        countingSort(numbers);

        ArrayIo.printArray(numbers);
    }
    /**
     * Сортирует массив по неубыванию методом подсчёта
     * @param numbers - массив для сортировки
     */
    public static void countingSort(int[] numbers) {
        if (numbers.length == 0) {
            return;
        }

        int minimum = numbers[0];
        int maximum = numbers[0];
        for (int number : numbers) {
            minimum = Math.min(minimum, number);
            maximum = Math.max(maximum, number);
        }

        long range = (long) maximum - minimum + 1;
        if (range > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Диапазон значений слишком велик для массива счётчиков");
        }

        int[] counts = new int[(int) range];
        for (int number : numbers) {
            counts[number - minimum]++;
        }

        int index = 0;
        for (int offset = 0; offset < counts.length; offset++) {
            for (int occurrence = 0; occurrence < counts[offset]; occurrence++) {
                numbers[index++] = minimum + offset;
            }
        }
    }
}
