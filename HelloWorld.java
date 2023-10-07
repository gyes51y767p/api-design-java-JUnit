// HelloWorld.java entry point , class will be in a seperate file
package api;
import java.util.Scanner;


public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a target string: ");
        String userInput = scanner.nextLine();
        // Create a UserInputRegex object with user-provided string (treated as a literal string)
        UserInputRegex userInputRegex = new UserInputRegex(userInput);
        
        System.out.print("Enter a text: ");
        String inputText = scanner.nextLine();
        scanner.close();

        // Check if the pattern matches a user-provided string
        //String userString = "hello, world!";
        if (userInputRegex.matches(inputText)) {
            System.out.println("The target matches the user text.");
        } else {
            System.out.println("The target does not match the user text.");
        }

        // Update the user input (treated as a literal string)
        userInputRegex.setUserInput("world");
        //System.out.println("Updated user input (literal string): " + userInputRegex.getUserInput());

    }
}
