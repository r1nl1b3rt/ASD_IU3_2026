package ru.bmstu.lab01.task_50;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayOutput;
import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 50 — вычислить суммы столбцов целочисленной матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        ArrayOutput.printArray(columnSums(matrix));
    }
    /**
     * Суммирует элементы каждого столбца
     * @param matrix - непустая прямоугольная матрица
     * @return - массив сумм столбцов
     */
    public static long[] columnSums(int[][] matrix) {
        long[] result = new long[matrix[0].length];
        for (int[] row : matrix) {
            for (int column = 0; column < row.length; column++) {
                result[column] += row[column];
            }
        }
        return result;
    }
}
