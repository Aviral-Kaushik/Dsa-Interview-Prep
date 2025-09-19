package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class SwapNodesInPairs {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        head = current.next;

        while (current != null && current.next != null) {
            ListNode nextNode = current.next;
            ListNode nextPair = nextNode.next;

            current.next = nextPair;
            nextNode.next = current;

            if (prev != null) {
                prev.next = nextNode;
            }

            prev = current;
            current = nextPair;
        }

        return head;
    }
}
