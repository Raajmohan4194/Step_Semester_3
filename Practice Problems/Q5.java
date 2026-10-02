import java.util.Scanner;

abstract class Transport {
    double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract String getType();
    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    public String getType() {
        return "BUS";
    }

    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        if (fare > 10.0) {
            fare = 10.0;
        }
        return fare;
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    public String getType() {
        return "TRAIN";
    }

    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends Transport {
    double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }

    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equalsIgnoreCase("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys[i] = new Train(distance);
            } else {
                double peakHourFactor = sc.nextDouble();
                journeys[i] = new Metro(distance, peakHourFactor);
            }
        }

        double grandTotalFare = 0;
        for (int i = 0; i < journeys.length; i++) {
            double fare = journeys[i].calculateFare();
            grandTotalFare += fare;
            System.out.printf("%s: %.2f\n", journeys[i].getType(), fare);
        }
        System.out.printf("Total: %.2f\n", grandTotalFare);
        sc.close();
    }
}