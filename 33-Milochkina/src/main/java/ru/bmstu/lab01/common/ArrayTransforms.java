package ru.bmstu.lab01.common;
/**
 * Общие операции перестановки элементов массива
 */
public class ArrayTransforms {
    /**
     * Меняет местами два элемента массива
     * @param numbers - изменяемый массив
     * @param first - индекс первого элемента
     * @param second - индекс второго элемента
     */
    public static void swap(int[] numbers, int first, int second) {
        int temporary = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temporary;
    }
    /**
     * Разворачивает диапазон массива на месте
     * @param numbers - изменяемый массив
     * @param from - индекс начала включительно
     * @param to - индекс конца исключительно
     */
    public static void reverse(int[] numbers, int from, int to) {
        int left = from;
        int right = to - 1;
        while (left < right) {
            swap(numbers, left++, right--);
        }
    }
}
