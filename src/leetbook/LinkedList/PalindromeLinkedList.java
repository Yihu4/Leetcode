package leetbook.LinkedList;


/**
 * LC 234
 * @author: Yihu4
 * @create: 2021-09-08 15:47
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        System.out.println(isPalindromeB(root));
    }
    public static boolean isPalindromeB(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 精髓在于 pre.next 是往前的
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }

        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            // pre.next 往前, slow.next 往后
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode frontPointer;
    // 递归, 低效优雅, 堆栈堆栈帧
    // https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
    private boolean recursivelyCheckR(ListNode currentNode) {
        if (currentNode != null) {
            // 直到到最后
            if (!recursivelyCheckR(currentNode.next)) {
                return false;
            }
            // 头和最后对应的一一比较
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            // 头向下移动
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheckR(head);
    }

    // LC 正解
    public boolean isPalindromeLc(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        // 对比直到尾翻转穷尽
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // 翻转后半段
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            // 不能直接 curr = curr.next 因为 curr.next会变为 prev,所以需要用到 temp
            curr = nextTemp;
        }
        return prev;
    }

    // 找到前半段,奇数则中间的包含在前半段里
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
