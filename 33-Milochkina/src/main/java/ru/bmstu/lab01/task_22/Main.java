package ru.bmstu.lab01.task_22;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 22 — отсортировать элементы по убыванию частоты
 * При равных частотах использовать возрастание значения
 */
public class Main {
    /**
     * Считывает массив и выводит результат сортировки
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(sortByFrequency(numbers));
    }
    /**
     * Сортирует копию массива по частоте и значению элементов
     * @param numbers - исходный массив
     * @return - отсортированная копия
     */
    public static int[] sortByFrequency(int[] numbers) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int number : numbers) {
            frequencies.merge(number, 1, Integer::sum);
        }

        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, (first, second) -> {
            int comparison = Integer.compare(frequencies.get(second), frequencies.get(first));

            if (comparison != 0) {
                return comparison;
            }

            return Integer.compare(first, second);
        });

        return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
    }
}
