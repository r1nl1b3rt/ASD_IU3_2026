package ru.bmstu.lab01.task_14;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 14 — отсортировать массив по невозрастанию сортировкой вставками
 */
public class Main {
    /**
     * Считывает массив, сортирует и выводит результат
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        insertionSortDescending(numbers);
        ArrayIo.printArray(numbers);
    }
    /**
     * Сортирует исходный массив вставками от большего к меньшему
     * @param numbers - массив для сортировки
     */
    public static void insertionSortDescending(int[] numbers) {
        for (int index = 1; index < numbers.length; index++) {
            int current = numbers[index];
            int position = index - 1;

            while (position >= 0 && numbers[position] < current) {
                numbers[position + 1] = numbers[position];
                position--;
            }

            numbers[position + 1] = current;
        }
    }
}
