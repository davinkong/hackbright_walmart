package Part2;

import java.util.HashMap;
import java.util.Stack;

/**
 * Write a function that takes in a string and returns true or false based on whether the string’s
 * opening-and-closing marks (that is, brackets) are balanced. Account for the following bracket types:
 * Parentheses ( )
 * Curly Braces { }
 * Square Brackets [ ]
 * Angle Brackets < >
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "";
        System.out.println(isBalanced(input));
    }
    public static boolean isBalanced(String brackets){
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> pair = new HashMap<Character, Character>();
        //a key, a value
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        pair.put('>', '<');
        for (int i=0; i<brackets.length(); i++){
            //if character contains opening bracket or known as value in HashMap pair:
            if (pair.containsValue(brackets.charAt(i))){
                stack.push(brackets.charAt(i));
            }
            //if character is closing bracket or known as key in HashMap key:
            else if (pair.containsKey(brackets.charAt(i))) {
                //check if there is only a closing bracket without a matching opening bracket
                if(stack.isEmpty()){
                    return false;
                }
                //pop
                var match = stack.pop();
                //if most recent bracket on stack matches
                if(!match.equals(pair.get(brackets.charAt(i)))){
                    return false;
                }
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}
/**
 * The runtime complexity is linear, as each it iterates through each character in the string.
 * In each iteration, methods called like contains(), pop(), charAt(), and get() all take constant time.
 */