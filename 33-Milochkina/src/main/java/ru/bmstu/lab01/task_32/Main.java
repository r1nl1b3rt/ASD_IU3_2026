package ru.bmstu.lab01.task_32;
import java.math.BigInteger;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 32 — за O(n) найти сумму произведений всех пар элементов с индексами i < j
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(sumPairProducts(numbers));
    }
    /**
     * Считает сумму произведений пар через сумму предыдущих элементов
     * @param numbers - исходный массив
     * @return - точная сумма произведений всех пар с индексами i < j
     */
    public static BigInteger sumPairProducts(int[] numbers) {
        long prefixSum = 0;
        BigInteger result = BigInteger.ZERO;
        for (int number : numbers) {
            // Каждый элемент образует пару со всеми предыдущими элементами
            BigInteger contribution = BigInteger.valueOf(prefixSum).multiply(BigInteger.valueOf(number));
            result = result.add(contribution);
            prefixSum += number;
        }
        return result;
    }
}
