import java.util.Scanner;

public class P14FirstValidTable {

    static void generateFirstValidTable(int[] candidates) {

        for (int number : candidates) {

            if (number < 1) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }

            break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] candidates = new int[4];

        System.out.println("Enter 4 candidate numbers:");

        for (int i = 0; i < 4; i++) {
            candidates[i] = sc.nextInt();
        }

        generateFirstValidTable(candidates);

        sc.close();
    }
}
