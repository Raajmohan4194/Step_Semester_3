import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    String getType() {
        return "Staff";
    }

    double getBonus() {
        return 0.0;
    }

    double getTotal() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    String getType() {
        return "Teacher";
    }

    @Override
    double getBonus() {
        return 5000.0;
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    String getType() {
        return "LabAssistant";
    }

    @Override
    double getBonus() {
        return 2000.0;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter type, name and base salary: ");
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staffList[i] = new Teacher(name, base);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staffList[i] = new LabAssistant(name, base);
            } else {
                staffList[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0.0;
        for (Staff s : staffList) {
            double total = s.getTotal();
            grandTotal += total;
            System.out.println(s.name + " (" + s.getType() + "): base " + s.baseSalary + ", bonus " + s.getBonus() + ", total " + total);
        }
        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}