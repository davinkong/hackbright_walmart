import static org.junit.Assert.*;

import Part2.BalancedBrackets;
import org.junit.Test;

public class BalancedBracketsTest {
    String balancedParens = "(1)";
    String tooManyOpenParens = "((1";
    String tooManyOpenParens1 = "(1)(";
    String tooManyClosedParens = "(1))";
    String startClosedParens = ")(";
    String emptyString = "";
    String balancedAngleBrackets = "<<>>";
    String balancedComboBrackets = "<({})>";
    String mismatchedBrackets = "<({)}>";

    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_balancedParens() {
        assertTrue(bb.isBalanced("(1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyOpenParens() {
        assertFalse(bb.isBalanced("({1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyClosedParens() {
        assertFalse(bb.isBalanced("({1})>"));
    }

    @Test
    public void testBalancedBrackets_startWithClosedParens() {
        assertFalse(bb.isBalanced(")("));
    }

    @Test
    public void testBalancedBrackets_emptyString() {
        assertTrue(bb.isBalanced(""));
    }

    @Test
    public void testBalancedBrackets_balancedComboBrackets() {
        assertTrue(bb.isBalanced("<({})>"));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets() {
        assertTrue(bb.isBalanced("<({)}>"));
    }

}
