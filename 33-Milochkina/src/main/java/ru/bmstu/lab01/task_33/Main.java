package ru.bmstu.lab01.task_33;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 33 — за O(n log n) подсчитать инверсии с помощью сортировки слиянием
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(countInversions(numbers));
    }
    /**
     * Подсчитывает пары с индексами i < j и значениями a[i] > a[j]
     * @param numbers - исходный массив
     * @return - количество инверсий
     */
    public static long countInversions(int[] numbers) {
        int[] sorted = numbers.clone();
        int[] buffer = new int[numbers.length];
        return sortAndCount(sorted, buffer, 0, sorted.length);
    }

    private static long sortAndCount(int[] numbers, int[] buffer, int from, int to) {
        if (to - from < 2) {
            return 0;
        }
        int middle = from + (to - from) / 2;
        long result = sortAndCount(numbers, buffer, from, middle);
        result += sortAndCount(numbers, buffer, middle, to);
        return result + mergeAndCount(numbers, buffer, from, middle, to);
    }

    private static long mergeAndCount(int[] numbers, int[] buffer, int from, int middle, int to) {
        int left = from;
        int right = middle;
        int index = from;
        long inversions = 0;
        while (left < middle && right < to) {
            if (numbers[left] <= numbers[right]) {
                buffer[index++] = numbers[left++];
            } else {
                buffer[index++] = numbers[right++];
                // Текущий правый элемент меньше всех оставшихся элементов левой половины
                inversions += middle - left;
            }
        }
        System.arraycopy(numbers, left, buffer, index, middle - left);
        index += middle - left;
        System.arraycopy(numbers, right, buffer, index, to - right);
        System.arraycopy(buffer, from, numbers, from, to - from);
        return inversions;
    }
}
