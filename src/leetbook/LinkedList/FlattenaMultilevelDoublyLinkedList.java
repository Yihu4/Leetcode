package leetbook.LinkedList;

/**
 * LC 430
 *
 * @author: Yihu4
 * @create: 2021-09-10 19:35
 */
public class FlattenaMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.child = new Node1(2);
        root.next = new Node1(4);
        root.child.next = new Node1(3);
        flatten(root);
        while (root!=null){
            System.out.println(root.val);
            root = root.next;
        }
    }
    // 全局连接指针
    private static Node1 prevNode = new Node1(0);

    // 递归比较方便,核心是栈
    public static Node1 flatten(Node1 head) {
        dfs(head);
        if (head != null) {
            head.prev = null;
        }
        return head;
    }

    private static void dfs(Node1 root) {
        if (root == null) {
            return;
        }
        // 连接上个循环的节点和当前节点
        prevNode.next = root;
        root.prev = prevNode;
        // 移动指针
        prevNode = root;
        // 必须在这里保存当前节点的 next,因为下次递归的 prevNode 会让 当前节点的 next 改变
        Node1 right = root.next;
        // 先执行 child, 等到所有 child 入栈出栈了再一次执行对应的 next
        dfs(root.child);
        // 要把当前节点的 child 置为空, 这样最后输出结果符合要求
        root.child = null;
        dfs(right);
    }
}

class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;

    public Node1(int val) {
        this.val = val;
    }
}
