package ru.bmstu.lab01.task_35;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 35 — предвычислить префиксные суммы и отвечать на запросы диапазона за O(1)
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        long[] prefixSums = buildPrefixSums(numbers);
        int queryCount = scanner.nextInt();
        for (int query = 0; query < queryCount; query++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println(rangeSum(prefixSums, left, right));
        }
    }
    /**
     * Создаёт массив сумм с нулевой суммой перед первым элементом
     * @param numbers - исходный массив
     * @return - массив длины n + 1 с суммами первых i элементов
     */
    public static long[] buildPrefixSums(int[] numbers) {
        long[] prefixSums = new long[numbers.length + 1];
        for (int index = 0; index < numbers.length; index++) {
            prefixSums[index + 1] = prefixSums[index] + numbers[index];
        }
        return prefixSums;
    }
    /**
     * Находит сумму элементов диапазона с обеими включёнными границами
     * @param prefixSums - предварительно вычисленные префиксные суммы
     * @param left - индекс левой границы, начиная с нуля
     * @param right - индекс правой границы, начиная с нуля
     * @return - сумма элементов от left до right
     */
    public static long rangeSum(long[] prefixSums, int left, int right) {
        return prefixSums[right + 1] - prefixSums[left];
    }
}
