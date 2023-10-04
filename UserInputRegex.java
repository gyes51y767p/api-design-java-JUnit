package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;



public class UserInputRegex {
    private String userInput;

    // Constructor that takes user input and creates a regex pattern
    public UserInputRegex(String userInput) {
        this.userInput = Pattern.quote(userInput);//this will create the safe regex pattern
    }
    // Function to check if the regex pattern matches the beginning of the userString
    public boolean matches(String userString) {
        try {
            // Create a Pattern object from the userInput (treated as a regex pattern)
            Pattern pattern = Pattern.compile(userInput);

            // Create a Matcher object to match the pattern against the userString
            Matcher matcher = pattern.matcher(userString);

            return matcher.find();
        } catch (PatternSyntaxException e) {//need to fix this
            System.err.println("Invalid regex pattern syntax: " + e.getDescription());
            return false;
        }
    }

    // Getter method to retrieve the user input (treated as a regex pattern)
    public String getUserInput() {
        return userInput;
    }

    // Setter method to update the user input (treated as a regex pattern)
    public void setUserInput(String userInput) {
        this.userInput = Pattern.quote(userInput);
    }

}
