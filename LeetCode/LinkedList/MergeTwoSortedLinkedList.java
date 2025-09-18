package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class MergeTwoSortedLinkedList {

    /**
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(1)
     * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append the remaining part of list1 or list2
        current.next = (list1 != null) ? list1 : list2;

        return dummyNode.next;
    }

}
