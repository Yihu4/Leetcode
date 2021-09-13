package leetbook.LinkedList;

/**
 * LC 21
 *
 * @author: Yihu4
 * @create: 2021-09-09 19:47
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            // 小则作为该节点
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public ListNode mergeTwoListsI(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode target = null;
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                target = l1;
                l1 = l1.next;
            } else {
                target = l2;
                l2 = l2.next;
            }
            cur.next = target;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }

}
