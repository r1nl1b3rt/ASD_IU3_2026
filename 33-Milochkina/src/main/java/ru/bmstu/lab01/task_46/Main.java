package ru.bmstu.lab01.task_46;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 46 — заменить каждый элемент его рангом в отсортированном наборе уникальных значений
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(compressCoordinates(numbers));
    }
    /**
     * Выполняет сжатие координат с рангами начиная с нуля
     * @param numbers - исходный массив
     * @return - массив рангов исходных элементов
     */
    public static int[] compressCoordinates(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        for (int number : sorted) {
            if (!ranks.containsKey(number)) {
                ranks.put(number, ranks.size());
            }
        }
        int[] result = new int[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            result[index] = ranks.get(numbers[index]);
        }
        return result;
    }
}
