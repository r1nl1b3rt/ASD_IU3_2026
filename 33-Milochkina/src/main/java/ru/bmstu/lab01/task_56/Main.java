package ru.bmstu.lab01.task_56;
import java.math.BigInteger;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 56 — умножить матрицы n на m и m на k за O(nmk) с O(nk) памятью результата
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] first = MatrixIo.readMatrix(scanner);
        int[][] second = MatrixIo.readMatrix(scanner);
        MatrixIo.printMatrix(multiply(first, second));
    }
    /**
     * Вычисляет точное произведение матриц без переполнения long
     * @param first - первая непустая матрица n на m
     * @param second - вторая непустая матрица m на k
     * @return - матрица произведения n на k
     */
    public static BigInteger[][] multiply(int[][] first, int[][] second) {
        BigInteger[][] result = new BigInteger[first.length][second[0].length];
        for (int row = 0; row < first.length; row++) {
            for (int column = 0; column < second[0].length; column++) {
                BigInteger sum = BigInteger.ZERO;
                for (int index = 0; index < second.length; index++) {
                    long product = (long) first[row][index] * second[index][column];
                    sum = sum.add(BigInteger.valueOf(product));
                }
                result[row][column] = sum;
            }
        }
        return result;
    }
}
