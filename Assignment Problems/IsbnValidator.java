public class IsbnValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String first3 = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return first3 + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: length must be 13 characters";
        }
        String pub = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < pub.length(); i++) {
            if (!Character.isLetter(pub.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);
        StringBuilder display = new StringBuilder();
        display.append("[").append(pub).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return display.toString();
    }

    public static void main(String[] args) {
        String norm = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(norm));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}