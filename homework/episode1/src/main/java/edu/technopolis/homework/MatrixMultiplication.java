package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int x = Integer.parseInt(args[2]);
        int y = Integer.parseInt(args[3]);
        if ((m != x)) {
            System.out.println("При таких размерностях умножение матриц невозможно");
            return;
        }
        if (args.length != (4 + n * m + x * y)) {
            System.out.println("Неверное количество аргументов. Проверьте, что Вы ввели все данные правильно");
        }
        int count = 4;
        long[][] matrixA = new long[n][m];
        long[][] matrixB = new long[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(args[count++]);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrixB[i][j] = Integer.parseInt(args[count++]);
            }
        }
        long[][] result = new long[n][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
                if (j != result[0].length - 1)
                    System.out.print(result[i][j] + "\t");
                else
                    System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}