package ru.bmstu.lab01.task_48;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 48 — транспонировать квадратную матрицу на месте без создания нового массива
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readSquareMatrix(scanner);
        transpose(matrix);
        MatrixIo.printMatrix(matrix);
    }
    /**
     * Меняет местами элементы относительно главной диагонали
     * @param matrix - изменяемая квадратная матрица
     */
    public static void transpose(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = row + 1; column < matrix.length; column++) {
                int temporary = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temporary;
            }
        }
    }
}
