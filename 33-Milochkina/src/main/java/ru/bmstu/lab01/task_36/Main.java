package ru.bmstu.lab01.task_36;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 36 — построить массив сумм первых i + 1 элементов
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        long[] result = runningSums(numbers);
        StringBuilder output = new StringBuilder();
        for (int index = 0; index < result.length; index++) {
            if (index > 0) {
                output.append(' ');
            }
            output.append(result[index]);
        }
        System.out.println(output);
    }
    /**
     * Вычисляет накопленную сумму для каждого элемента исходного массива
     * @param numbers - исходный массив
     * @return - массив сумм первых i + 1 элементов
     */
    public static long[] runningSums(int[] numbers) {
        long[] result = new long[numbers.length];
        long sum = 0;
        for (int index = 0; index < numbers.length; index++) {
            sum += numbers[index];
            result[index] = sum;
        }
        return result;
    }
}
