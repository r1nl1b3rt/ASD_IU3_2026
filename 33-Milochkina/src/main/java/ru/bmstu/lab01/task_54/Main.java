package ru.bmstu.lab01.task_54;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 54 — найти сумму элементов главной диагонали квадратной матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readSquareMatrix(scanner);
        System.out.println(mainDiagonalSum(matrix));
    }
    /**
     * Суммирует элементы с одинаковыми индексами строки и столбца
     * @param matrix - квадратная матрица
     * @return - сумма главной диагонали
     */
    public static long mainDiagonalSum(int[][] matrix) {
        long result = 0;
        for (int index = 0; index < matrix.length; index++) {
            result += matrix[index][index];
        }
        return result;
    }
}
