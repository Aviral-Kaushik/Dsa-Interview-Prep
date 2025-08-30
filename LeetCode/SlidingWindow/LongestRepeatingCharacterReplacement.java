package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    /**
     * My Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int longestSubString = 0;
        int maxCount = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            int frequency = freqMap.getOrDefault(endChar, 0) + 1;
            freqMap.put(endChar, frequency);
            maxCount = Math.max(maxCount, frequency);

            if (end - start + 1 - maxCount > k) {
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                start++;
            }

            longestSubString = Math.max(longestSubString, end - start + 1);
        }

        return longestSubString;
    }

    /**
     * Chat-GPT Solution (More Faster as uses array instead of hashmaps.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int characterReplacementChatGPT(String s, int k) {
        int[] freq = new int[26]; // frequency array for A-Z
        int start = 0;
        int maxCount = 0; // stores the count of the most frequent character in the window
        int longestSubString = 0;

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freq[endChar - 'A']++;
            maxCount = Math.max(maxCount, freq[endChar - 'A']);

            // if window length - maxCount > k, shrink from the left
            while (end - start + 1 - maxCount > k) {
                char startChar = s.charAt(start);
                freq[startChar - 'A']--;
                start++;
            }

            longestSubString = Math.max(longestSubString, end - start + 1);
        }

        return longestSubString;
    }
}
