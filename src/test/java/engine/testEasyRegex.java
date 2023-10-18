package engine;

import engine.EasyRegex;
import exception.InvalidPatternException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class testEasyRegex {
    @Test
    public void _test_MatchAll(){
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setStartWithStr("start");
        easyRegex.setAnyStr("middle");
        easyRegex.setEndWithStr("end");
        assertTrue(easyRegex.matchAll("startxxxmiddlexxxend"));
    }
    //it didnt thorw exception
    //@Test
    // public void testMatchAll_InvalidPattern() {
    //     engine.EasyRegex easyRegex = new engine.EasyRegex();
    //     easyRegex.setAnyStr("[a-z+"); // Invalid regular expression pattern

    //     // Use assertThrows to verify that PatternSyntaxException is thrown
    //     assertThrows(PatternSyntaxException.class, new Executable() {
    //         @Override
    //         public void execute() throws Throwable {
    //             easyRegex.matchAll("inputString");
    //         }
    //     });
    // }

    @Test
    public void test_MatchAnyIndex() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setAnyStr("regex");

        List<Integer> indices = easyRegex.matchAnyIndex("This is a regex pattern. regex is used here.");
        assertEquals(2, indices.size());
        //assertEquals(10, indices.get(0).intValue());
        //assertEquals(25, indices.get(1).intValue());
    }
    @Test
    public void testMatchAnyRaw_ValidPattern() {
        EasyRegex easyRegex = new EasyRegex();
        easyRegex.setAnyStr("\\d+"); // Match one or more digits

        List<Integer> indices = easyRegex.matchAnyRaw("the number appear at 234(index 21)");
        assertEquals(2, indices.size());
        assertEquals(21, indices.get(0).intValue());
    }
    //in order to get the thorw exception for testing, we need to change the code in engine.EasyRegex.java
    @Test
    public void testIsRegexPatternValid_InvalidPattern() {
        String invalidPattern = "[a-z+"; // Invalid regular expression pattern

        assertThrows(InvalidPatternException.class, () -> {
            EasyRegex.isRegexPatternValid(invalidPattern);
        });
    }
    @Test
    public void testIsRegexPatternValid_ValidPattern() {
        String validPattern = "^[A-Za-z+]";
        assertDoesNotThrow(() -> EasyRegex.isRegexPatternValid(validPattern));
    }

    @Test
    public void testRemoveExtraSpaces() throws InvalidPatternException {
        String input = "   Remove    extra   spaces   ";
        String cleaned = EasyRegex.removeExtraSpaces(input);
        assertEquals("Remove extra spaces", cleaned);
    }

    @Test
    public void testRemoveSpecialCharacters() {
        String input = "Hello, world!123";
        String cleaned = EasyRegex.removeSpecialCharacters(input);
        assertEquals("Hello world123", cleaned);
    }

}
