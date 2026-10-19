package ru.bmstu.lab01.task_2;
import java.util.Scanner;
/**
 * Задача 2. Вывод индекса первого элемента массива, равного x.
 * Если такого элемента нет, вывести -1.
 */
public class Main {
    /**
     * Считывает массив и искомое число, выводит индекс первого вхождения
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int index = 0; index < size; index++) {
            numbers[index] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        System.out.println(findFirstIndex(numbers, target));
    }
    /**
     * Функция нахождения индекса первого вхождения заданного числа
     * @param numbers - массив целых чисел
     * @param target - искомое число
     * @return индекс первого вхождения или -1, если число отсутствует
     */
    public static int findFirstIndex(int[] numbers, int target) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
