import java.util.Scanner;

abstract class Connection {
    String type;
    double units;
    Connection(String type, double units) {
        this.type = type;
        this.units = units;
    }
    abstract double calculateBill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) {
        super("HOME", units);
    }
    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) {
        super("SHOP", units);
    }
    double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) {
        super("FACTORY", units);
    }
    double calculateBill() {
        double bill = units * 6.0;
        return bill < 1000.0 ? 1000.0 : bill;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of connections: ");
        int n = sc.nextInt();
        Connection[] list = new Connection[n];
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Connection " + (i + 1) + " ---");
            System.out.print("Enter connection type (HOME / SHOP / FACTORY): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter units consumed: ");
            double units = sc.nextDouble();

            if (type.equals("HOME")) {
                list[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                list[i] = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                list[i] = new FactoryConnection(units);
            } else {
                System.out.println("Invalid connection type!");
                i--;
            }
        }

        System.out.println("\n=== Electricity Bill Summary ===");
        for (int i = 0; i < n; i++) {
            double bill = list[i].calculateBill();
            System.out.printf("%s: %.2f\n", list[i].type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}