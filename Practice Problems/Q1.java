import java.util.Scanner;

abstract class Payment {
    double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract String getType();
    public abstract double calculateFinalAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    public String getType() {
        return "CARD";
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    public String getType() {
        return "WALLET";
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    public String getType() {
        return "BANKTRANSFER";
    }

    public double calculateFinalAmount() {
        return amount;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equalsIgnoreCase("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equalsIgnoreCase("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else {
                payments[i] = new BankTransferPayment(amount);
            }
        }
        double total = 0;
        for (int i = 0; i < payments.length; i++) {
            double finalAmount = payments[i].calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f\n", payments[i].getType(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}