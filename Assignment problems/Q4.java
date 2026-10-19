import java.util.Scanner;

interface NightServiceCab {
}

abstract class Cab {
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract String getCabType();
    abstract double getRatePerKm();

    double calculateFare(String time) {
        double fare = distance * getRatePerKm();
        if (fare < 100.0) {
            fare = 100.0;
        }
        if (time.equals("NIGHT")) {
            fare = fare + (fare * 0.20);
        }
        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }
    String getCabType() {
        return "MINI";
    }
    double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceCab {
    SedanCab(double distance) {
        super(distance);
    }
    String getCabType() {
        return "SEDAN";
    }
    double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightServiceCab {
    SUVCab(double distance) {
        super(distance);
    }
    String getCabType() {
        return "SUV";
    }
    double getRatePerKm() {
        return 18.0;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of trips: ");
        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] travelTimes = new String[n];
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Trip " + (i + 1) + " ---");
            System.out.print("Enter cab type (MINI / SEDAN / SUV): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter travel distance in km: ");
            double distance = sc.nextDouble();
            System.out.print("Enter travel time (DAY / NIGHT): ");
            String time = sc.next().toUpperCase();

            travelTimes[i] = time;
            if (type.equals("MINI")) {
                cabs[i] = new MiniCab(distance);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new SedanCab(distance);
            } else if (type.equals("SUV")) {
                cabs[i] = new SUVCab(distance);
            } else {
                System.out.println("Invalid cab type!");
                i--;
            }
        }

        System.out.println("\n=== Fare Details ===");
        for (int i = 0; i < n; i++) {
            if (travelTimes[i].equals("NIGHT") && !(cabs[i] instanceof NightServiceCab)) {
                System.out.printf("%s: night service not available\n", cabs[i].getCabType());
            } else {
                double fare = cabs[i].calculateFare(travelTimes[i]);
                System.out.printf("%s: %.2f\n", cabs[i].getCabType(), fare);
                grandTotal += fare;
            }
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}