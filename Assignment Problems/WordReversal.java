public class WordReversal {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder rev = new StringBuilder(words[i]);
            rev.reverse();
            result.append(rev);
            if (i != words.length - 1) result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}