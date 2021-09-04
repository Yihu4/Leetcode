package leetbook.BinaryTree;

import java.util.*;

/**
 * LC 145
 * 二叉树后序
 *
 * @author: Yihu4
 * @create: 2021-08-27 20:56
 */
public class BtPostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    // 迭代
    public List<Integer> postorderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        // 用于防止已出栈的右子树影响
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 左子树全部入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 最后一个左子树出栈, 并且指针到该节点
            root = stack.pop();
            // 如果右节点为空或者右节点为先前节点
            if (root.right == null || root.right == prev) {
                // 出口
                res.add(root.val);
                // 出栈的节点为先前节点, 为了下次循环时不往右下
                prev = root;
                // 根节点为空, 为了下次循环不执行 while 语句(不往左下)
                root = null;
            } else {
                // 右节点不为空,则切换指针为右节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;

    }
    // 反转 根-右-左
    public List<Integer> postorderTraversalF(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.left!=null) {
                stack.push(cur.left);
            }
            if(cur.right!=null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
