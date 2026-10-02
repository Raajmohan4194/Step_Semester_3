import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be positive.");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percent must be between 0 and 100.");
        } else {
            basicSalary -= basicSalary * (percent / 100.0);
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        PayrollAccount acc = new PayrollAccount(salary);
        double bonus = sc.nextDouble();
        acc.creditBonus(bonus);
        double tax = sc.nextDouble();
        acc.deductTax(tax);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
        sc.close();
    }
}