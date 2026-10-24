package ru.bmstu.lab01.task_59;
import java.math.BigInteger;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 59 — вычислить точный определитель целочисленной матрицы 3 на 3
 */
public class Main {

    private static final int MATRIX_SIZE = 3;
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner, MATRIX_SIZE, MATRIX_SIZE);
        System.out.println(determinant(matrix));
    }
    /**
     * Вычисляет определитель разложением по первой строке
     * @param matrix - матрица размера 3 на 3
     * @return - точный определитель без переполнения
     */
    public static BigInteger determinant(int[][] matrix) {
        BigInteger firstTerm = BigInteger.valueOf(matrix[0][0]).multiply(minor(matrix, 1, 2));
        BigInteger secondTerm = BigInteger.valueOf(matrix[0][1]).multiply(minor(matrix, 0, 2));
        BigInteger thirdTerm = BigInteger.valueOf(matrix[0][2]).multiply(minor(matrix, 0, 1));
        return firstTerm.subtract(secondTerm).add(thirdTerm);
    }

    private static BigInteger minor(int[][] matrix, int firstColumn, int secondColumn) {
        BigInteger firstProduct = BigInteger.valueOf(matrix[1][firstColumn])
                .multiply(BigInteger.valueOf(matrix[2][secondColumn]));
        BigInteger secondProduct = BigInteger.valueOf(matrix[1][secondColumn])
                .multiply(BigInteger.valueOf(matrix[2][firstColumn]));
        return firstProduct.subtract(secondProduct);
    }
}
