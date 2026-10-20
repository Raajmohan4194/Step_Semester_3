import java.util.Scanner;

public class SecondHighestScore {
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second && score < highest) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of player scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = sc.nextInt();
        }

        int result = secondHighest(scores);
        System.out.println("\n=== Result ===");
        System.out.println("Second-Highest Score: " + result);
        sc.close();
    }
}