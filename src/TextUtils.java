import java.util.StringTokenizer;

public class TextUtils {

    public final static String STATISTICS = "statistics";
    public final static String PALINDROME = "palindrome";

    private TextUtils() {
    }

    public static String getHtmlReportFromTextStatistics(String textArea) {
        char[] ch = textArea.toCharArray();
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < textArea.length(); i++) {
            if (Character.isLetter(ch[i])) {
                letter++;
            } else if (Character.isDigit(ch[i])) {
                num++;
            } else if (Character.isSpaceChar(ch[i])) {
                space++;
            } else {
                other++;
            }
        }
        return "<b>Tekst:</b><br><i>" + textArea + "</i>" +
                "<br><br>Składa się z:" +
                "<br>Liter: " + letter +
                "<br>Spacji: " + space +
                "<br>Liczb: " + num +
                "<br>Inne: " + other +
                "<br>Wszystkie znaki: " + textArea.length() +
                "<br>Ilość słów: " + countWordsUsingStringTokenizer(textArea);
    }

    public static String getHtmlReportFromTextPalindomeCheck(String textArea) {
        if (isPalindrome(textArea)) {
            return "<b>Tekst:</b><br><i>" + textArea + "</i>" +
                    "<br><br>Jest palindomem!";
        } else {
            return "<b>Tekst:</b><br><i>" + textArea + "</i>" +
                    "<br><br>Nie jest palindomem. <a href='https://pl.wikipedia.org/wiki/Palindrom'>Czym jest palindrom?</a>";
        }
    }

    private static int countWordsUsingStringTokenizer(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(sentence);
        return tokens.countTokens();
    }

    private static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
