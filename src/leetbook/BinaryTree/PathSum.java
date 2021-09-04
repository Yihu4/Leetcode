package leetbook.BinaryTree;

/**
 * LC 112
 * 路径总和
 *
 * @author: Yihu4
 * @create: 2021-08-30 15:46
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 穷尽还没找到
        if (root == null) {
            return false;
        }
        // 如果是叶子节点, 比较是否相等
        if (root.right ==null &&root.left ==null) {
            return root.val == targetSum;
        }
        // 判断左右子树
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

}
