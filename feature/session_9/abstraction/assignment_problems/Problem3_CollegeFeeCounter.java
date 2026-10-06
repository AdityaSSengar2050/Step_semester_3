import java.util.Scanner;

abstract class Student {
    protected String name;

    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuitionFee();

    double getTotalFee() {
        return getTuitionFee();
    }
}

interface BusUser {
    boolean usesBus();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double getTuitionFee() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }

    @Override
    double getTotalFee() {
        return getTuitionFee() + TRANSPORT_FEE;
    }
}

class Hosteller extends Student implements BusUser {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double getTuitionFee() {
        return 40000.0 + 60000.0;
    }

    @Override
    public boolean usesBus() {
        return false;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    @Override
    double getTuitionFee() {
        return 20000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }

    @Override
    double getTotalFee() {
        return getTuitionFee() + TRANSPORT_FEE;
    }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    continue;
            }

            double fee = student.getTotalFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                totalCollected
        );

        sc.close();
    }
}
