package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class AddTwoNumbers {

    /**
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(n)
     * Where m is size of linked list l1 & n is the size of Linked List l2.
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) +
                    (l2 != null ? l2.val : 0) +
                    carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

}
