package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class SwappingNodesInALinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kthFront = head;

        for (int i = 1; i < k; i++) {
            kthFront = kthFront.next;
        }

        ListNode fast = kthFront;
        ListNode kthLast = head;

        while (fast.next != null) {
            fast = fast.next;
            kthLast = kthLast.next;
        }

        int temp = kthLast.val;
        kthLast.val = kthFront.val;
        kthFront.val = temp;

        return head;
    }
}
