import java.util.Scanner;

abstract class TravelBooking {
    String mode;
    double distance;
    static final double BOOKING_FEE = 50.0;

    TravelBooking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super("BUS", distance);
    }
    double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super("TRAIN", distance);
    }
    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super("FLIGHT", distance);
    }
    double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of travel bookings: ");
        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Booking " + (i + 1) + " ---");
            System.out.print("Enter mode of travel (BUS / TRAIN / FLIGHT): ");
            String mode = sc.next().toUpperCase();
            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            } else {
                System.out.println("Invalid travel mode!");
                i--;
            }
        }

        System.out.println("\n=== Travel Booking Fares ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f\n", bookings[i].mode, bookings[i].calculateTotalFare());
        }
        sc.close();
    }
}