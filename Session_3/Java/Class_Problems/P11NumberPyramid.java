import java.util.Scanner;

public class P11NumberPyramid {

    static void printNumberPyramid(int n) {

        for (int row = 1; row <= n; row++) {

            for (int i = 1; i <= row; i++) {
                System.out.print(row + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        printNumberPyramid(n);

        sc.close();
    }
}
