package ru.bmstu.lab01.task_21;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 21 — отсортировать массив и найти k-й наименьший элемент
 */
public class Main {
    /**
     * Считывает массив и k, выводит выбранный элемент
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int order = scanner.nextInt();
        System.out.println(findKthSmallest(numbers, order));
    }
    /**
     * Находит элемент с индексом k - 1 в отсортированной копии
     * @param numbers - исходный массив
     * @param order - номер элемента от 1 до длины массива
     * @return - k-й наименьший элемент с учётом повторений
     */
    public static int findKthSmallest(int[] numbers, int order) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);

        return sorted[order - 1];
    }
}
