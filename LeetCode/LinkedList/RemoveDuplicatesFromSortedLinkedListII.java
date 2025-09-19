package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedLinkedListII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(0, head);

        ListNode prev = dummyNode;
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }

                prev.next = current.next;
            } else {
                prev = prev.next;
            }

            current = current.next;
        }

        return dummyNode.next;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public ListNode deleteDuplicatesUsingNaiveMethod(ListNode head) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        ListNode current = head;

        while (current != null) {
            frequencyMap.put(current.val, frequencyMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        ListNode newNode = new ListNode();
        current = head;
        ListNode insert = newNode;

        while (current != null) {
            int frequency = frequencyMap.get(current.val);

            if (frequency == 1) {
                insert.next = new ListNode(current.val);
                insert = insert.next;
            }

            current = current.next;
        }

        return newNode.next;
    }
}
