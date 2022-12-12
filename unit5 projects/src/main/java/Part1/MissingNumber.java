package Part1;

import java.util.*;

/**
 * Imagine a list of numbers from 1 to max_num, inclusive - except that one of these numbers will be missing from the list.
 *
 * Write a function that takes this list of numbers, as well as the max_num, and it should return the missing number.
 *
 * For example, given a list of numbers, in random order, of 1…10, 8 was removed. If this list and the maxNum of 10
 * was passed into the function, it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
 *
 * If there is no missing number, the function should return 0.
 */


    //return missingNumber
public class MissingNumber {
    public static void main(String[] args) {
        var input =  List.<Integer>of(2, 1, 4, 3, 6, 5, 7, 10, 9, 8);
        System.out.println(findMissingNumber(input, 10));

        int[] sortInput = {2, 1, 4, 3, 6, 5, 7, 10, 9, 8};
        System.out.println(findMissingNumberSort(sortInput, 10));

    }
    public static int findMissingNumber(List<Integer> list, int maxNum) {

        for(int i=1; i<=maxNum; i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return 0;
    }

    public static int findMissingNumberSort(int[] list, int maxNum) {
        Arrays.sort(list);
        for (int i = 1; i < maxNum; i += 1) {
            if (i != list[i - 1]) {
                return i;
            }
        }


        if (list.length == maxNum && list[maxNum - 1] == maxNum) {
            return 0;
        }
        return maxNum;
    }
}
