package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {


    /// Problem Statement
    /// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
    ///
    /// Since the result may be very large, so you need to return a string instead of an integer.

    /**
     * Efficient Method
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * */
    public String largestNumber(int[] nums) {
        ArrayList<String> numbers = new ArrayList<>();

        for (int num: nums) {
            numbers.add(Integer.toString(num));
        }

        Collections.sort(numbers, (s1, s2) -> compare(s1, s2) ? - 1: 1);

        if (numbers.get(0).equals("0"))
            return "0";

        StringBuilder result = new StringBuilder();

        for (String number: numbers) {
            result.append(number);
        }

        return result.toString();
    }

    private boolean compare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }
}
