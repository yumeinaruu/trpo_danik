package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк матрицы: ");
        int n = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы: ");
        int m = scanner.nextInt();
        int size = n * m;
        int[] matrix = new int[size];
        System.out.println("Введите элементы матрицы: ");
  /*      for (int i = 0; i < temp.length; i++) {
            temp[i] = scanner.nextInt();
        }*/

        Arrays.setAll(matrix, i -> scanner.nextInt());

        int maxInc = 0;
        int maxDec = 0;
        int dec = 1;
        int inc = 1;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] == matrix[i - 1] - 1) {
                dec++;
            } else {
                if (dec > maxDec) {
                    maxDec = dec;
                }
                dec = 1;
            }

            if (matrix[i] == matrix[i - 1] + 1) {
                inc++;
            } else {
                if (inc > maxInc) {
                    maxInc = inc;
                }
                inc = 1;
            }
        }

        if (dec > maxDec) {
            maxDec = dec;
        }
        if (inc > maxInc) {
            maxInc = inc;
        }

        System.out.println("Количество возрастающих элементов: " + maxInc);
        System.out.println("Количество убывающих элементов: " + maxDec);
    }
}
