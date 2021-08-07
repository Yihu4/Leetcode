package leetbook.queue_stack.stack_dfs;

/**
 * @author: mete0ra
 * @create: 2021-08-07 16:41
 */
class MinStack {

    /** initialize your data structure here. */
    private ListNode head;

    // 压栈
    public void push(int val) {
        if (isEmpty()){
            head = new ListNode(val, val, null);
        } else {
            head = new ListNode(val, Math.min(val, head.min), head);
        }

    }

    public void pop() {
        if (isEmpty()){
            throw new IllegalStateException("栈为空");
        }
        head = head.next;
    }

    public int top() {
        if (isEmpty()){
            throw new IllegalStateException("栈为空");
        }
        return head.val;
    }

    public int getMin() {
        if (isEmpty()){
            throw new IllegalStateException("栈为空");
        }
        return head.min;
    }
    public boolean isEmpty(){
        return head == null;
    }
}
/**
 * 辅助类
 */

class ListNode {
    public int val;
    // 最小值
    public int min;

    public ListNode next;

    // 构造函数
    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
