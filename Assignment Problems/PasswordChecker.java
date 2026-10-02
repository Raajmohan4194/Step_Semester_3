import java.util.Scanner;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputPassword = sc.next();
        PasswordChecker pc = new PasswordChecker(inputPassword);
        System.out.println(pc.getStrength());
        sc.close();
    }
}