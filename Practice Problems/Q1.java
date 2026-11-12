import java.util.Scanner;

public class Q1 {
    public static String findBook(String[][] catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] catalog = new String[n][2];
        for (int i = 0; i < n; i++) {
            catalog[i][0] = sc.nextLine().trim();
            catalog[i][1] = sc.nextLine().trim();
        }
        String targetIsbn = sc.nextLine().trim();
        System.out.println(findBook(catalog, targetIsbn));
        sc.close();
    }
}