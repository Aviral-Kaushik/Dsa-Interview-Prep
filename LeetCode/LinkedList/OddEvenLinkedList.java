package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class OddEvenLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public ListNode oddEvenList(ListNode head) {
        ListNode oddStart = null, oddEnd = null, evenStart = null, evenEnd = null, current = head;

        int i = 1;

        while (current != null) {
            if (i % 2 != 0) {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = current;
                }
            } else {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = current;
                }
            }

            current = current.next;
            i++;
        }

        if (oddStart == null) return evenStart;
        if (evenStart == null) return oddStart;

        oddEnd.next = evenStart;
        evenEnd.next = null;

        return oddStart;
    }
}
