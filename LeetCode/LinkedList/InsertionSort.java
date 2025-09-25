package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class InsertionSort {

    /**
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     * */
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = null, current = head;

        while (current != null) {
            ListNode next = current.next;

            sorted = sortedInsert(current, sorted);

            current = next;
        }

        return sorted;
    }

    private ListNode sortedInsert(ListNode newNode, ListNode sorted) {
        if (sorted == null || sorted.val >= newNode.val) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            ListNode current = sorted;

            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        return sorted;
    }
}
