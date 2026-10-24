package ru.bmstu.lab01.task_27;
import java.math.BigInteger;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 27 — найти точную сумму квадратов всех элементов массива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(sumSquares(numbers));
    }
    /**
     * Вычисляет сумму квадратов без переполнения long
     * @param numbers - исходный массив
     * @return - точная сумма квадратов
     */
    public static BigInteger sumSquares(int[] numbers) {
        BigInteger result = BigInteger.ZERO;
        for (int number : numbers) {
            long square = (long) number * number;
            result = result.add(BigInteger.valueOf(square));
        }
        return result;
    }
}
