package LeetCode.LinkedList;

public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * */
    private Node flatten(Node head) {
        if (head == null) return null;

        dfs(head);

        return head;
    }

    private Node dfs(Node head) {
        Node current = head;
        Node last = null;

        while (current != null) {
            Node next = current.next;

            if (current.child != null) {
                Node childTail = dfs(current.child);

                current.next = current.child;
                current.child.prev = current;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                current.child = null;

                last = childTail;
            } else {
                last = current;
            }

            current = next;
        }

        return last;
    }
}
