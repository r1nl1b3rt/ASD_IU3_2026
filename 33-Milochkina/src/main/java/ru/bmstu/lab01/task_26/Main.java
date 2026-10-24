package ru.bmstu.lab01.task_26;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 26 — найти произведение элементов по модулю 10^9 + 7
 */
public class Main {

    private static final long MODULUS = 1_000_000_007L;
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(productModulo(numbers));
    }
    /**
     * Вычисляет произведение с неотрицательным остатком по модулю
     * @param numbers - исходный массив
     * @return - произведение по модулю 10^9 + 7
     */
    public static long productModulo(int[] numbers) {
        long result = 1;
        for (int number : numbers) {
            long normalized = Math.floorMod((long) number, MODULUS);
            result = result * normalized % MODULUS;
        }
        return result;
    }
}
