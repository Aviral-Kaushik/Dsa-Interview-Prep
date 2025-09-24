package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nodesValues = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            nodesValues.add(current.val);
            current = current.next;
        }

        Deque<Integer> monotonicStack = new ArrayDeque<>();
        int listSize = nodesValues.size();
        int[] result = new int[listSize];

        for (int i = listSize - 1; i >= 0; i--) {
            Integer currentValue = nodesValues.get(i);

            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= currentValue) {
                monotonicStack.pop();
            }

            if (!monotonicStack.isEmpty()) {
                result[i] = monotonicStack.peek();
            }

            monotonicStack.push(currentValue);
        }

        return result;
    }
}
