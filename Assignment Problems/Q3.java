import java.util.Scanner;

abstract class Room {
    int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract String getType();
    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    public String getType() {
        return "SINGLE";
    }

    public double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    public String getType() {
        return "SHARED";
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    public String getType() {
        return "AC";
    }

    public double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equalsIgnoreCase("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else {
                rooms[i] = new ACRoom(units);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < rooms.length; i++) {
            double bill = rooms[i].calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", rooms[i].getType(), bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}