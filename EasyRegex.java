package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;



public class EasyRegex {

    private String startWithStr;
    private String endWithStr;
    private String anyStr;

    public EasyRegex() {
        startWithStr = "";
        anyStr = "";
        endWithStr = "";
    }
    public String getStartWithStr() {
        return startWithStr;
    }

    public void setStartWithStr(String startWithStr) {
        this.startWithStr = startWithStr;
    }

    public String getEndWithStr() {
        return endWithStr;
    }

    public void setEndWithStr(String endWithStr) {
        this.endWithStr = endWithStr;
    }

    public String getAnyStr() {
        return anyStr;
    }

    public void setAnyStr(String anyStr) {
        this.anyStr = anyStr;
    }

    public void printCurrentRegex() {
        System.out.println(generateRegexExpressionString());
    }

    private String generateRegexExpressionString() {//change name to generateRegexPattern
        StringBuilder sb = new StringBuilder();
        //replace line 58-60
        // if (startWithStr != null && !startWithStr.isEmpty()) {
        //     sb.append("^"); // Anchor to the start of the string
        //     sb.append(Pattern.quote(startWithStr));
        // }
        if(!startWithStr.isEmpty()) {
            sb.append("^").append(startWithStr);
        }
        //replace line 67-71
        // if (anyStr != null && !anyStr.isEmpty()) {
        //     sb.append(".*"); // Anchor to the start of the string
        //     sb.append(Pattern.quote(anyStr));
        //     sb.append(".*");
        //   }
        if(!anyStr.isEmpty()) {
            sb.append(".*").append(anyStr).append(".*");
        } else {
            sb.append(".*");
        }
        //replace 80 -83
        // if (endWithStr != null && !endWithStr.isEmpty()) {
        //     if (anyStr == null || anyStr.isEmpty()) {
        //         sb.append(".*"); // Anchor to the start of the string
        //     }
        //     sb.append(Pattern.quote(endWithStr)); // Quote the input to escape special characters
        //     sb.append("$"); // Anchor to the end of the string
        // }
        if(!endWithStr.isEmpty()) {
            sb.append(endWithStr).append("$");
        }
        return sb.toString();
    }

    private Pattern generateRegexPatternRaw() {
        return Pattern.compile(anyStr);
    }

    private Pattern generateRegexPatternForAny() {
        return Pattern.compile(Pattern.quote(anyStr));
    }

    private Pattern generateRegexPatternForAll() {
        StringBuilder sb = new StringBuilder();
        if(!startWithStr.isEmpty()) {
            sb.append("^").append(Pattern.quote(startWithStr));
        }
        if(!anyStr.isEmpty()) {
            sb.append(".*").append(Pattern.quote(anyStr)).append(".*");
        } else {
            sb.append(".*");
        }
        if(!endWithStr.isEmpty()) {
            sb.append(Pattern.quote(endWithStr)).append("$");
        }
        return Pattern.compile(sb.toString());
    }

    public boolean matchAll(String inputString) {
        try {
            Pattern pattern = generateRegexPatternForAll();
            return pattern.matcher(inputString).matches();
        } catch (PatternSyntaxException e) {
            System.out.println("There are errors with your regex, please try again: " + e.getMessage());
            return false;
        }
    }

    public List<Integer> matchAny(String inputString) {//could we change the name to mathAny name to matchAnyIndex
        try {
            Pattern pattern = generateRegexPatternForAny();
            List<Integer> matchedIndex = new ArrayList<>();
            Matcher matcher = pattern.matcher(inputString);
            while (matcher.find()) {
                matchedIndex.add(matcher.start());
            }
            return matchedIndex;
        } catch (PatternSyntaxException e) {
            System.out.println("There are errors with your regex, please try again: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Integer> matchAnyRaw(String inputString) {
        try {
            Pattern pattern = generateRegexPatternRaw();
            List<Integer> matchedIndex = new ArrayList<>();
            Matcher matcher = pattern.matcher(inputString);
            while (matcher.find()) {
                matchedIndex.add(matcher.start());
            }
            return matchedIndex;
        } catch (PatternSyntaxException e) {
            System.out.println("There are errors with your regex, please try again: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    public static boolean isRegexPatternValid(String pattern) {
        try {
            Pattern.compile(pattern);
            return true; // The pattern is valid
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
    public static String removeExtraSpaces(String input) {
        if (input != null && !input.isEmpty()) {
        // Remove extra spaces and tabs using regular expression
        String cleanedString = input.replaceAll("\\s+", " ");
        // Print the cleaned string
        return cleanedString;
        }
    return "Invalid input";
    }
    public static String removeSpecialCharacters(String input) {
        if (input != null && !input.isEmpty()) {
        String cleanedString = input.replaceAll("[^a-zA-Z0-9\\s]+", "").replaceAll("\\s+", " ");
            return cleanedString;
        }
    return "Invalid input";
    }

}
