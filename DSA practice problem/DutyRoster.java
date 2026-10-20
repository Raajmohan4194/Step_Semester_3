import java.util.Scanner;

public class DutyRoster {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        String[] rotated = new String[n];
        int shift = (int) (k % n);

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons on the roster: ");
        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        System.out.print("Enter number of rotation steps (k): ");
        long k = sc.nextLong();

        String[] result = rotateRoster(names, k);

        System.out.print("\nRotated Roster: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}