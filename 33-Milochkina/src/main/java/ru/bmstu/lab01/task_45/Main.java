package ru.bmstu.lab01.task_45;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayTransforms;
/**
 * Задача 45 — разбить массив на группы меньше, равно и больше опорного элемента за O(n) на месте
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int pivot = scanner.nextInt();
        partition(numbers, pivot);
        ArrayIo.printArray(numbers);
    }
    /**
     * Разбивает массив алгоритмом трёхцветного флага с O(1) дополнительной памяти
     * @param numbers - изменяемый массив
     * @param pivot - опорное значение
     */
    public static void partition(int[] numbers, int pivot) {
        int lower = 0;
        int current = 0;
        int upper = numbers.length - 1;
        while (current <= upper) {
            if (numbers[current] < pivot) {
                ArrayTransforms.swap(numbers, lower++, current++);
            } else if (numbers[current] > pivot) {
                // Пришедший справа элемент ещё не обработан, поэтому current не увеличивается
                ArrayTransforms.swap(numbers, current, upper--);
            } else {
                current++;
            }
        }
    }
}
