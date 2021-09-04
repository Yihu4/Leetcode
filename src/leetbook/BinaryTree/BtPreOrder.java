package leetbook.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 144
 * 二叉树前序遍历 根左右
 *
 * @author: mete0ra
 * @create: 2021-08-27 19:40
 */
public class BtPreOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
    }

    // 递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        // 新节点变成当前节点的左节点
        preOrder(root.left, res);
        // 新节点变成当前节点的右节点
        preOrder(root.right, res);
    }

    // 迭代
    public static List<Integer> preOrderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            // 先让右节点入栈,先入后出, 左节点将被先处理
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        return res;
    }
}


