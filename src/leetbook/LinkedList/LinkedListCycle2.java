package leetbook.LinkedList;

/**
 * LC 142
 * 求环开始的下标
 *
 * @author: Yihu4
 * @create: 2021-09-06 19:15
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow != null && fast == slow) {
                break;
            }
        }
        // 通过快指针判断是否有环
        if (fast==null){
            return null;
        }
        // 把快指针置为头结点
        fast = head;
        // 两个指针都在往目标点靠近
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
