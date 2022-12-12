import static org.junit.Assert.*;

import Part1.MissingNumber;
import org.junit.Test;

import java.util.List;

public class MissingNumberPerformanceTest {

    private List<Integer> missingMax =  List.<Integer>of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private List<Integer> missingNone =  List.<Integer>of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private List<Integer> missingSeven =  List.<Integer>of(1, 2, 3, 4, 5, 6, 8, 9, 10);

    private int[] missingMaxSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNoneSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSevenSort = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private int max = 10;
    private MissingNumber mn = new MissingNumber();

    @Test(timeout=200)
    public void testMissingNumber_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNumber(missingMax, max);
            mn.findMissingNumber(missingNone, max);
            mn.findMissingNumber(missingSeven, max);
        }
    }

    @Test(timeout=100)
    public void testMissingNumberSort_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.findMissingNumberSort(missingMaxSort, max);
            mn.findMissingNumberSort(missingNoneSort, max);
            mn.findMissingNumberSort(missingSevenSort, max);
        }
    }


}