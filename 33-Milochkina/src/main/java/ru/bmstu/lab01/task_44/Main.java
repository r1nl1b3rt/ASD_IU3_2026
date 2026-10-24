package ru.bmstu.lab01.task_44;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 44 — чередовать положительные и отрицательные элементы, сохранив порядок внутри групп
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        ArrayIo.printArray(alternateSigns(numbers));
    }

    /**
     * Чередует знаки, начиная с положительного элемента
     * @param numbers - массив без нулей с равным числом положительных и отрицательных элементов
     * @return - массив с чередующимися знаками
     */
    public static int[] alternateSigns(int[] numbers) {
        int[] result = new int[numbers.length];
        int positivePosition = 0;
        int negativePosition = 1;
        for (int number : numbers) {
            if (number > 0) {
                result[positivePosition] = number;
                positivePosition += 2;
            } else {
                result[negativePosition] = number;
                negativePosition += 2;
            }
        }
        return result;
    }
}
