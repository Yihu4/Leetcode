package leetbook.BinaryTree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Yihu4
 * @create: 2021-12-25 10:21
 */
public class EvenOddTree {
    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(10, new TreeNode(3), null), new TreeNode(4, new TreeNode(7), new TreeNode(9)));
        System.out.println(isEvenOddTree(treeNode));
    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root.val % 2 == 0) {
            return false;
        }
        q.add(root);
        int level = 0;
        int pre = 0;
        while (!q.isEmpty()) {
            // 当前层数量
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                int cur = poll.val;
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                // 偶数层
                if (level % 2 == 0) {
                    if (cur % 2 == 0 || cur <= pre && pre != 0) {
                        return false;
                    }
                } else {
                    // 奇数层
                    if (cur % 2 != 0 || cur >= pre&& pre != 0) {
                        return false;
                    }
                }
                pre = cur;
            }
            pre = 0;
            level++;
        }
        return true;
    }
}
