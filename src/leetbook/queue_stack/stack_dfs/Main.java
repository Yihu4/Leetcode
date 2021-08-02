package leetbook.queue_stack.stack_dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        if (s.empty()) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());
    }

    public static class MyStack {
        private final List<Integer> data;

        public MyStack() {
            data = new ArrayList<>();
        }

        //入栈操作
        public void push(int x) {
            data.add(x);
        }

        //确定是否为空
        public boolean isEmpty() {
            return data.isEmpty();
        }

        //获取指定位置数据
        public int top() {
            return data.get(data.size() - 1);
        }

        //出栈
        public boolean pop() {
            if (isEmpty()) {
                return false;
            }
            data.remove(data.size() - 1);
            return true;
        }

    }
}
