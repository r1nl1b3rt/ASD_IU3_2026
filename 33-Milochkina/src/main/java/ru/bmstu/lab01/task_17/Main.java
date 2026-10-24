package ru.bmstu.lab01.task_17;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 17 — отсортировать неотрицательные числа по сумме цифр
 * При равных суммах сохранить исходный порядок
 */
public class Main {
    /**
     * Считывает массив и выводит результат сортировки
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(sortByDigitSum(numbers));
    }
    /**
     * Создаёт массив с устойчивой сортировкой по сумме цифр
     * @param numbers - массив неотрицательных чисел
     * @return - отсортированная копия массива
     */
    public static int[] sortByDigitSum(int[] numbers) {
        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, Comparator.comparingInt(Main::digitSum));

        return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
    }
    /**
     * Вычисляет сумму десятичных цифр неотрицательного числа
     * @param number - неотрицательное число
     * @return - сумма цифр
     */
    public static int digitSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
