import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return (getPower() * hours) / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

interface SaverMode {
    double getSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500.0;
    }

    @Override
    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500.0;
    }

    @Override
    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

public class Problem5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saverRequested = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AC(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;

                default:
                    continue;
            }

            if (saverRequested &&
                    !(appliance instanceof SaverMode)) {

                System.out.println(
                        type + ": saver mode not supported"
                );
                continue;
            }

            double units;

            if (saverRequested) {
                SaverMode saver =
                        (SaverMode) appliance;

                units = saver.getSaverUnits();
            } else {
                units = appliance.getUnits();
            }

            double cost = units * 8;
            totalCost += cost;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}
