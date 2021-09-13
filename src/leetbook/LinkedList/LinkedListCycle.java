package leetbook.LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 141
 * 判断链表中是否有环
 *
 * @author: Yihu4
 * @create: 2021-09-06 09:26
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode =new ListNode(1);
        hasCycleSet(listNode);
    }
    public static boolean hasCycleSet(ListNode head) {
        // 记录表
        Set<ListNode> set = new HashSet<ListNode>();

        ListNode n = head;
        // 对比的是地址值
        while (n != null) {
            if (set.contains(n)){
                return true;
            }
            set.add(n);
            n = n.next;
        }
        return false;
    }

    // 快慢指针空间O(1)
    public static boolean hasCycleSF(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (slow!=null && fast!=null){
            slow = slow.next;
            // 下个不为空则跳过
            // 快指针比慢指针快一点,保证能追上
            fast = fast.next == null? null: fast.next.next;
            if (slow != null && slow==fast){
                return true;
            }
        }
        return false;
    }

}
