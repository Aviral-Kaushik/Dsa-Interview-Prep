package LeetCode.LinkedList;

public class DesignLinkedList {

    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private final Node head; // dummy head
    private int size;

    public DesignLinkedList() {
        head = new Node(0); // sentinel node
        size = 0;
    }

    /**
     * Time Complexity: O(index)
     * */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Time Complexity: O(1)
     * */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Time Complexity: O(size)
     * */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Time Complexity: O(index)
     * */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    /**
     * Time Complexity: O(index)
     * */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
    }
}
