package ru.bmstu.lab01.task_23;
import java.util.Arrays;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
/**
 * Задача 23 — проверить, является ли один массив перестановкой другого
 */
public class Main {
    /**
     * Считывает массивы и выводит YES или NO
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = ArrayIo.readArray(scanner);
        int[] second = ArrayIo.readArray(scanner);

        if (arePermutations(first, second)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    /**
     * Сравнивает отсортированные копии массивов
     * @param first - первый массив
     * @param second - второй массив
     * @return - true при одинаковом составе и количестве элементов
     */
    public static boolean arePermutations(int[] first, int[] second) {
        int[] firstSorted = first.clone();
        int[] secondSorted = second.clone();
        Arrays.sort(firstSorted);
        Arrays.sort(secondSorted);

        return Arrays.equals(firstSorted, secondSorted);
    }
}
