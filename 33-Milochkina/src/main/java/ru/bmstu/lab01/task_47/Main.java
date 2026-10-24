package ru.bmstu.lab01.task_47;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 47 — повернуть прямоугольную матрицу на 90 градусов по часовой стрелке
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        MatrixIo.printMatrix(rotateClockwise(matrix));
    }
    /**
     * Создаёт повёрнутую матрицу размера m на n
     * @param matrix - непустая прямоугольная матрица
     * @return - матрица после поворота по часовой стрелке
     */
    public static int[][] rotateClockwise(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                result[column][rows - 1 - row] = matrix[row][column];
            }
        }
        return result;
    }
}
