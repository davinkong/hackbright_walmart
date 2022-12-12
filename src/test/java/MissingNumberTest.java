import Part1.MissingNumber;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class MissingNumberTest {
    private List<Integer> missingMax =  List.<Integer>of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private List<Integer> missingNone =  List.<Integer>of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private List<Integer> missingSeven =  List.<Integer>of(1, 2, 3, 4, 5, 6, 8, 9, 10);

    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_MissingMax() {
        assertEquals(10, mn.findMissingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, mn.findMissingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(7, mn.findMissingNumber(missingSeven, 10));
    }
}
