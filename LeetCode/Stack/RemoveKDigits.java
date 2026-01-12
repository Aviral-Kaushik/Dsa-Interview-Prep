package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char character : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > character) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || character != '0') stack.push(character);
        }

        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }

        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }

}
