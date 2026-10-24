package ru.bmstu.lab01.task_16;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 16 — отсортировать элементы по неубыванию модуля
 * При равных модулях отрицательный элемент идёт первым
 */
public class Main {
    /**
     * Считывает массив и выводит результат сортировки
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(sortByAbsoluteValue(numbers));
    }
    /**
     * Создаёт массив, отсортированный по модулю и значению
     * @param numbers - исходный массив
     * @return - отсортированная копия массива
     */
    public static int[] sortByAbsoluteValue(int[] numbers) {
        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, (first, second) -> {
            int comparison = Long.compare(Math.abs((long) first), Math.abs((long) second));

            if (comparison != 0) {
                return comparison;
            }

            return Integer.compare(first, second);
        });

        return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
    }
}
