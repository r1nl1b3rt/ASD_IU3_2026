package ru.bmstu.lab01.task_40;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayOutput;
/**
 * Задача 40 — удалить дубликаты отсортированного массива на месте за O(n)
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int length = removeDuplicates(numbers);
        ArrayOutput.printPrefix(numbers, length);
    }
    /**
     * Записывает уникальные элементы в начало исходного массива
     * @param numbers - массив, отсортированный по неубыванию
     * @return - количество уникальных элементов
     */
    public static int removeDuplicates(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int length = 1;
        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] != numbers[length - 1]) {
                numbers[length++] = numbers[index];
            }
        }
        return length;
    }
}
