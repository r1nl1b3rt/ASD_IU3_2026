package ru.bmstu.lab01.task_3;
import java.util.Scanner;
/**
 * Задача 3. Подсчёт вхождений элементов массива, равных числу x
 */
public class Main {
    /**
     * Считывает массив и искомое число, выводит количество вхождений
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int index = 0; index < size; index++) {
            numbers[index] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        System.out.println(countOccurrences(numbers, target));
    }
    /**
     * Подсчитывает вхождения заданного числа в массив
     * @param numbers - массив целых чисел
     * @param target - искомое число
     * @return - количество элементов, равных искомому числу
     */
    public static int countOccurrences(int[] numbers, int target) {
        int count = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == target) {
                count++;
            }
        }
        return count;
    }
}
