package ru.bmstu.lab01.task_5;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 5. Найти сумму элементов массива с чётными индексами.
 */
public class Main {
    /**
     * Считывает массив и выводит сумму элементов с чётными индексами
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        System.out.println(sumAtEvenIndices(numbers));
    }
    /**
     * Складывает элементы с индексами 0, 2, 4 и далее
     * @param numbers - массив целых чисел
     * @return - сумма выбранных элементов
     */
    public static long sumAtEvenIndices(int[] numbers) {
        long sum = 0;

        for (int index = 0; index < numbers.length; index += 2) {
            sum += numbers[index];
        }

        return sum;
    }
}
