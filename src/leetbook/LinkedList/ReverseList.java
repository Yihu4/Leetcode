package leetbook.LinkedList;

/**
 * LC 206
 * @author: Yihu4
 * @create: 2021-09-07 15:42
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        reverseList(root);
    }
    // 递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        // head 的 next 最终会指向 null
        head.next = null;
        return newHead;
    }

    public ListNode reverseListLc(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            // temp 为下一个
            ListNode temp = curr.next;
            // 让首节点的 next 为 null, 因为首节点最后一定会指向 null
            // 非首节点的 next 指向 prev
            curr.next = prev;
            // 当前变为 prev
            prev = curr;
            // 下一个变为当前
            curr = temp;
        }
        return prev;
    }

}
