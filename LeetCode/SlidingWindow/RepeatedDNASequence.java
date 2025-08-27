package LeetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    /**
     * Time Complexity: O(10 * n)
     * Space Complexity: O(10 * n)
     * */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeatedDNAs = new HashSet<>();
        Set<String> seenDNAs = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String currDNASequence = s.substring(i, i + 10);
            if (seenDNAs.contains(currDNASequence))
                repeatedDNAs.add(currDNASequence);
            else
                seenDNAs.add(currDNASequence);
        }

        return new ArrayList<>(repeatedDNAs);
    }
}
