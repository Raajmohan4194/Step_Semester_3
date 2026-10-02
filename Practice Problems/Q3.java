import java.util.Scanner;

abstract class Delivery {
    double weight;
    double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public String getType() {
        return "STANDARD";
    }

    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public String getType() {
        return "EXPRESS";
    }

    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }

    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = sc.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < deliveries.length; i++) {
            double fee = deliveries[i].calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", deliveries[i].getType(), fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}