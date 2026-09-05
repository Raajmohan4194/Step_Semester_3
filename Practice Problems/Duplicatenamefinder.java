import java.util.Scanner;

public class Duplicatenamefinder {
    Scanner sc = new Scanner(System.in);
    String[] names;
    int n;

    void getNames() {
        System.out.println("Enter the number of names:");
        n = sc.nextInt();

        names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
    }

    void findDuplicates() {
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    System.out.println("Duplicate name found: " + names[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Duplicatenamefinder dnf = new Duplicatenamefinder();

        dnf.getNames();
        dnf.findDuplicates();
    }
}