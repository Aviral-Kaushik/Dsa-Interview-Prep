package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class MergeInBetweenLinkedList {

    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;

        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        ListNode afterB = prevA;

        for (int i = 0; i < b - a + 2; i++) {
            afterB = afterB.next;
        }

        prevA.next = list2;

        ListNode tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = afterB;

        return list1;
    }
}
