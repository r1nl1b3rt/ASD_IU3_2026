package ru.bmstu.lab01.task_60;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import ru.bmstu.lab01.common.MatrixIo;
/**
 * Задача 60 — подсчитать острова единиц с горизонтальной и вертикальной связностью через BFS
 */
public class Main {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * Считывает входные данные и выводит результат
     * @param args - аргументы командной строки, не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = MatrixIo.readMatrix(scanner);
        System.out.println(countIslands(matrix));
    }
    /**
     * Подсчитывает компоненты единиц, не изменяя исходную матрицу
     * @param matrix - непустая прямоугольная матрица из нулей и единиц
     * @return - число островов
     */
    public static int countIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int islands = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1 && !visited[row][column]) {
                    markIsland(matrix, visited, row, column);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void markIsland(int[][] matrix, boolean[][] visited, int startRow, int startColumn) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.removeFirst();
            for (int[] direction : DIRECTIONS) {
                int row = cell[0] + direction[0];
                int column = cell[1] + direction[1];
                if (row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length
                        && matrix[row][column] == 1 && !visited[row][column]) {
                    visited[row][column] = true;
                    queue.addLast(new int[]{row, column});
                }
            }
        }
    }
}
