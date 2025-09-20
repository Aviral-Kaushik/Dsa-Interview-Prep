package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class DeleteNodeInALinkedList {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
