package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class RemoveDuplicatesFromSortedLinkedListI {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode nextNode = current.next;

            if (current.val == nextNode.val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }
}
