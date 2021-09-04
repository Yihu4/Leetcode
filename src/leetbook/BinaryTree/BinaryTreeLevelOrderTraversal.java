package leetbook.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC 102
 * 二叉树层序遍历
 *
 * @author: Yihu4
 * @create: 2021-08-28 11:20
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        // check
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        // 只要不为空
        while (!deque.isEmpty()) {
            // 取出每一层
            List<Integer> list = new ArrayList<>();
            // size 要单独赋值,如果在 for 中定义则会改变
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                // 该层每一个元素元素
                list.add(temp.val);
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
