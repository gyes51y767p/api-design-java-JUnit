// HelloWorld.java entry point , class will be in a seperate file




public class HelloWorld {
    public static void main(String[] args) {
         UserInputRegex userInputRegex = new UserInputRegex();
        userInputRegex.setUserInput("world");
        System.out.println(userInputRegex.getUserInput());
        System.out.println(userInputRegex.getUserInputOfRegex());

    }
}
