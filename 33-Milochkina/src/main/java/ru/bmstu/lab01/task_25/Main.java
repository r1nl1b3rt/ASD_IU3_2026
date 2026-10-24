package ru.bmstu.lab01.task_25;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 25 — найти сумму всех элементов целочисленного массива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(sum(numbers));
    }
    /**
     * Вычисляет сумму элементов без переполнения int
     * @param numbers - исходный массив
     * @return - сумма всех элементов
     */
    public static long sum(int[] numbers) {
        long result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
