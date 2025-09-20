package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class LinkedListCycleII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        boolean containsLoop = false;

        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                containsLoop = true;
                break;
            }
        } while (fast != null && fast.next != null);

        if (!containsLoop) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
