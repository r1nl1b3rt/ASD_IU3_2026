package ru.bmstu.lab01.common;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringJoiner;
/**
 * Общие операции чтения и вывода прямоугольных и квадратных матриц
 */
public class MatrixIo {
    /**
     * Считывает размеры n и m, затем элементы матрицы
     * @param scanner - источник входных данных
     * @return - считанная прямоугольная матрица
     */
    public static int[][] readMatrix(Scanner scanner) {
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        return readMatrix(scanner, rows, columns);
    }
    /**
     * Считывает размер n, затем элементы квадратной матрицы
     * @param scanner - источник входных данных
     * @return - считанная квадратная матрица
     */
    public static int[][] readSquareMatrix(Scanner scanner) {
        int size = scanner.nextInt();
        return readMatrix(scanner, size, size);
    }
    /**
     * Считывает элементы матрицы известных размеров
     * @param scanner - источник входных данных
     * @param rows - число строк
     * @param columns - число столбцов
     * @return - считанная матрица
     */
    public static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        return matrix;
    }
    /**
     * Выводит целочисленную матрицу по строкам
     * @param matrix - выводимая матрица
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            ArrayIo.printArray(row);
        }
    }
    /**
     * Выводит матрицу длинных целых чисел по строкам
     * @param matrix - выводимая матрица
     */
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            ArrayOutput.printArray(row);
        }
    }
    /**
     * Выводит матрицу целых чисел произвольной точности
     * @param matrix - выводимая матрица
     */
    public static void printMatrix(BigInteger[][] matrix) {
        for (BigInteger[] row : matrix) {
            StringJoiner output = new StringJoiner(" ");
            for (BigInteger number : row) {
                output.add(number.toString());
            }
            System.out.println(output);
        }
    }
}
