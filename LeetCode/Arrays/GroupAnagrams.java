package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    /**
     * Time Complexity: O(NK)
     * Space Complexity: O(NK)
     * Where n is the length of strs and K is the length of corresponding word.
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str: strs) {
            int[] count = new int[26];

            for (char c: str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();

            for (int num: count) {
                builder.append('#').append(num);
            }

            String keyStr = builder.toString();

            anagramsMap.computeIfAbsent(keyStr, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}
