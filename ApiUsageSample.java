package api;

public class ApiUsageSample {

    private static String startWith = "123";
    private static String anyString = "g";
    private static String endWith = "xyz";

    private static String literalString = ".*";

    private static String rawString = "g(oog)+le";


    public static void main(String[] args) {
        demoStartWith();
        demoEndWith();
        demoAnyString();
        demoLiteralString();
        demoRawString();
        demoRegexisValid();
        demoTrimSpace();
        demoTrimSpecialChar();
    }

    private static void demoStartWith() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setStartWithStr(startWith);
        easyRegex.printCurrentRegex();
        String inputText = "123456789xyz";
        showMatchResults(easyRegex, inputText);
    }

    private static void demoEndWith() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setEndWithStr(endWith);
        easyRegex.printCurrentRegex();
        String inputText = "123456789xyz";
        showMatchResults(easyRegex, inputText);
    }

    private static void demoAnyString() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setAnyStr(anyString);
        easyRegex.printCurrentRegex();
        String inputText = "svadhafhwfasgvgdifgasdfhasgasdfhadfuhawoefihaugfakwefaiuwfg287fhaef87q2gvcvawog2o8fgwuyqeyfgq9wefgqwvegf9";
        showMatchResults(easyRegex, inputText);
    }

    private static void demoLiteralString() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setAnyStr(literalString);
        easyRegex.printCurrentRegex();
        String inputText = "asdva.*dwqefow.*wefqewfqw.*awefqwefwfq.*wefq";
        showMatchResults(easyRegex, inputText);
    }

    private static void demoRawString() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setAnyStr(rawString);
        easyRegex.printCurrentRegex();
        String inputText = "googoogoogoogoogoogoogoogle";
        showMatchResults(easyRegex, inputText);
    }

    private static void showMatchResults(EasyRegex easyRegex, String inputText) {
        System.out.println("Match All result:" + easyRegex.matchAll(inputText));
        System.out.println("Match Any" + easyRegex.matchAny(inputText));
        System.out.println("Match Any Raw" + easyRegex.matchAnyRaw(inputText));
    }
    private static void demoRegexisValid() {
        EasyRegex easyRegex = new EasyRegex();
        String inputText = "[^good+";
        System.out.println("the regex patter you provided is: "+ easyRegex.isRegexPatternValid(inputText));
    }
    private static void demoTrimSpace() {
        EasyRegex easyRegex = new EasyRegex();
        String inputText = "   hello     !! how     are    you     ??    ";
        System.out.println("After trim space: "+ easyRegex.removeExtraSpaces(inputText));
    }
    private static void demoTrimSpecialChar() {
        EasyRegex easyRegex = new EasyRegex();
        String inputText = "   he$ /*   llo     !! how  \t   a  re    yo\nu     ??    ";
        System.out.println("After trim special char: "+ easyRegex.removeSpecialCharacters(inputText));
    }
}
