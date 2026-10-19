import java.util.Scanner;

abstract class Ticket {
    int count;
    static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract String getSeatType();
    abstract double getBasePrice();

    double calculateTotal() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }
    String getSeatType() {
        return "REGULAR";
    }
    double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }
    String getSeatType() {
        return "PREMIUM";
    }
    double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }
    String getSeatType() {
        return "RECLINER";
    }
    double getBasePrice() {
        return 400.0;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();
        Ticket[] bookings = new Ticket[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Booking " + (i + 1) + " ---");
            System.out.print("Enter seat type (REGULAR / PREMIUM / RECLINER): ");
            String seat = sc.next().toUpperCase();
            System.out.print("Enter number of tickets: ");
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else if (seat.equals("RECLINER")) {
                bookings[i] = new ReclinerTicket(count);
            } else {
                System.out.println("Invalid seat type!");
                i--;
            }
        }

        System.out.println("\n=== Movie Ticket Bill ===");
        for (int i = 0; i < n; i++) {
            double amount = bookings[i].calculateTotal();
            System.out.printf("%s: %.2f\n", bookings[i].getSeatType(), amount);
            grandTotal += amount;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}