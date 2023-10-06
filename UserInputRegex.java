// import apiproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;





public class UserInputRegex implements AutoCloseable {
    private String userInput;
    private String userInputToRegex;
    Scanner scanner = new Scanner(System.in);

    // Constructor that takes user input and creates a regex pattern
    public UserInputRegex() {
        System.out.print("Enter a target string: ");
        this.userInput = scanner.nextLine();
        this.userInputToRegex = Pattern.quote(userInput);
        //scanner.close();
    }
    // Function to check if the regex pattern matches the beginning of the userString
    public void justMatches() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the text: ");
            String inputText = scanner.nextLine();
            // Create a Pattern object from the userInput (treated as a regex pattern)
            Pattern pattern = Pattern.compile(userInputToRegex);
            // Create a Matcher object to match the pattern against the userString
            Matcher matcher = pattern.matcher(inputText);
            if (matcher.find()) {
                System.out.println("The target matches the user text.");
            } else {
                System.out.println("The target does not match the user text.");
            }
    
    }

    // Getter method to retrieve the user input (treated as a regex pattern)
    public String getUserInput() {
        return this.userInput;
    }
    public String getUserInputOfRegex() {
        return this.userInputToRegex;
    }
    public static String createYourRegexPattern() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to start with (optional): ");
        String startWith = scanner.nextLine();
        System.out.println("Enter the string that is in the middle (optional): ");
        String middle = scanner.nextLine();
        System.out.println("Enter the string to end with (optional): ");
        String endWith = scanner.nextLine();

        StringBuilder pattern = new StringBuilder();
        // Add the "start with" part to the pattern if provided
        if (startWith != null && !startWith.isEmpty()) {
            pattern.append("^"); // Anchor to the start of the string
            pattern.append(Pattern.quote(startWith));
             // Quote the input to escape special characters
        }
        if (middle != null && !middle.isEmpty()) {
            pattern.append(".*"); // Anchor to the start of the string
            pattern.append(Pattern.quote(middle));
            pattern.append(".*");
          }
          if (endWith != null && !endWith.isEmpty()) {
            if (middle == null || middle.isEmpty()) {
                pattern.append(".*"); // Anchor to the start of the string
            }
            pattern.append(Pattern.quote(endWith)); // Quote the input to escape special characters
            pattern.append("$"); // Anchor to the end of the string
        }
        return pattern.toString();
    }

    public static boolean isRegexPatternValid(String pattern) {
        try {
            // Attempt to compile the provided regex pattern
            Pattern.compile(pattern);
            return true; // The pattern is valid
        } catch (PatternSyntaxException e) {
            // The pattern is invalid
            return false;
        }
    }


    // Setter method to update the user input (treated as a regex pattern)
    public void setUserInput(String userInput) {
        this.userInput=userInput;
        this.userInputToRegex = Pattern.quote(userInput);
    }

    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
