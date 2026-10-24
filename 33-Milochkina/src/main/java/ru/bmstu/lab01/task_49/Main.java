package ru.bmstu.lab01.task_49;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayOutput;
import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 49 — вычислить суммы строк целочисленной матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        ArrayOutput.printArray(rowSums(matrix));
    }
    /**
     * Суммирует элементы каждой строки
     * @param matrix - исходная прямоугольная матрица
     * @return - массив сумм строк
     */
    public static long[] rowSums(int[][] matrix) {
        long[] result = new long[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int number : matrix[row]) {
                result[row] += number;
            }
        }
        return result;
    }
}
