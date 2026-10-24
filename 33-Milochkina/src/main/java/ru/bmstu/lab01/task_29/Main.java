package ru.bmstu.lab01.task_29;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 29 — найти наиболее частый элемент, при равенстве частот выбрать наименьший
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(mode(numbers));
    }
    /**
     * Находит моду с выбором наименьшего значения при равных частотах
     * @param numbers - непустой исходный массив
     * @return - мода массива
     */
    public static int mode(int[] numbers) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int result = numbers[0];
        int maximumFrequency = 0;
        for (int number : numbers) {
            int frequency = frequencies.merge(number, 1, Integer::sum);
            if (frequency > maximumFrequency || (frequency == maximumFrequency && number < result)) {
                result = number;
                maximumFrequency = frequency;
            }
        }
        return result;
    }
}
