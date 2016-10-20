package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String... args) {
        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            int x = Integer.parseInt(args[2]);
            int y = Integer.parseInt(args[3]);
            if ((m != x) ||
                    (n <= 0 || m <= 0 || x <= 0 || y <= 0))
                throw new IllegalArgumentException("The dimensions of the matrix are incorrect.");
            int count = 4;
            int[][] matrixA = new int[n][m];
            int[][] matrixB = new int[x][y];
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
            int[][] result = new int[n][y];
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
        } catch (IllegalArgumentException ill) {
            ill.printStackTrace();
        }

    }
}
