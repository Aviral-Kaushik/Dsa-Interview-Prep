package LeetCode.Arrays;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> mIterator;
    private Integer next;
    private boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        mIterator = iterator;
        advanceIterator();
    }

    /**
     * Time Complexity: O(1)
     * */
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    /**
     * Time Complexity: O(1)
     * */
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer nextElement = next;
        advanceIterator();
        return nextElement;
    }

    /**
     * Time Complexity: O(1)
     * */
    @Override
    public boolean hasNext() {
        return !noSuchElement;
    }

    /**
     * Time Complexity: O(1)
     * */
    private void advanceIterator() {
        if (mIterator.hasNext()) {
            next = mIterator.next();
        } else {
            noSuchElement = true;
        }
    }
}
