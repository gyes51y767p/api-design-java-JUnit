// import apiproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;




public class UserInputRegex {
    private String userInput;
    private String userInputToRegex;

    // Constructor that takes user input and creates a regex pattern
    public UserInputRegex() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a target string: ");
        this.userInput = scanner.nextLine();
        this.userInputToRegex = Pattern.quote(userInput);
        matches();
        scanner.close();

    }
    // Function to check if the regex pattern matches the beginning of the userString
    public void matches() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the text: ");
            String inputText = scanner.nextLine();
            // Create a Pattern object from the userInput (treated as a regex pattern)
            Pattern pattern = Pattern.compile(userInputToRegex);
            // Create a Matcher object to match the pattern against the userString
            Matcher matcher = pattern.matcher(inputText);
            scanner.close();
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

    // Setter method to update the user input (treated as a regex pattern)
    public void setUserInput(String userInput) {
        this.userInput=userInput;
        this.userInputToRegex = Pattern.quote(userInput);
    }

}
