package leetbook.LinkedList;

/**
 * @author: Yihu4
 * @create: 2021-11-22 16:24
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        while (cur.next!=null){
            if (cur.next.val==cur.val){
                cur.next=cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
