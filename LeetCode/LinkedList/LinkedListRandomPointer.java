package LeetCode.LinkedList;

import LeetCode.LinkedList.Utils.ListNode;

import java.util.Random;

public class LinkedListRandomPointer {

    private ListNode head;
    private Random random = new Random();

    public LinkedListRandomPointer(ListNode head) {
        this.head = head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    public int getRandom() {
        int result = 0;
        int nodeCount = 0;

        ListNode current = head;

        while (current != null) {
            nodeCount++;

            int randomNumber = 1 + random.nextInt(nodeCount);

            if (randomNumber == nodeCount) {
                result = current.val;
            }

            current = current.next;
        }

        return result;
    }
}
