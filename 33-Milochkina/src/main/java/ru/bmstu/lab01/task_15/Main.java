package ru.bmstu.lab01.task_15;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 15 — выполнить пузырьковую сортировку с подсчётом обменов
 * и досрочным выходом при отсутствии обменов
 */
public class Main {
    /**
     * Выводит отсортированный массив и количество обменов
     *
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        long swaps = bubbleSortAndCount(numbers);
        ArrayIo.printArray(numbers);
        System.out.println(swaps);
    }

    /**
     * Сортирует массив по неубыванию и подсчитывает обмены
     *
     * @param numbers - массив для сортировки
     * @return - количество выполненных обменов
     */
    public static long bubbleSortAndCount(int[] numbers) {
        long swaps = 0;

        for (int end = numbers.length - 1; end > 0; end--) {
            boolean changed = false;

            for (int index = 0; index < end; index++) {
                if (numbers[index] > numbers[index + 1]) {
                    int temporary = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = temporary;
                    swaps++;
                    changed = true;
                }
            }

            if (!changed) {
                break;
            }
        }
        return swaps;
    }
}
