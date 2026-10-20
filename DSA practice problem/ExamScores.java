import java.util.Scanner;

public class ExamScores {
    static int findLowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int findUpperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int firstIndex = findLowerBound(scores, low);
        int lastIndex = findUpperBound(scores, high);
        return lastIndex - firstIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of student scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter " + n + " sorted scores (ascending order):");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter lower score limit (low): ");
        int low = sc.nextInt();
        System.out.print("Enter upper score limit (high): ");
        int high = sc.nextInt();

        int result = countInBand(scores, low, high);
        System.out.println("\n=== Result ===");
        System.out.println("Number of students in range [" + low + ", " + high + "]: " + result);
        sc.close();
    }
}