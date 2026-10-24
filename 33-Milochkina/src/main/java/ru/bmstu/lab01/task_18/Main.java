package ru.bmstu.lab01.task_18;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 18 — отсортировать чётные элементы по неубыванию
 * Нечётные элементы должны остаться на своих местах
 */
public class Main {
    /**
     * Считывает массив, преобразует и выводит результат
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        sortEvenElements(numbers);
        ArrayIo.printArray(numbers);
    }
    /**
     * Сортирует чётные значения на их исходных позициях
     * @param numbers - изменяемый массив
     */
    public static void sortEvenElements(int[] numbers) {
        int[] evens = Arrays.stream(numbers).filter(number -> number % 2 == 0).toArray();

        Arrays.sort(evens);
        int position = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                numbers[index] = evens[position];
                position++;
            }
        }
    }
}
