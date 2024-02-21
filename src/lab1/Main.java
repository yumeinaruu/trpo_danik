package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк матрицы: ");
        int n = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы: ");
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("Введите элементы матрицы: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int maxInc = 0;
        int maxDec = 0;
        for (int i = 0; i < n; i++) {
            int inc = 1;
            int dec = 1;
            for (int j = 0; j < m - 1; j++) {
                if (matrix[i][j] < matrix[i][j + 1]) {
                    inc++;
                } else {
                    if (inc > maxInc) {
                        maxInc = inc;
                    }
                    inc = 1;
                }
                if (matrix[i][j] > matrix[i][j + 1]) {
                    dec++;
                } else {
                    if (dec > maxDec) {
                        maxDec = dec;
                    }
                    dec = 1;
                }
            }
            if (inc > maxInc) {
                maxInc = inc;
            }
            if (dec > maxDec) {
                maxDec = dec;
            }
        }
        System.out.println("Количество возрастающих элементов: " + maxInc);
        System.out.println("Количество убывающих элементов: " + maxDec);
    }
}
