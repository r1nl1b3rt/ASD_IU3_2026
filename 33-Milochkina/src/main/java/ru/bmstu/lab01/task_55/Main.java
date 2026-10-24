package ru.bmstu.lab01.task_55;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 55 — найти сумму элементов побочной диагонали квадратной матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readSquareMatrix(scanner);
        System.out.println(secondaryDiagonalSum(matrix));
    }
    /**
     * Суммирует диагональ от правого верхнего угла к левому нижнему
     * @param matrix - квадратная матрица
     * @return - сумма побочной диагонали
     */
    public static long secondaryDiagonalSum(int[][] matrix) {
        long result = 0;
        for (int row = 0; row < matrix.length; row++) {
            result += matrix[row][matrix.length - 1 - row];
        }
        return result;
    }
}
