package ru.bmstu.lab01.task_4;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Задача 4. Вывести все индексы элементов массива, равных числу x,
 * в порядке возрастания.
 */
public class Main {
    /**
     * Считывает массив и искомое число, выводит индексы совпадений
     * @param args - аргументы командной строки
     * При отсутствии совпадений функция выводит пустую строку
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int index = 0; index < size; index++) {
            numbers[index] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        int[] indices = findAllIndices(numbers, target);
        StringBuilder output = new StringBuilder();

        for (int index = 0; index < indices.length; index++) {
            if (index > 0) {
                output.append(' ');
            }
            output.append(indices[index]);
        }

        System.out.println(output);
    }
    /**
     * Находит все индексы элементов, равных искомому числу
     * @param numbers - массив целых чисел
     * @param target - искомое число
     * @return - индексы по возрастанию; пустой массив, если совпадений нет
     */
    public static int[] findAllIndices(int[] numbers, int target) {
        int[] indices = new int[numbers.length];
        int count = 0;

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == target) {
                indices[count] = index;
                count++;
            }
        }
        return Arrays.copyOf(indices, count);
    }
}
