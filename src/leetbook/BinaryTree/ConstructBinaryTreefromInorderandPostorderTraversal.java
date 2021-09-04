package leetbook.BinaryTree;

import java.util.HashMap;

/**
 * LC 106
 * 根据一颗二叉树的中序遍历和后续遍历构造二叉树
 * 无重复
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
 *
 * @author: Yihu4
 * @create: 2021-08-30 19:29
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    HashMap<Integer, Integer> memo = new HashMap<>();
    // 后序数组
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 遍历中序节点
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        // 后序数组赋值
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        // 递归出口
        if (inOrderEnd < inOrderStart || postOrderEnd < postOrderStart) {
            return null;
        }
        // 获取根节点的值, 在中序数组中的根节点是后序数组中的最后一个元素
        int root = post[postOrderEnd];
        // 创建节点
        TreeNode node = new TreeNode(root);
        // 获取根节点位置
        int rootIndex = memo.get(root);
        // 该节点的左子树在中序和后序数组中的区间
        node.left = buildTree(inOrderStart, rootIndex - 1,
                postOrderStart, postOrderStart + rootIndex - inOrderStart - 1);
        // 该节点的右子树在中序和后序数组中的区间
        node.right = buildTree(rootIndex + 1, inOrderEnd,
                postOrderStart + rootIndex - inOrderStart, postOrderEnd - 1);
        return node;
    }
}
