package ru.bmstu.lab01.task_31;
import java.math.BigInteger;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 31 — найти точное скалярное произведение двух массивов одинаковой длины
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     *
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = ArrayIo.readArray(scanner);
        int[] second = ArrayIo.readArray(scanner);

        System.out.println(dotProduct(first, second));
    }
    /**
     * Суммирует произведения элементов с одинаковыми индексами
     * @param first - первый массив
     * @param second - второй массив той же длины
     * @return - точное скалярное произведение
     */
    public static BigInteger dotProduct(int[] first, int[] second) {
        BigInteger result = BigInteger.ZERO;
        for (int index = 0; index < first.length; index++) {
            long product = (long) first[index] * second[index];
            result = result.add(BigInteger.valueOf(product));
        }
        return result;
    }
}
