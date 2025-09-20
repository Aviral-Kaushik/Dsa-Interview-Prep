package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class RemoveLinkedListElements {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode current = dummyNode;

        while (current != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }

            current = current.next;
        }

        return dummyNode.next;
    }

}
