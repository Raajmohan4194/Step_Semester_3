import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : ""));
        }
        System.out.println();
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }
        int[] res = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(res));
        sc.close();
    }
}