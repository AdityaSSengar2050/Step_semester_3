import java.util.Scanner;

abstract class Cab {
    protected double distance;

    static final double MIN_FARE = 100.0;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    double getFare() {
        double fare = distance * getRate();
        return Math.max(fare, MIN_FARE);
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 14.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }

    @Override
    double getRate() {
        return 18.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;

                case "SEDAN":
                    cab = new SedanCab(km);
                    break;

                case "SUV":
                    cab = new SUVCab(km);
                    break;

                default:
                    continue;
            }

            double fare = cab.getFare();

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    NightService nightCab =
                            (NightService) cab;

                    fare = nightCab.applyNightCharge(fare);
                } else {
                    System.out.println(
                            type + ": night service not available"
                    );
                    continue;
                }
            }

            total += fare;

            System.out.printf(
                    "%s: %.2f%n",
                    type, fare
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
