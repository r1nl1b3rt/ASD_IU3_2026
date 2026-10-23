package ru.bmstu.lab01.common;
import java.util.Scanner;
/**
 * Общие операции чтения и вывода целочисленных массивов.
 */
public class ArrayIo {
    /**
     * Считывает размер массива, затем его элементы
     *
     * @param scanner - источник ввода
     * @return - считанный массив
     */
    public static int[] readArray(Scanner scanner) {
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int index = 0; index < size; index++) {
            numbers[index] = scanner.nextInt();
        }

        return numbers;
    }
    /**
     * Выводит элементы через пробел и завершает строку
     * @param numbers - массив для вывода
     */
    public static void printArray(int[] numbers) {
        StringBuilder output = new StringBuilder();

        for (int index = 0; index < numbers.length; index++) {
            if (index > 0) {
                output.append(' ');
            }
            output.append(numbers[index]);
        }

        System.out.println(output);
    }
}
