package ru.bmstu.lab01.task_41;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.ArrayOutput;
/**
 * Задача 41 — удалить все вхождения заданного элемента с сохранением порядка
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int target = scanner.nextInt();
        int length = removeElement(numbers, target);
        ArrayOutput.printPrefix(numbers, length);
    }

    /**
     * Переносит оставшиеся элементы в начало исходного массива
     * @param numbers - изменяемый массив
     * @param target - удаляемое значение
     * @return - количество оставшихся элементов
     */
    public static int removeElement(int[] numbers, int target) {
        int length = 0;
        for (int number : numbers) {
            if (number != target) {
                numbers[length++] = number;
            }
        }
        return length;
    }
}
