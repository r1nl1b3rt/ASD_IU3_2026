package ru.bmstu.lab01.task_43;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 43 — переместить нули в конец на месте, сохранив порядок остальных элементов
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        moveZerosToEnd(numbers);
        ArrayIo.printArray(numbers);
    }
    /**
     * Сдвигает ненулевые элементы в начало, затем заполняет остаток нулями
     * @param numbers - изменяемый массив
     */
    public static void moveZerosToEnd(int[] numbers) {
        int position = 0;
        for (int number : numbers) {
            if (number != 0) {
                numbers[position++] = number;
            }
        }
        while (position < numbers.length) {
            numbers[position++] = 0;
        }
    }
}
