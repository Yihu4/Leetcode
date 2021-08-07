package leetbook.queue_stack.stack_dfs;

import java.util.*;

/**
 * LC 94二叉树中序遍历
 * 中序遍历:先遍历输出左结点，再输出当前结点的数据，再遍历输出右结点
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
 * @author meteora
 *
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(stack(root));


    }

    // 栈&迭代
    public static List<Integer> stack(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        // 当根节点不为空并且栈栈不为空的时候
        while (root != null || !stack.isEmpty()) {
            // 一直入栈找左节点直到左节点为空
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 当左孩子为空时,出栈当前节点加入结果列表
            TreeNode top = stack.removeFirst();
            res.add(top.val);
            // 更改根节点为右孩子
            root = top.right;

        }
        return res;
    }

    // 递归
    public static List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursion(root, res);
        return res;
    }

    public static void recursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        recursion(root.left, res);
        // 若左孩子为空,才会加入res队列
        res.add(root.val);
        // 右孩子优先级最低
        recursion(root.right, res);
    }

    // Morris 自己维护一个栈,以时间换空间
    public static List<Integer> morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
