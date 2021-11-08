package medium;

import java.util.*;

public class Medium0284PeekingIterator {
    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;
        Integer cur = null;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (this.iterator.hasNext()){
                cur = this.iterator.next();
            }

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cur;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer tmp = cur;

            if (this.iterator.hasNext()){
                cur = this.iterator.next();
            }
            else{
                cur = null;
            }

            return tmp;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }
    }
}