package LeetCode.Stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char character: s.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) return false;

                char poppedChar = stack.pop();

                if (!matching(character, poppedChar)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean matching(char a, char b) {
        return (b == '(' && a == ')') || (b == '{' && a == '}') || (b == '[' && a == ']');
    }

}
