import java.util.Scanner;

public class Scorecard {
    private boolean[] results;
    private int count;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (count < results.length) {
            results[count] = isCorrect;
            count++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Scorecard scCard = new Scorecard(total);
        for (int i = 0; i < total; i++) {
            boolean ans = sc.nextBoolean();
            scCard.recordAnswer(ans);
        }
        System.out.println(scCard.getScore());
        sc.close();
    }
}