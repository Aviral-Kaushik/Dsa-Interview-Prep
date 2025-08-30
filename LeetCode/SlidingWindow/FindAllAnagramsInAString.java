package LeetCode.SlidingWindow;

import java.util.*;

public class FindAllAnagramsInAString {

    /**
     * My Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1) as O(26) = O(1)
     * */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())
            return new ArrayList<>();

        Map<Character, Integer> sFreqMap = new HashMap<>();
        Map<Character, Integer> pFreqMap = new HashMap<>();
        List<Integer> startIndicies = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pFreqMap.put(p.charAt(i), pFreqMap.getOrDefault(p.charAt(i), 0) + 1);
            sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (sFreqMap.equals(pFreqMap))
            startIndicies.add(0);

        int start = 0;
        for (int end = p.length(); end < s.length(); end++) {
            char endChar = s.charAt(end);
            sFreqMap.put(endChar, sFreqMap.getOrDefault(endChar, 0) + 1);

            char startChar = s.charAt(start);
            sFreqMap.put(startChar, sFreqMap.get(startChar) - 1);

            if (sFreqMap.get(startChar) == 0)
                sFreqMap.remove(startChar);

            start++;

            if (sFreqMap.equals(pFreqMap))
                startIndicies.add(start);
        }

        return startIndicies;
    }

    /**
     * Chat-GPT Solution (More Faster as uses array instead of hashmaps.
     * Time Complexity: O(n)
     * Space Complexity: O(1) as O(26) = O(1)
     * */
    public List<Integer> findAnagramsChatGPT(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, sFreq)) result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            sFreq[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pFreq, sFreq)) result.add(i - p.length() + 1);
        }

        return result;
    }

}
