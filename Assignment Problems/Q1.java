import java.util.Scanner;

abstract class Customer {
    double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    public String getType() {
        return "STUDENT";
    }

    public double calculateFinalAmount() {
        return amount - (amount * 0.10);
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    public String getType() {
        return "STAFF";
    }

    public double calculateFinalAmount() {
        return amount - (amount * 0.05);
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    public String getType() {
        return "GUEST";
    }

    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equalsIgnoreCase("STUDENT")) {
                customers[i] = new StudentCustomer(amount);
            } else if (type.equalsIgnoreCase("STAFF")) {
                customers[i] = new StaffCustomer(amount);
            } else {
                customers[i] = new GuestCustomer(amount);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < customers.length; i++) {
            double finalAmount = customers[i].calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", customers[i].getType(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}