package ru.bmstu.lab01.task_58;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 58 — заполнить матрицу числами от 1 до nm змейкой по строкам
 */
public class Main {
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        MatrixIo.printMatrix(fillSnake(rows, columns));
    }
    /**
     * Заполняет чётные строки слева направо, нечётные справа налево
     * @param rows - положительное число строк
     * @param columns - положительное число столбцов
     * @return - матрица, заполненная змейкой
     */
    public static long[][] fillSnake(int rows, int columns) {
        long[][] result = new long[rows][columns];
        long number = 1;
        for (int row = 0; row < rows; row++) {
            for (int offset = 0; offset < columns; offset++) {
                int column = row % 2 == 0 ? offset : columns - 1 - offset;
                result[row][column] = number++;
            }
        }
        return result;
    }
}
