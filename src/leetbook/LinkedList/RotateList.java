package leetbook.LinkedList;

import java.util.List;

/**
 * LC 61
 * @author: Yihu4
 * @create: 2021-09-11 16:29
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        // 连通
        temp.next = head;
        // 回到 head
        temp = temp.next;
        // 找到旋转后尾节点
        for (int i = 0; i < count - k % count - 1; i++) {
            temp = temp.next;
        }
        ListNode res = temp.next;
        // 断开环
        temp.next = null;

        return res;
    }
}
