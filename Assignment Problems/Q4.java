import java.util.Scanner;

abstract class Employee {
    String name;
    double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return 2000.0;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else {
                employees[i] = new InternEmployee(name, salary);
            }
        }

        double grandTotal = 0;
        for (int i = 0; i < employees.length; i++) {
            double bonus = employees[i].calculateBonus();
            grandTotal += bonus;
            System.out.printf("%s: %.2f\n", employees[i].getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotal);
        sc.close();
    }
}