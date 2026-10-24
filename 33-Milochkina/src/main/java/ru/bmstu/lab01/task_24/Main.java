package ru.bmstu.lab01.task_24;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 24 — расположить чётные элементы по возрастанию,
 * затем нечётные по убыванию
 */
public class Main {
    /**
     * Считывает массив и выводит результат сортировки
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(sortEvenThenOdd(numbers));
    }
    /**
     * Сортирует копию массива по чётности и требуемому порядку
     * @param numbers - исходный массив
     * @return - чётные по возрастанию, затем нечётные по убыванию
     */
    public static int[] sortEvenThenOdd(int[] numbers) {
        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, (first, second) -> {
            boolean firstEven = first % 2 == 0;
            boolean secondEven = second % 2 == 0;

            if (firstEven != secondEven) {
                return firstEven ? -1 : 1;
            }

            if (firstEven) {
                return Integer.compare(first, second);
            }

            return Integer.compare(second, first);
        });

        return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
    }
}
