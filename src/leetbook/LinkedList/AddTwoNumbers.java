package leetbook.LinkedList;

import java.util.List;

/**
 * LC 2
 * 两数相加
 *
 * @author: Yihu4
 * @create: 2021-09-10 17:20
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int top = 0;
        ListNode head = new ListNode(0);
        // 指针
        ListNode res = head;
        while (l1 != null || l2 != null || top == 1) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + top;
            // 是否进位
            top = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            /*if (l1 == null&&l2 != null) {
                sum = l2.val +top;
                if (sum >= 10) {
                    top = 1;
                } else {
                    top = 0;
                }
                res.val = sum;
                res = res.next;
                l2 = l2.next;
            } else if (l2 == null&&l1 != null) {
                sum = l1.val + top;
                if (sum >= 10) {
                    top = 1;
                } else {
                    top = 0;
                }
                res.val = sum;
                res = res.next;
                l1 = l1.next;
            } else if (l2 != null&&l1 != null){
                // 都不为空
                sum = l1.val + l2.val;
                if (sum >= 10) {
                    top = 1;
                } else {
                    top = 0;
                }
                res.val = l1.val + l2.val + top;
                res = res.next;
            }
            if (l1 ==null&& l2==null){
                res.val = 1;
            }*/

        }
        return head.next;
    }
}
