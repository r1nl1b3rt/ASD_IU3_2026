package ru.bmstu.lab01.task_51;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 51 — найти максимальный элемент каждой строки матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        ArrayIo.printArray(rowMaximums(matrix));
    }
    /**
     * Находит максимум в каждой непустой строке
     * @param matrix - непустая прямоугольная матрица
     * @return - массив максимумов строк
     */
    public static int[] rowMaximums(int[][] matrix) {
        int[] result = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            result[row] = matrix[row][0];
            for (int number : matrix[row]) {
                result[row] = Math.max(result[row], number);
            }
        }
        return result;
    }
}
