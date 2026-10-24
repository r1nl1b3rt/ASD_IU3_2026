package ru.bmstu.lab01.task_52;
import java.util.Scanner;

import ru.bmstu.lab01.common.ArrayIo;
import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 52 — найти минимальный элемент каждого столбца матрицы
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        ArrayIo.printArray(columnMinimums(matrix));
    }
    /**
     * Находит минимум в каждом столбце
     * @param matrix - непустая прямоугольная матрица
     * @return - массив минимумов столбцов
     */
    public static int[] columnMinimums(int[][] matrix) {
        int[] result = matrix[0].clone();
        for (int[] row : matrix) {
            for (int column = 0; column < row.length; column++) {
                result[column] = Math.min(result[column], row[column]);
            }
        }
        return result;
    }
}
