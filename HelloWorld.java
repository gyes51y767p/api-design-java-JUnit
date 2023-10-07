// HelloWorld.java entry point , class will be in a seperate file




public class HelloWorld {
    public static void main(String[] args) {
        
        String a= UserInputRegex.removeSpecialCharacters( "Hello,        \\t\\n" + //
                "\\s!@ W\\n" + //
                "orld! Th@#is is a tes$%^&)(\\t string 123." );
        System.out.println(a);
        

        //  try(UserInputRegex userInputRegex = new UserInputRegex()){ 
        //  //userInputRegex.justMatches();
        // String originalinputRegex=userInputRegex.getUserInputOfRegex();
        // System.out.println(originalinputRegex);

        //  String creatYourPattern=userInputRegex.createYourRegexPattern();
        //  System.out.println(creatYourPattern);
        //  }

    }
}
