package ru.bmstu.lab01.task_39;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayTransforms;
/**
 * Задача 39 — циклически сдвинуть массив вправо на k позиций с учётом k больше длины массива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int shift = scanner.nextInt();
        rotateRight(numbers, shift);
        ArrayIo.printArray(numbers);
    }
    /**
     * Циклически сдвигает массив вправо на месте
     * @param numbers - изменяемый массив
     * @param shift - число позиций сдвига
     */
    public static void rotateRight(int[] numbers, int shift) {
        if (numbers.length == 0) {
            return;
        }
        int normalizedShift = Math.floorMod(shift, numbers.length);
        ArrayTransforms.reverse(numbers, 0, numbers.length);
        ArrayTransforms.reverse(numbers, 0, normalizedShift);
        ArrayTransforms.reverse(numbers, normalizedShift, numbers.length);
    }
}
