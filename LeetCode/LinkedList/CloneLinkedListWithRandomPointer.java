package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * */
    private Node copyRandomList(Node head) {
        Map<Node, Node> nodesMap = new HashMap<>();
        Node current = head;

        while (current != null) {
            nodesMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        while (current != null) {
            Node newNode = nodesMap.get(current);
            newNode.next = nodesMap.get(current.next);
            newNode.random = nodesMap.get(current.random);

            current = current.next;
        }

        return nodesMap.get(head);
    }
}
