import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract String getType();
    abstract double calculateShippingCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    String getType() {
        return "STANDARD";
    }
    double calculateShippingCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    String getType() {
        return "EXPRESS";
    }
    double calculateShippingCharge() {
        return 80.0 + (15.0 * weight);
    }
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }
    String getType() {
        return "FRAGILE";
    }
    double calculateShippingCharge() {
        return (40.0 + (10.0 * weight)) + 50.0;
    }
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Parcel " + (i + 1) + " ---");
            System.out.print("Enter parcel type (STANDARD / EXPRESS / FRAGILE): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();
            System.out.print("Enter declared value: ");
            double value = sc.nextDouble();

            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, value);
            } else if (type.equals("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, value);
            } else {
                System.out.println("Invalid parcel type!");
                i--;
            }
        }

        System.out.println("\n=== Shipping Summary ===");
        for (int i = 0; i < n; i++) {
            double charge = parcels[i].calculateShippingCharge();
            double insurance = 0.0;
            if (parcels[i] instanceof Insurable) {
                insurance = ((Insurable) parcels[i]).calculateInsurance();
            }
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", parcels[i].getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}