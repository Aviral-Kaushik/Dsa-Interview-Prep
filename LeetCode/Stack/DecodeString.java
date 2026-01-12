package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DecodeString {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public String decodeStringOptimized(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int num = 0;

        for (char character: s.toCharArray()) {
            if (Character.isDigit(character)) {
                num = num * 10 + (character - '0');
            } else if (character == '[') {
                stack.push(String.valueOf(num));
                num = 0;
                stack.push("[");
            } else if (character == ']') {
                StringBuilder temp = new StringBuilder();

                while (!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }
                stack.pop();

                int number = Integer.parseInt(stack.pop());

                String expanded = temp.toString().repeat(number);
                stack.push(expanded);
            } else {
                stack.push(String.valueOf(character));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(n)
     * */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ']') {
                stack.push(current);
            } else {
                StringBuilder temp = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.append(stack.pop());
                }

                temp.reverse();
                stack.pop();

                StringBuilder numberString = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numberString.insert(0, stack.pop());
                }

                int number = Integer.parseInt(numberString.toString());
                StringBuilder repeat = new StringBuilder();

                repeat.append(String.valueOf(temp).repeat(Math.max(0, number)));

                for (char character: repeat.toString().toCharArray()) {
                    stack.push(character);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        result.reverse();

        return result.toString();
    }
}
