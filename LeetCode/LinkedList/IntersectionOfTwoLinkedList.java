package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedList {

    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     * Where m is the size of first linked list and n is the size of second linked list.
     * */
    public ListNode getIntersectionNodeUsingOptimizedMethod(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;

        // Traverse both lists; when one pointer reaches the end,
        // switch it to the head of the other list.
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;  // Will be null if no intersection, or the intersection node
    }



    /**
     * Time Complexity: O(m + n)
     * Space Complexity: O(m)
     * Where m is the size of first linked list and n is the size of second linked list.
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode current = headA;

        while (current != null) {
            set.add(current);
            current = current.next;
        }

        current = headB;

        while (current != null) {
            if (set.contains(current)) return current;

            current = current.next;
        }

        return null;
    }
}
