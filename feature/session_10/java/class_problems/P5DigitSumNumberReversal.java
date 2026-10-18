import java.util.Scanner;

public class P5DigitSumNumberReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long number = sc.nextLong();
        long temp = number;
        long sum = 0;
        long reversed = 0;

        while (temp > 0) {
            long digit = temp % 10;

            sum += digit;
            reversed = reversed * 10 + digit;

            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);

        sc.close();
    }
}
