import java.util.Scanner;

abstract class Staff {
    String name;
    Staff(String name) {
        this.name = name;
    }
    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;
    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    double hours;
    double rate;
    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    double stipend;
    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    double calculatePay() {
        return stipend;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of staff members: ");
        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Staff Member " + (i + 1) + " ---");
            System.out.print("Enter staff type (FULLTIME / HOURLY / INTERN): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter staff name: ");
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                System.out.print("Enter fixed weekly salary: ");
                double salary = sc.nextDouble();
                staffList[i] = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                System.out.print("Enter hours worked: ");
                double hours = sc.nextDouble();
                System.out.print("Enter hourly rate: ");
                double rate = sc.nextDouble();
                staffList[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                System.out.print("Enter stipend amount: ");
                double stipend = sc.nextDouble();
                staffList[i] = new InternStaff(name, stipend);
            } else {
                System.out.println("Invalid staff type. Please try again.");
                i--;
                continue;
            }

            double pay = staffList[i].calculatePay();
            totalPayroll += pay;
            System.out.printf("Weekly pay for %s: %.2f%n", name, pay);
        }

        System.out.printf("Total weekly payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}