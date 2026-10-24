package ru.bmstu.lab01.common;
import java.util.StringJoiner;
/**
 * Вывод длинных целых чисел и значимой части массива
 */
public class ArrayOutput {
    /**
     * Выводит первые length элементов через пробел
     * @param numbers - исходный массив
     * @param length - количество выводимых элементов
     */
    public static void printPrefix(int[] numbers, int length) {
        StringJoiner output = new StringJoiner(" ");
        for (int index = 0; index < length; index++) {
            output.add(Integer.toString(numbers[index]));
        }
        System.out.println(output);
    }
    /**
     * Выводит массив длинных целых чисел через пробел
     * @param numbers - выводимый массив
     */
    public static void printArray(long[] numbers) {
        StringJoiner output = new StringJoiner(" ");
        for (long number : numbers) {
            output.add(Long.toString(number));
        }
        System.out.println(output);
    }
}
