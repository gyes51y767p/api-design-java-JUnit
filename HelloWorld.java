// HelloWorld.java entry point , class will be in a seperate file
package api;

public class HelloWorld {
//     public void printHello() {
//         System.out.println("Hello, World!");
//     }

    public static void main(String[] args) {
        // Create a UserInputRegex object with user-provided string (treated as a literal string)
        UserInputRegex userInputRegex = new UserInputRegex("hello");

        // Check if the pattern matches a user-provided string
        String userString = "hello, world!";
        if (userInputRegex.matchesBeginning(userString)) {
            System.out.println("The user-defined pattern matches the beginning of the user string.");
        } else {
            System.out.println("The user-defined pattern does not match the beginning of the user string.");
        }

        // Update the user input (treated as a literal string)
        userInputRegex.setUserInput("world");
        //System.out.println("Updated user input (literal string): " + userInputRegex.getUserInput());

    }
}
