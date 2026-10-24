package ru.bmstu.lab01.task_11;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 11. Найти элемент, ближайший к среднему арифметическому.
 * При равных расстояниях выбрать первый по индексу.
 */
public class Main {
    /**
     * Считывает массив и выводит элемент, ближайший к среднему
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(findClosestToAverage(numbers));
    }
    /**
     * Находит ближайший к среднему элемент без округления среднего
     * @param numbers - непустой массив целых чисел
     * @return - первый из элементов с минимальным расстоянием до среднего
     */
    public static int findClosestToAverage(int[] numbers) {
        long sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        int closest = numbers[0];
        long bestDistance = Math.abs((long) closest * numbers.length - sum);

        for (int index = 1; index < numbers.length; index++) {
            long distance = Math.abs((long) numbers[index] * numbers.length - sum);

            if (distance < bestDistance) {
                bestDistance = distance;
                closest = numbers[index];
            }
        }

        return closest;
    }
}
