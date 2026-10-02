import java.util.Scanner;

abstract class Vehicle {
    int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getType();
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    public String getType() {
        return "BIKE";
    }

    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    public String getType() {
        return "CAR";
    }

    public double calculateCharge() {
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    public String getType() {
        return "TRUCK";
    }

    public double calculateCharge() {
        double charge = hours * 50.0;
        if (charge < 100.0) {
            charge = 100.0;
        }
        return charge;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equalsIgnoreCase("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equalsIgnoreCase("CAR")) {
                vehicles[i] = new Car(hours);
            } else {
                vehicles[i] = new Truck(hours);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < vehicles.length; i++) {
            double charge = vehicles[i].calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", vehicles[i].getType(), charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}