package LeetCode.Stack;

public class ImplementStackUsingLinkedList {

    private Node top;
    private int size;

    public ImplementStackUsingLinkedList() {
        this.top = null;
        this.size = 0;
    }

    private void push(int element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    private int pop() throws Exception {
        if (top == null) throw new Exception("Stack Underflow!");
        int res = top.val;
        top = top.next;
        size--;

        return res;
    }

    private int peek() throws Exception{
        if (top == null) throw new Exception("Stack Underflow!");
        return top.val;
    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return top == null;
    }

    static class Node {
        public final int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
