import java.util.Scanner;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    String name;
    LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public abstract LocalDate calculateRenewalDate();
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);

            if (planType.equalsIgnoreCase("BASIC")) {
                plans[i] = new BasicPlan(name, startDate);
            } else if (planType.equalsIgnoreCase("STANDARD")) {
                plans[i] = new StandardPlan(name, startDate);
            } else {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (int i = 0; i < plans.length; i++) {
            LocalDate renewalDate = plans[i].calculateRenewalDate();
            System.out.println(plans[i].getName() + ": " + renewalDate);
        }
        sc.close();
    }
}