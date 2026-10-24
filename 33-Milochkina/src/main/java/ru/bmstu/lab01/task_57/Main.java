package ru.bmstu.lab01.task_57;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 57 — обойти матрицу по спирали от левого верхнего угла по часовой стрелке
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        ArrayIo.printArray(spiralOrder(matrix));
    }
    /**
     * Последовательно снимает внешние границы прямоугольника
     * @param matrix - непустая прямоугольная матрица
     * @return - массив элементов в порядке спирального обхода
     */
    public static int[] spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int position = 0;
        while (top <= bottom && left <= right) {
            position = appendRow(matrix, top++, left, right + 1, 1, result, position);
            position = appendColumn(matrix, right--, top, bottom + 1, 1, result, position);
            if (top <= bottom) {
                position = appendRow(matrix, bottom--, right, left - 1, -1, result, position);
            }
            if (left <= right) {
                position = appendColumn(matrix, left++, bottom, top - 1, -1, result, position);
            }
        }
        return result;
    }

    private static int appendRow(int[][] matrix, int row, int from, int to, int step, int[] result, int position) {
        for (int column = from; column != to; column += step) {
            result[position++] = matrix[row][column];
        }
        return position;
    }

    private static int appendColumn(int[][] matrix, int column, int from, int to, int step, int[] result,
            int position) {
        for (int row = from; row != to; row += step) {
            result[position++] = matrix[row][column];
        }
        return position;
    }
}
