package leetbook.LinkedList;

/**
 * LC 160
 *
 * @author: Yihu4
 * @create: 2021-09-06 19:37
 */
public class IntersectionofTwoLinkedLists {

    // 核心:变轨拼接
    // 难点:相遇前长度不一样
    // 解决:因为相遇后的节点是相同的
    // 因为前两段长度相加是相等的,所以不会存在变轨很多次的情况, 只会变轨一次
    // 相遇前长度可以为 0,意味着 head 有可能为 null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null || node2 != null) {
            // 相遇
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
            // 如果没有交集那么在分别走完两段路之后会同时 null

            if (node1 == null && node2 != null) {
                node1 = headB;
            }
            if (node2 == null && node1 != null) {
                node2 = headA;
            }
        }
        return null;
    }

    public ListNode getIntersectionNodeLc(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        //变轨次数, 为了让两边都只变轨一次
        int cnt = 0;
        // 终止条件为两边都为空, 即两个人都走了两段路最后为 null
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            //p1变轨
            if (cnt < 2 && p1 == null) {
                p1 = headB;
                cnt++;
            }
            //p2变轨
            if (cnt < 2 && p2 == null) {
                p2 = headA;
                cnt++;
            }
        }
        return null;
    }
}
