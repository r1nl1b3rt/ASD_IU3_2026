package ru.bmstu.lab01.task_28;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 28 — найти медиану массива после сортировки
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(median(numbers));
    }
    /**
     * Находит центральный элемент или среднее двух центральных элементов
     * @param numbers - непустой исходный массив
     * @return - медиана массива
     */
    public static double median(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        int middle = sorted.length / 2;
        if (sorted.length % 2 != 0) {
            return sorted[middle];
        }
        return ((long) sorted[middle - 1] + sorted[middle]) / 2.0;
    }
}
