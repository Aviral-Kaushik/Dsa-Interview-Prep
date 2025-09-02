package LeetCode.SlidingWindow;

public class MinimumWindowSubString {

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * */
    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        int[] sMap = new int[128];

        // build t frequency map
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int sourceLength = s.length();
        int requiredUniqueChars = 0;

        // count how many unique characters are required
        for (int count : tMap) {
            if (count > 0)
                requiredUniqueChars++;
        }

        int minWindowStart = -1;
        int minWindowLen = sourceLength + 1;
        int validCharacterCount = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            sMap[ch]++;

            if (sMap[ch] == tMap[ch]) {
                validCharacterCount++;
            }

            while (validCharacterCount == requiredUniqueChars) {
                if (right - left + 1 < minWindowLen) {
                    minWindowLen = right - left + 1;
                    minWindowStart = left;
                }

                char leftChar = s.charAt(left);
                sMap[leftChar]--;

                if (sMap[leftChar] < tMap[leftChar]) {
                    validCharacterCount--;
                }

                left++;
            }
        }

        return minWindowStart < 0 ? "" : s.substring(minWindowStart, minWindowStart + minWindowLen);
    }
}
