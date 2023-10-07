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

    private String generateRegexExpressionString() {
        StringBuilder sb = new StringBuilder();
        if(!startWithStr.isEmpty()) {
            sb.append("^").append(startWithStr);
        }
        if(!anyStr.isEmpty()) {
            sb.append(".*").append(anyStr).append(".*");
        } else {
            sb.append(".*");
        }
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

    public List<Integer> matchAny(String inputString) {
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

}