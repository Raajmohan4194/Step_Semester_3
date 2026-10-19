import java.util.Scanner;

interface BusUser {
    default double getTransportFee() {
        return 12000.0;
    }
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholarStudent extends Student implements BusUser {
    DayScholarStudent(String name) {
        super(name);
    }
    double calculateFee() {
        return 40000.0 + getTransportFee();
    }
}

class HostellerStudent extends Student {
    HostellerStudent(String name) {
        super(name);
    }
    double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }
    double calculateFee() {
        return 20000.0 + getTransportFee();
    }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter student category (DAY_SCHOLAR / HOSTELLER / SCHOLAR): ");
            String type = sc.next().toUpperCase();
            System.out.print("Enter student name: ");
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholarStudent(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new HostellerStudent(name);
            } else if (type.equals("SCHOLAR")) {
                students[i] = new ScholarshipStudent(name);
            } else {
                System.out.println("Invalid student type!");
                i--;
            }
        }

        System.out.println("\n=== Fee Report ===");
        for (int i = 0; i < n; i++) {
            double fee = students[i].calculateFee();
            System.out.printf("%s: %.2f\n", students[i].name, fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}