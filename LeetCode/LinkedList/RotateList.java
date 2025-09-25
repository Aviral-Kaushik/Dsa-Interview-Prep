package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class RotateList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        ListNode current = head;
        int length = 1;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        k %= length;

        if (k == 0) return head;

        current.next = head;

        current = head;

        for (int i = 1; i < length - k; i++) {
            current = current.next;
        }

        head = current.next;
        current.next = null;

        return head;
    }
}
