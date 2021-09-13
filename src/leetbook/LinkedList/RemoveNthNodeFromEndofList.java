package leetbook.LinkedList;

/**
 * LC 19
 * @author: Yihu4
 * @create: 2021-09-07 10:00
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode test = head;
        test.next = test.next.next;
        System.out.println(test.val);
        System.out.println(head.val);
        System.out.println(head.next.val);
        removeNthFromEnd(head,1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode detect =head;
        int size = 1;
        // 长度
        // detect = detect.next是值传递, 不影响 head 结构, 等于指针移动
        // node.next = node.next.next 是地址传递, 会影响 head 结构
        while (detect.next!=null){
            detect = detect.next;
            size++;
        }
        // 如果删除的是头结点
        if (size == n){
            head = head.next;
            return head;
        }
        // 找到要删除节点的前一个节点
        ListNode node = head;
        int aim = size - n;
        for (int i = 0; i < aim - 1; i++) {
            node = node.next;
        }
        // 把当前节点的前一个的 next 指向当前节点的下一个节点
        node.next = node.next.next;
        return head;
    }
}
