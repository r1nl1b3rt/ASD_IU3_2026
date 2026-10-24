package ru.bmstu.lab01.task_37;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayTransforms;
/**
 * Задача 37 — развернуть массив на месте без создания нового массива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        reverse(numbers);
        ArrayIo.printArray(numbers);
    }
    /**
     * Разворачивает весь массив на месте
     * @param numbers - изменяемый массив
     */
    public static void reverse(int[] numbers) {
        ArrayTransforms.reverse(numbers, 0, numbers.length);
    }
}
