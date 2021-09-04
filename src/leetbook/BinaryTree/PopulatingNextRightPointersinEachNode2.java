package leetbook.BinaryTree;

/**
 * LC 117
 * 非完全二叉树
 * @author: Yihu4
 * @create: 2021-09-02 15:04
 */
public class PopulatingNextRightPointersinEachNode2 {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node pre = dummy;
        pre.left = new Node(4);
        pre.next = new Node(2);
        pre.next.next =new Node(3);
        pre = pre.next;

        System.out.println(pre.next.val);
        System.out.println(pre.left);
        System.out.println(dummy.next.val);

    }
    // 模拟链表
    public Node connect(Node root) {
        Node cur = root;
        // 链表头, 代表的是下一层
        Node dummy = new Node(0);
        // 换层
        while (cur != null){
            // 链表指针
            Node pre = dummy;
            // 处理该层孩子节点的连接
            while (cur != null){
                if (cur.left != null){
                    pre.next = cur.left;
                    // 更新 pre 至左孩子
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    // 更新 pre 至又孩子
                    pre = pre.next;
                }
                // 更新 cur 至该层的 next
                cur = cur.next;
            }
            // 去下一层, dummy.next 就是下一层的第一个
            cur = dummy.next;
        }
        return root;
    }
}
