package ru.bmstu.lab01.task_9;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 9. Вывести YES, если массив неубывающий, иначе NO.
 */
public class Main {
    /**
     * Считывает массив и выводит результат проверки порядка
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);

        if (isNonDecreasing(numbers)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    /**
     * Проверяет, что каждый следующий элемент не меньше предыдущего
     * @param numbers - массив целых чисел
     * @return - true, если массив неубывающий, иначе false
     */
    public static boolean isNonDecreasing(int[] numbers) {
        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] < numbers[index - 1]) {
                return false;
            }
        }

        return true;
    }
}
