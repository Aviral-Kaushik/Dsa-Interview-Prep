package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class ReverseLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
