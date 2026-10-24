package ru.bmstu.lab01.task_53;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 53 — найти все элементы, минимальные в своей строке и максимальные в своём столбце
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        int[][] points = findSaddlePoints(matrix);
        for (int[] point : points) {
            System.out.println("(" + point[0] + ", " + point[1] + ", " + point[2] + ")");
        }
    }

    /**
     * Находит седловые точки в порядке строк, затем столбцов
     * @param matrix - непустая прямоугольная матрица
     * @return - массив троек из индекса строки, индекса столбца и значения
     */
    public static int[][] findSaddlePoints(int[][] matrix) {
        int[] rowMinimums = new int[matrix.length];
        int[] columnMaximums = new int[matrix[0].length];
        Arrays.fill(rowMinimums, Integer.MAX_VALUE);
        Arrays.fill(columnMaximums, Integer.MIN_VALUE);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                rowMinimums[row] = Math.min(rowMinimums[row], matrix[row][column]);
                columnMaximums[column] = Math.max(columnMaximums[column], matrix[row][column]);
            }
        }
        List<int[]> points = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == rowMinimums[row] && matrix[row][column] == columnMaximums[column]) {
                    points.add(new int[]{row, column, matrix[row][column]});
                }
            }
        }
        return points.toArray(int[][]::new);
    }
}
