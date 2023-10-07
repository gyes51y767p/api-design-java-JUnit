// Purpose: Test the UserInputclass class
import org.junit.*;

public class testUserInputclass {
    @Test
    public void testRemovespace() {
        Assert.assertEquals("Hello, !@ W orld! Th@#is is a tes$%^&)( string 123.",
        UserInputRegex.RemoveExtraSpaces
        ("Hello,        \t\n\s!@ W\norld! Th@#is is a tes$%^&)(\t string 123."));
    }
    @Test
    public void testIsValid(){
        Assert.assertEquals(false, 
        UserInputRegex.isRegexPatternValid
        ("[a-zA"));
    }
    @Test
    public void testIsValid2(){
        Assert.assertEquals(true, 
        UserInputRegex.isRegexPatternValid
        ("[a-zA-Z]"));
    }
}
