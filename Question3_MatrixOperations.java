
import java.util.Scanner;

public class Question3_MatrixOperations {

    static void display(int[][] a) {
        for (int[] row : a) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    static boolean isSquare(int[][] a) {
        return a.length == a[0].length;
    }

    static boolean isDiagonal(int[][] a) {
        if (!isSquare(a)) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i != j && a[i][j] != 0) return false;
            }
        }
        return true;
    }

    static boolean isIdentity(int[][] a) {
        if (!isSquare(a)) return false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int expected = (i == j) ? 1 : 0;
                if (a[i][j] != expected) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        if (r1 <= 0 || c1 <= 0) {
            System.out.println("Dimensions must be positive.");
            sc.close();
            return;
        }

        int[][] a = new int[r1][c1];
        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix A:");
        display(a);

        System.out.println("Square matrix: " + isSquare(a));
        System.out.println("Diagonal matrix: " + isDiagonal(a));
        System.out.println("Identity matrix: " + isIdentity(a));

        System.out.println("Transpose of A:");
        for (int j = 0; j < c1; j++) {
            for (int i = 0; i < r1; i++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Enter rows and columns of matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        if (r2 <= 0 || c2 <= 0) {
            System.out.println("Dimensions must be positive.");
            sc.close();
            return;
        }

        int[][] b = new int[r2][c2];
        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        if (r1 == r2 && c1 == c2) {
            int[][] sum = new int[r1][c1];
            int[][] diff = new int[r1][c1];

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = a[i][j] + b[i][j];
                    diff[i][j] = a[i][j] - b[i][j];
                }
            }

            System.out.println("Addition:");
            display(sum);
            System.out.println("Subtraction:");
            display(diff);
        } else {
            System.out.println(
                "Addition and subtraction require equal dimensions.");
        }

        if (c1 == r2) {
            int[][] product = new int[r1][c2];

            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    for (int k = 0; k < c1; k++) {
                        product[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("Multiplication:");
            display(product);
        } else {
            System.out.println(
                "Multiplication requires columns of A = rows of B.");
        }

        sc.close();
    }
}
