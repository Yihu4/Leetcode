package leetbook.LinkedList;

/**
 * @author: Yihu4
 * @create: 2021-09-06 09:27
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
