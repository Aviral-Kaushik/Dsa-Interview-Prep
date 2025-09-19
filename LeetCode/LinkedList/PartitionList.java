package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class PartitionList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode smallerStart = null, smallerEnd = null, greaterStart = null, greaterEnd = null;

        for (ListNode current = head; current != null; current = current.next) {
            if (current.val < x) {
                if (smallerStart == null) {
                    smallerStart = current;
                    smallerEnd = current;
                } else {
                    smallerEnd.next = current;
                    smallerEnd = current;
                }
            } else {
                if (greaterStart == null) {
                    greaterStart = current;
                    greaterEnd = current;
                } else {
                    greaterEnd.next = current;
                    greaterEnd = current;
                }
            }
        }

        if (smallerStart == null || greaterStart == null)
            return head;

        smallerEnd.next = greaterStart;
        greaterEnd.next = null;

        return smallerStart;
    }
}
