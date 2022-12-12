package Part3;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the index of an item in a list using recursion.
 *
 * Implement a function that takes in an item and an array of items, and returns the 0-based index of a sought item: >>> recursive_search(“hey”, [“hey”, “there”, “you”]) 0
 *
 * If the item isn’t in the list, return -1: >>> recursive_search(“porcupine”, [“hey”, “there”, “you”]) -1
 *
 * Important: Solve this problem only with recursion—you cannot use a for or while loop in your solution!
 */
public class Recursion {
    public static void main(String[] args) {
        var list = List.of("hey", "there", "you");
        var result = recursiveIndex("there", list);
        System.out.println(result);
    }

    static int recursiveIndex(String item, List<String> list) {
        if (list.size() == 0) { return -1; }
        if (list.get(0).equals(item)) { return 0; }

        var subList = new ArrayList<>(list);
        subList.remove(0);
        var indexInSublist = recursiveIndex(item, subList);

        if (indexInSublist == -1) { return -1; }
        else { return indexInSublist + 1; }
    }

}
