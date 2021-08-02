package leetbook.queue_stack.summary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
// LC225
public class ImplementStackUsingQueues {
    public static void main(String[] args) {

    }
    static class MyStacksolo {
        Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MyStacksolo() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            // 要保证新入队列的元素在队列头部
            // 就要把入队列前的元素全部按顺序移到队列尾部
            queue.add(x);
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                queue.add(queue.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.remove();
        }

        /** Get the top element. */
        public int top() {
            return queue.element();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    static class MyStackDeque {
        Deque<Integer> queue;
        /** Initialize your data structure here. */
        public MyStackDeque() {
            queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            //尾部插入元素
            queue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            //移除尾部元素
            return queue.removeLast();
        }

        /** Get the top element. */
        public int top() {
            return queue.getLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();

        }
    }
}
