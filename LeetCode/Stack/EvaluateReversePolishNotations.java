package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotations {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens) {
            if (isOperator(token)) {
                int operandB = stack.pop();
                int operandA = stack.pop();
                int result;

                if (token.equals("+")) {
                    result = operandA + operandB;
                } else if (token.equals("-")) {
                    result = operandA - operandB;
                } else if (token.equals("*")) {
                    result = operandA * operandB;
                } else {
                    result = operandA / operandB;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }
}
