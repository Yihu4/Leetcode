package leetbook.LinkedList;

/**
 * LC 328
 * 奇偶链表
 * 分割奇和偶
 * @author: Yihu4
 * @create: 2021-09-07 21:07
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even!=null && even.next!=null){
            // 移动 odd 的 next, 跳过下一个偶数
            odd.next = even.next;
            // 移动 odd 指针, 方便下次循环
            odd = odd.next;
            // 移动 even 的 next, 跳过下个奇数
            even.next = odd.next;
            // 移动 even 指针, 方便下次循环
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
