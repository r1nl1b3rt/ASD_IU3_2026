package ru.bmstu.lab01.task_10;
import java.util.Scanner;
import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 10. Найти индекс последнего элемента, кратного k.
 * Если такого элемента нет, вывести -1. По условию k не равен нулю.
 */
public class Main {
    /**
     * Считывает массив и делитель, выводит индекс последнего совпадения
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = ArrayIo.readArray(scanner);
        int divisor = scanner.nextInt();

        System.out.println(findLastMultipleIndex(numbers, divisor));
    }
    /**
     * Находит последний элемент, делящийся на заданное число без остатка
     * @param numbers - массив целых чисел
     * @param divisor - ненулевой делитель
     * @return - индекс последнего подходящего элемента или -1
     */
    public static int findLastMultipleIndex(int[] numbers, int divisor) {
        for (int index = numbers.length - 1; index >= 0; index--) {
            if (numbers[index] % divisor == 0) {
                return index;
            }
        }

        return -1;
    }
}
