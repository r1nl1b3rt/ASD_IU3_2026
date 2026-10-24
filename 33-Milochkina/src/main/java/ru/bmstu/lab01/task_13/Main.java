package ru.bmstu.lab01.task_13;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 13 — отсортировать массив по неубыванию сортировкой выбором
 */
public class Main {
    /**
     * Считывает массив, сортирует и выводит результат
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        selectionSort(numbers);
        ArrayIo.printArray(numbers);
    }
    /**
     * Сортирует исходный массив выбором минимального элемента
     * @param numbers - массив для сортировки
     */
    public static void selectionSort(int[] numbers) {
        for (int start = 0; start < numbers.length - 1; start++) {
            int minimumIndex = start;

            for (int index = start + 1; index < numbers.length; index++) {
                if (numbers[index] < numbers[minimumIndex]) {
                    minimumIndex = index;
                }
            }

            int temporary = numbers[start];
            numbers[start] = numbers[minimumIndex];
            numbers[minimumIndex] = temporary;
        }
    }
}
