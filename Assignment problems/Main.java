import java.util.Scanner;

interface SaverModeSupported {
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract String getName();
    abstract double getPowerRating();

    double calculateUnits(boolean saverMode) {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverMode) {
            units = units * 0.75;
        }
        return units;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }
    String getName() {
        return "FRIDGE";
    }
    double getPowerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverModeSupported {
    AirConditioner(double hours) {
        super(hours);
    }
    String getName() {
        return "AC";
    }
    double getPowerRating() {
        return 1500.0;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }
    String getName() {
        return "TV";
    }
    double getPowerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverModeSupported {
    WashingMachine(double hours) {
        super(hours);
    }
    String getName() {
        return "WASHER";
    }
    double getPowerRating() {
        return 500.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of appliances: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        Appliance[] appliances = new Appliance[n];
        boolean[] isSaverList = new boolean[n];
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Appliance " + (i + 1) + " ---");
            System.out.print("Enter appliance input (e.g., AC 8 SAVER or FRIDGE 24): ");
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            if (parts.length < 2) {
                System.out.println("Invalid input format!");
                i--;
                continue;
            }

            String type = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length >= 3 && parts[2].equalsIgnoreCase("SAVER");
            isSaverList[i] = saver;

            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliances[i] = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliances[i] = new Television(hours);
            } else if (type.equals("WASHER")) {
                appliances[i] = new WashingMachine(hours);
            } else {
                System.out.println("Invalid appliance type!");
                i--;
            }
        }

        System.out.println("\n=== Energy Cost Report ===");
        for (int i = 0; i < n; i++) {
            if (isSaverList[i] && !(appliances[i] instanceof SaverModeSupported)) {
                System.out.printf("%s: saver mode not supported\n", appliances[i].getName());
            } else {
                double units = appliances[i].calculateUnits(isSaverList[i]);
                double cost = appliances[i].calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", appliances[i].getName(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}