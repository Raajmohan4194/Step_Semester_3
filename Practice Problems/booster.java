public class booster {
    int[] scores = {70, 85, 60};

    void CurveScores() {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + 10;
        }
    }

    void displayScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }

    public static void main(String[] args) {
        booster b = new booster();

        b.CurveScores();
        b.displayScores();
    }
}