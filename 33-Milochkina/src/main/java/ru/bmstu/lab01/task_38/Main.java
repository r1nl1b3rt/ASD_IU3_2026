package ru.bmstu.lab01.task_38;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayTransforms;
/**
 * Задача 38 — сдвинуть массив влево за O(n) с O(1) дополнительной памяти
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
        rotateLeft(numbers, shift);
        ArrayIo.printArray(numbers);
    }
    /**
     * Циклически сдвигает массив влево через тройной разворот
     * @param numbers - изменяемый массив
     * @param shift - число позиций сдвига
     */
    public static void rotateLeft(int[] numbers, int shift) {
        if (numbers.length == 0) {
            return;
        }
        int normalizedShift = Math.floorMod(shift, numbers.length);
        // Два блока меняются местами после трёх разворотов
        ArrayTransforms.reverse(numbers, 0, normalizedShift);
        ArrayTransforms.reverse(numbers, normalizedShift, numbers.length);
        ArrayTransforms.reverse(numbers, 0, numbers.length);
    }
}
