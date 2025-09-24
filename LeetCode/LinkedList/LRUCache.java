package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(capacity)
     * */

    static class Node {
        Node next, prev;
        int key, value;

        public Node(int key, int value) {
            this.key= key;
            this.value = value;
        }
    }

    private Node head, tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));

        if (map.size() == capacity)
            remove (tail.prev);

        insertAtFront(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertAtFront(Node node) {
        map.put(node.key, node);

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
