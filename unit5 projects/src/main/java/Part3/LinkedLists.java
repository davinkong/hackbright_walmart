package Part3;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * You will be given two linked lists in “reverse-digit” format.
 * For example, the number 123 would be represented in a linked list like this: 3 → 2 → 1
 * You should return the sum of these two numbers in the same “reverse-digit” format.
 * For 123 + 456, this should return 579, in the form of a linked list like this: 9 → 7 → 5.
 *
 * What is the runtime of this function?
 */
public class LinkedLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.add(1);
        l1.add(2);
        l1.add(3);

        l2.add(4);
        l2.add(5);
        l2.add(6);

        System.out.println(reverseDigit(l1, l2));
    }
    static LinkedList reverseDigit(LinkedList l1, LinkedList l2){
        //convert l1 to integer
        Iterator<Integer> list1 = l1.descendingIterator();

        int l1ToInt = 0;
        int unit = 1;
        while (list1.hasNext()){
            l1ToInt += unit * list1.next();
            unit *= 10;
        }

        //convert l2 to integer
        Iterator<Integer> list2 = l2.descendingIterator();
        int l2ToInt = 0;
        unit = 1;
        while (list2.hasNext()){
            l2ToInt += unit * list2.next();
            unit *= 10;
        }
        int sum = l1ToInt + l2ToInt;

        //convert sum to String
        String intToString = String.valueOf(sum);
        System.out.println(intToString);

        //create new linked list from the string
        LinkedList<Integer> stringToList = new LinkedList<Integer>();

        for (int i = 0; i < intToString.length(); i++) {
            stringToList.add(Character.getNumericValue(intToString.charAt(i)));
        }
        return stringToList;
    }
}
