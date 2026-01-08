package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class AsteroidCollision {

    /**
     * My Solution (Also Works)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if (top > -asteroid) {
                    destroyed = true;
                    break;
                } else if (top < -asteroid) {
                    stack.pop();
                } else {
                    stack.pop();
                    destroyed = true;
                }
            }

            if (!destroyed) stack.push(asteroid);
        }

        int[] res = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    /**
     * My Solution (Also Works)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid: asteroids) {
            if (asteroid >= 0) {
                stack.push(asteroid);
            } else if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                Integer finalAsteroid = asteroid;

                while (!stack.isEmpty() && finalAsteroid <= 0) {
                    int poppedAsteroid = stack.pop();

                    if (poppedAsteroid < 0) {
                        stack.push(poppedAsteroid);
                        break;
                    } else if (Math.abs(poppedAsteroid) > Math.abs(asteroid)) {
                        finalAsteroid = poppedAsteroid;
                    } else if (Math.abs(poppedAsteroid) < Math.abs(asteroid)) {
                        finalAsteroid = asteroid;
                    } else {
                        finalAsteroid = null;
                        break;
                    }
                }

                if (finalAsteroid != null)
                    stack.push(finalAsteroid);
            }
        }

        int[] res = new int[stack.size()];
        int i = 0;
        for (int asteroid: stack) {
            res[i] = asteroid;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] testCase1 = {5, 10, -5};
        int[] testCase2 = {8, -8};
        int[] testCase3 = {10, 2, -5};
        int[] testCase4 = {3, 5, -6, 2, -1, 4};
        int[] testCase5 = {-2, -1, 1, 2};

        System.out.println(Arrays.toString(asteroidCollision(testCase1)));
        System.out.println(Arrays.toString(asteroidCollision1(testCase1)));
        System.out.println(Arrays.toString(asteroidCollision(testCase2)));
        System.out.println(Arrays.toString(asteroidCollision1(testCase2)));
        System.out.println(Arrays.toString(asteroidCollision(testCase3)));
        System.out.println(Arrays.toString(asteroidCollision1(testCase3)));
        System.out.println(Arrays.toString(asteroidCollision(testCase4)));
        System.out.println(Arrays.toString(asteroidCollision1(testCase4)));
        System.out.println(Arrays.toString(asteroidCollision(testCase5)));
        System.out.println(Arrays.toString(asteroidCollision1(testCase5)));
    }
}
