import java.util.Scanner;
import java.util.ArrayList;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();
    public abstract double grade();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public String getType() {
        return "MCQ";
    }

    public double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public String getType() {
        return "TF";
    }

    public double grade() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    public String getType() {
        return "ESSAY";
    }

    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();

        for (int i = 0; i < keywords.length; i++) {
            String keyword = keywords[i].trim().toLowerCase();
            if (lowerStudentAnswer.contains(keyword)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            ArrayList<String> tokens = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            boolean inQuotes = false;

            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '\"') {
                    inQuotes = !inQuotes;
                } else if (ch == ' ' && !inQuotes) {
                    if (current.length() > 0) {
                        tokens.add(current.toString());
                        current.setLength(0);
                    }
                } else {
                    current.append(ch);
                }
            }
            if (current.length() > 0) {
                tokens.add(current.toString());
            }

            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            int points = Integer.parseInt(tokens.get(4));

            if (type.equalsIgnoreCase("MCQ")) {
                questions[i] = new MCQQuestion(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equalsIgnoreCase("TF")) {
                questions[i] = new TFQuestion(questionText, correctAnswer, studentAnswer, points);
            } else {
                questions[i] = new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
            }
        }

        double overallScore = 0;
        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade();
            overallScore += score;
            System.out.printf("%s: %.2f\n", questions[i].getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", overallScore);
        sc.close();
    }
}