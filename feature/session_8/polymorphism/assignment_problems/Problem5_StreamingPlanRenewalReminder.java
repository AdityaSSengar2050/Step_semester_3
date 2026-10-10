import java.util.Scanner;
import java.time.LocalDate;

abstract class StreamingPlan {
    protected LocalDate startDate;

    StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {
    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class Problem5_StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            StreamingPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(startDate);
                    break;

                case "STANDARD":
                    plan = new StandardPlan(startDate);
                    break;

                case "PREMIUM":
                    plan = new PremiumPlan(startDate);
                    break;

                default:
                    continue;
            }

            System.out.println(name + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}
