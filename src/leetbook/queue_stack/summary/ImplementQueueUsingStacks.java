package leetbook.queue_stack.summary;

import java.util.Deque;
import java.util.LinkedList;
// LC232用双栈实现队列
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.empty(); // return false


    }
    static class MyQueue {

        Deque<Integer> inStack;
        Deque<Integer> outStack;
        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new LinkedList<Integer>();
            outStack = new LinkedList<Integer>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            //只有当out为空的时候才能把in里面的加入到out,是为了保证顺序的正确
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        public void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
