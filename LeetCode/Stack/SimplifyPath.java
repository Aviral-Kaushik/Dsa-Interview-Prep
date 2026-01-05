package LeetCode.Stack;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String component: path.split("/")) {
            if (component.isEmpty() || component.equals(".")) continue;

            if (component.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(component);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String testCase1 = "/home/";
        String testCase2 = "/home//foo/";
        String testCase3 = "/home/user/Documents/../Pictures";
        String testCase4 = "/../";
        String testCase5 = "/.../a/../b/c/../d/./";

        System.out.println(simplifyPath(testCase1));
        System.out.println(simplifyPath(testCase2));
        System.out.println(simplifyPath(testCase3));
        System.out.println(simplifyPath(testCase4));
        System.out.println(simplifyPath(testCase5));
    }
}
