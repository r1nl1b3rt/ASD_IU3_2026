package ru.bmstu.lab01.task_42;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 42 — вставить элемент в отсортированный массив, найдя позицию бинарным поиском
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int value = scanner.nextInt();
        ArrayIo.printArray(insertSorted(numbers, value));
    }
    /**
     * Создаёт массив со вставленным на правильную позицию элементом
     * @param numbers - массив, отсортированный по неубыванию
     * @param value - вставляемое значение
     * @return - отсортированный массив длины n + 1
     */
    public static int[] insertSorted(int[] numbers, int value) {
        int position = findInsertionPosition(numbers, value);
        int[] result = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, result, 0, position);
        result[position] = value;
        System.arraycopy(numbers, position, result, position + 1, numbers.length - position);
        return result;
    }

    private static int findInsertionPosition(int[] numbers, int value) {
        int left = 0;
        int right = numbers.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < value) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
