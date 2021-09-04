package leetbook.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 116
 *
 * @author: Yihu4
 * @create: 2021-08-31 20:40
 * videos.com/video25124419/blacked_kendra_sunderland_obsession_part_1
 */
public class PopulatingNextRightPointersinEachNode {
    public Node connectBFSNo(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            // 前一个节点
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                // 前一个节点不为空, 即该节点不是第一个节点, 可以把该节点赋值给前一个节点的 next
                if (pre != null) {
                    pre.next = node;
                }
                // 更新前一个节点
                pre = node;
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * pre
     * 永远是前一层的第一个节点
     * <p>
     * tmp
     * 当前节点
     */
    public Node connectBFSYes(Node root) {
        if (root == null) {
            return root;
        }
        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点
        //或所有叶子节点都出串联完后循环就退出了
        while (pre.left != null) {
            //
            Node tmp = pre;
            while (tmp != null) {
                //将tmp的左右节点都串联起来
                //注:外层循环已经判断了当前节点的left不为空
                tmp.left.next = tmp.right;
                //下一个不为空说明上一层已经帮我们完成串联了
                if (tmp.next != null) {
                    // 完成这一层的跨越父节点的串联
                    tmp.right.next = tmp.next.left;
                }
                //继续右边遍历
                tmp = tmp.next;
            }
            //从下一层的最左边开始遍历
            pre = pre.left;
        }
        return root;
    }

    // dfs
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if(root==null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        // 直接从根节点到叶子节点
        while(left!=null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        // 递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }

}

