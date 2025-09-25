package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

public class ReverseNodesInKGroup {

    /**
     * Time Complexity: O(n)
     * Space Complexity: o(1)
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head, prevFirst = null;
        boolean isFirstPass = true;

        while (current != null) {
            ListNode check = current;
            int count = 0;
            while (count < k && check != null) {
                check = check.next;
                count++;
            }

            if (count < k) {
                if (prevFirst != null) {
                    prevFirst.next = current;
                }
                break;
            }

            ListNode first = current, prev = null;
            count = 0;

            while (current != null && count < k) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;

                count++;
            }


            if (isFirstPass) {
                isFirstPass = false;
                head = prev;
            } else {
                prevFirst.next = prev;
            }

            prevFirst = first;
        }

        return head;
    }
}
