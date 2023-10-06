// HelloWorld.java entry point , class will be in a seperate file




public class HelloWorld {
    public static void main(String[] args) {
         try(UserInputRegex userInputRegex = new UserInputRegex()){ 
         //userInputRegex.justMatches();
        String originalinputRegex=userInputRegex.getUserInputOfRegex();
        System.out.println(originalinputRegex);

         String creatYourPattern=userInputRegex.createYourRegexPattern();
         System.out.println(creatYourPattern);
         }

    }
}
