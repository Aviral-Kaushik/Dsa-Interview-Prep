package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class PalindromeLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverseLinkedList(slow.next);
        ListNode current = head;

        while (reversed != null) {
            if (reversed.val != current.val)
                return false;

            reversed = reversed.next;
            current = current.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode current = head, prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
