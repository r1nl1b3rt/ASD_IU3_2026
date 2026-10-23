package ru.bmstu.lab01.task_6;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 6. Подсчитать элементы, строго большие среднего арифметического.
 * По условию среднее является целым числом.
 */
public class Main {
    /**
     * Считывает массив и выводит количество элементов больше среднего
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(countAboveAverage(numbers));
    }
    /**
     * Подсчитывает элементы, строго большие среднего арифметического
     * @param numbers - непустой массив, сумма которого делится на его длину
     * @return - количество элементов больше среднего
     */
    public static int countAboveAverage(int[] numbers) {
        long sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        long average = sum / numbers.length;
        int count = 0;

        for (int number : numbers) {
            if (number > average) {
                count++;
            }
        }

        return count;
    }
}