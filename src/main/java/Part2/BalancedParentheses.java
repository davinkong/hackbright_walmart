package Part2;

/**
 * Write a function that takes in a string and returns true or false depending on whether that string has balanced
 * parentheses. A string has balanced parantheses if every opening paranthesis “(“
 * has a matching closing paranthesis “)”
 * that closes the corresponding opening paranthesis.
 *
 * For the purposes of this problem, you only need to worry about parentheses
 * “(“and “)”, not other opening-and-closing marks, like curly brackets, square brackets, or angle brackets.
 */

//static boolean isBalanced(String parantheses)

public class BalancedParentheses {
    public static void main(String[] args) {
        String input = "())(()";
        System.out.println(isBalanced(input));
    }
    static boolean isBalanced(String parentheses){  //O(n)
        int check = 0;
        for(int i=0; i<parentheses.length(); i++){
            if(parentheses.charAt(i) == '('){
                check += 1;
            }else if(parentheses.charAt(i) == ')'){
                check -= 1;
            }

        }
        return check == 0;
    }
}

