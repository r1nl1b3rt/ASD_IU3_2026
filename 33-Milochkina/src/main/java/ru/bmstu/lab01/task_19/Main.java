package ru.bmstu.lab01.task_19;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 19 — объединить два неубывающих массива
 * в один неубывающий массив за O(n + m)
 */
public class Main {
    /**
     * Считывает два массива и выводит результат слияния
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = ArrayIo.readArray(scanner);
        int[] second = ArrayIo.readArray(scanner);
        ArrayIo.printArray(mergeSorted(first, second));
    }
    /**
     * Объединяет отсортированные массивы последовательным слиянием
     * @param first - первый неубывающий массив
     * @param second - второй неубывающий массив
     * @return - объединённый неубывающий массив
     */
    public static int[] mergeSorted(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int position = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] <= second[secondIndex]) {
                result[position++] = first[firstIndex++];
            } else {
                result[position++] = second[secondIndex++];
            }
        }

        while (firstIndex < first.length) {
            result[position++] = first[firstIndex++];
        }

        while (secondIndex < second.length) {
            result[position++] = second[secondIndex++];
        }

        return result;
    }
}
