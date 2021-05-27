package easy;

import java.util.*;

public class ImplementQueueUsingStacks232 {

    class MyQueue {

        private Stack<Integer> pushingStack;
        private Stack<Integer> poppingStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            pushingStack = new Stack<Integer>();
            poppingStack = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!poppingStack.empty()){
                pushingStack.push(poppingStack.pop());
            }

            pushingStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!pushingStack.empty()){
                poppingStack.push(pushingStack.pop());
            }

            return poppingStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!pushingStack.empty()){
                poppingStack.push(pushingStack.pop());
            }

            return poppingStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushingStack.empty() && poppingStack.empty();
        }
    }

    /**
     * amortised O(1)
     * */
    class MyQueue2 {

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        /** Initialize your data structure here. */
        public MyQueue2() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }

            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}