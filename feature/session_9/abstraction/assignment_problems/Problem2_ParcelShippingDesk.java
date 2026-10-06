import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getShippingCharge();

    double getInsurance() {
        return 0.0;
    }

    double getTotal() {
        return getShippingCharge() + getInsurance();
    }
}

interface Insurable {
    double calculateInsurance(double declaredValue);
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getShippingCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getShippingCharge() {
        return 80 + (15 * weight);
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    @Override
    double getInsurance() {
        return calculateInsurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getShippingCharge() {
        return 40 + (10 * weight) + 50;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    @Override
    double getInsurance() {
        return calculateInsurance(declaredValue);
    }
}

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, declaredValue);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, declaredValue);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, declaredValue);
                    break;

                default:
                    continue;
            }

            double charge = parcel.getShippingCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();

            grandTotal += total;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
