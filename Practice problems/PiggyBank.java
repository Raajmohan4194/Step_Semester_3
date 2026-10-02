import java.util.Scanner;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        PiggyBank pb = new PiggyBank(id);
        int dep = sc.nextInt();
        pb.deposit(dep);
        int w1 = sc.nextInt();
        pb.withdraw(w1);
        int w2 = sc.nextInt();
        pb.withdraw(w2);
        System.out.println(pb.getSavings());
        sc.close();
    }
}