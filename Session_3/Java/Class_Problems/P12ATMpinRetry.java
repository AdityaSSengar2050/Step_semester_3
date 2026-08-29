import java.util.Scanner;

public class P12ATMpinRetry {

    static void atmPinRetry(String correctPin, String[] attempts) {

        int attemptCount = 0;
        boolean success = false;

        while (attemptCount < attempts.length && !success) {

            if (attempts[attemptCount].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attemptCount++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctPin = "4821";
        String[] attempts = new String[3];

        System.out.println("Enter 3 PIN attempts:");

        for (int i = 0; i < 3; i++) {
            attempts[i] = sc.next();
        }

        atmPinRetry(correctPin, attempts);

        sc.close();
    }
}
