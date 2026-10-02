import java.util.Scanner;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lockerNum = sc.nextInt();
        String initialCode = sc.next();
        Locker locker = new Locker(lockerNum, initialCode);
        String attemptCode = sc.next();
        String newCode = sc.next();
        locker.changeCode(attemptCode, newCode);
        sc.close();
    }
}