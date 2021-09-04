package leetbook.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * LC 104
 * 二叉树最大深度
 *
 * @author: Yihu4
 * @create: 2021-08-28 15:26
 */
public class MaximumDepthofBinaryTree {
    // 递归 自底向上
    public int maxDepth(TreeNode root) {
        // 为 空 则返回 0
        // 否则比较哪个大
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // BFS
    public int maxDepthBFS(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            level++;
        }
        return level;
    }

    // 循环DFS 一个 level 容器记录然后比较 maxlevel
    // stack
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // stack记录的是节点，而level中的元素和stack中的元素
        // 是同时入栈同时出栈，并且level记录的是节点在第几层
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            //stack中的元素和level中的元素同时出栈
            TreeNode node = stack.pop();
            int temp = level.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                //同时入栈
                stack.push(node.left);
                level.push(temp + 1);
            }
            if (node.right != null) {
                //同时入栈
                stack.push(node.right);
                level.push(temp + 1);
            }
        }
        return max;
    }
}
