import java.util.Scanner;
import java.util.Locale;

class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResult() {
        System.out.printf(
            Locale.US,
            "%s: Average %.1f, Grade %c%n",
            name.toUpperCase(Locale.ROOT),
            calculateAverage(),
            calculateGrade()
        );
    }
}

public class P10StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            Student student = new Student(name, marks);
            student.printResult();
        }

        sc.close();
    }
}
