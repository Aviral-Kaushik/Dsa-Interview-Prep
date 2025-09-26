package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class MergeSortLinkedList {

    /**
     * Time Complexity: O(n * log n)
     * Space Complexity: O(log n)
     * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode second = split(head);

        head = sortList(head);
        second = sortList(second);

        return merge(head, second);
    }

    private ListNode split(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut at prev
        if (prev != null)
            prev.next = null;

        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.val <= second.val) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }
}
