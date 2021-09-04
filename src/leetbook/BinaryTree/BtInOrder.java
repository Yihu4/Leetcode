package leetbook.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LC 94
 * @author: mete0ra
 * @create: 2021-08-27 20:08
 */
public class BtInOrder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left =new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(7);
        inOrderIteration(treeNode);
    }
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        // 如果到底了
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static List<Integer> inOrderIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        //stack.push(root);先不入栈

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 唯一入口
                stack.push(root);
                // 左节点找到底
                root = root.left;
            }
            // 出栈全部已入栈
            // 是 if 不是 while
            if (!stack.isEmpty()) {
                // 唯一出口
                root = stack.pop();
                res.add(root.val);
                // 当节点的左节点找不到的时候,找该节点的右节点
                root = root.right;
            }
        }
        return res;
    }
}
