package ru.bmstu.lab01.task_34;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 34 — за O(n) найти максимальную сумму непустого непрерывного подмассива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(maxSubarraySum(numbers));
    }
    /**
     * Находит максимальную сумму непустого подмассива алгоритмом Кадане
     * @param numbers - непустой исходный массив
     * @return - максимальная сумма непрерывного подмассива
     */
    public static long maxSubarraySum(int[] numbers) {
        long currentSum = numbers[0];
        long maximumSum = numbers[0];
        for (int index = 1; index < numbers.length; index++) {
            // Продолжаем прежний подмассив или начинаем новый с текущего элемента
            currentSum = Math.max(numbers[index], currentSum + numbers[index]);
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
