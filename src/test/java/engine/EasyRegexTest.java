package engine;

import exception.InvalidPatternException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EasyRegexTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private EasyRegex easyRegex;

    @BeforeEach
    void setUp() {
        easyRegex = new EasyRegex();
        easyRegex.setStartWithStr("abc");
        easyRegex.setEndWithStr("123");
        easyRegex.setAnyStr("xyz");
    }

    @Test
    void printCurrentRegex() {
        System.setOut(new PrintStream(outputStreamCaptor));
        easyRegex.printCurrentRegex();
        assertEquals("^abc.*xyz.*123$", outputStreamCaptor.toString().trim());
    }

    @Test
    void testMatchAll() {
        assertTrue(easyRegex.matchAll("abc 242feadv xyz 20fwe 123"));
        assertFalse(easyRegex.matchAll("a242fadv yz 20fwe 1"));
    }

    @Test
    void testMatchAllException() {
        System.setOut(new PrintStream(outputStreamCaptor));
        easyRegex.setAnyStr("[Error");
        easyRegex.matchAll("31fi3hg9qehre");
        // No possible error code printed since all strings are quoted.
        assertEquals("", outputStreamCaptor.toString().trim(), "No error should be printed since strings are quoted!");

    }
    @Test
    void matchAnyIndex() {
        easyRegex.setStartWithStr("");
        easyRegex.setEndWithStr("");
        List<Integer> matchIndexes = easyRegex.matchAnyIndex("xyzavopsjd92fhxyzpjwpvjqpivhxyzwv983h4xyz2f");
        assertEquals(4, matchIndexes.size(), "Matches should be exactly 4!");
    }

    @Test
    void matchAnyRaw() {
        easyRegex.setAnyStr("g(oog)+le");
        List<Integer> matchIndexes = easyRegex.matchAnyRaw("googoogoogoogoogoogoogooglegoogoogooglegooglegogle");
        assertEquals(3, matchIndexes.size(), "Should be exactly 3 matches!");
        assertEquals(0, matchIndexes.get(0), "First match at 0!");
        assertEquals(27, matchIndexes.get(1), "Second match at 27!");
        assertEquals(39, matchIndexes.get(2), "Third match at 39!");
    }

    @Test
    void isRegexPatternValid() throws InvalidPatternException {
        assertTrue(EasyRegex.isRegexPatternValid("g(oog)+le"));
        assertThrows(InvalidPatternException.class,() -> EasyRegex.isRegexPatternValid("[Error"));
    }

    @Test
    void removeExtraSpaces() throws InvalidPatternException {
        assertEquals("a bcd e f g", EasyRegex.removeExtraSpaces(" a bcd   e f g     "));
    }

    @Test
    void removeSpecialCharacters() {
        assertEquals(" he llo how a re yo u ", EasyRegex.removeSpecialCharacters("   he$ /*   llo     !! how  \t   a  re    yo\nu     ??    "));
    }

}