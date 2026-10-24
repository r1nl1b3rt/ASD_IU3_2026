package ru.bmstu.lab01.task_30;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 30 — найти выборочную дисперсию с делением суммы квадратов отклонений на n
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(variance(numbers));
    }
    /**
     * Вычисляет выборочную дисперсию с делением на размер массива
     * @param numbers - непустой исходный массив
     * @return - средний квадрат отклонения от среднего
     */
    public static double variance(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = (double) sum / numbers.length;
        double squaredDeviations = 0;
        // Два прохода позволяют не вычитать близкие большие суммы квадратов
        for (int number : numbers) {
            double deviation = number - average;
            squaredDeviations += deviation * deviation;
        }
        return squaredDeviations / numbers.length;
    }
}
