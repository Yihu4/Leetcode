package leetbook.LinkedList;

/**
 * LC 203
 *
 * @author: Yihu4
 * @create: 2021-09-07 19:48
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        // root.next = new ListNode();
        removeElements(root, 2);
    }

    // 递归
    public ListNode removeElementsR(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        // 如果相等直接跳过
        return head.val == val ? head.next : head;
    }

    // 迭代
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                // 因为可能会出现连续的情况, 所以连续时 cur 不能动
                cur = cur.next;
            }
        }
        return head;
    }
}
