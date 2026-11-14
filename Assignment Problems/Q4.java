import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
    String getModeName();
    double getFee(double amount);
}

class CashPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0.0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getModeName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double getFee(double amount) {
        return amount * 0.02;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getModeName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0.0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getModeName() {
        return "UPI";
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();

        PaymentMode[] modes = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter payment mode and amount: ");
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            if (mode.equalsIgnoreCase("Card")) {
                modes[i] = new CardPayment();
            } else if (mode.equalsIgnoreCase("UPI")) {
                modes[i] = new UpiPayment();
            } else {
                modes[i] = new CashPayment();
            }
        }

        double totalProcessed = 0.0;
        for (int i = 0; i < n; i++) {
            double amt = amounts[i];
            double fee = modes[i].getFee(amt);
            double processed = modes[i].processPayment(amt);
            totalProcessed += processed;
            System.out.println(modes[i].getModeName() + ": amount " + amt + ", fee " + fee + ", processed " + processed);
        }
        System.out.println("Total Amount Processed: " + totalProcessed);
        sc.close();
    }
}