package leetbook.BinaryTree;

import java.util.*;

/**
 * LC 105
 * @author: Yihu4
 * @create: 2021-08-30 20:28
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    // 递归
    public TreeNode buildTreeR(int[] preorder, int[] inorder) {
        // 把前序遍历的值和中序遍历的值放到list中
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList, inorderList);
    }
    // 递归辅助
    private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {

        if (inorderList.size() == 0) {
            return null;
        }
        // 前序遍历的第一个值就是根节点
        // 因为右子树的构造是在左子树构造完之后, 所有不会有错
        int rootVal = preorderList.remove(0);
        // 创建跟结点
        TreeNode root = new TreeNode(rootVal);
        // 查看根节点在中序遍历中的位置，然后再把中序遍历的数组劈两半，前面部分是
        // 根节点左子树的所有值，后面部分是根节点右子树的所有值
        int mid = inorderList.indexOf(rootVal);
        root.left = helper(preorderList, inorderList.subList(0, mid));
        root.right = helper(preorderList, inorderList.subList(mid + 1, inorderList.size()));
        return root;
    }

    // 递归 2
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // 出口
        if (pre >= preorder.length) {
            return null;
        }
        // 如果中序数组中的元素与 父节点的值对应
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        // 创建该节点, 根据前序
        TreeNode node = new TreeNode(preorder[pre++]);
        // 因为右子树的构造是在左子树构造完之后, 所有不会有错
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    // 指针
    public TreeNode buildTreeZ(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    // 指针辅助
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //创建结点
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        //找到当前节点root在中序遍历中的位置，然后再把数组分两半
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = helper(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }

    // 栈
    /**
     * 如果使用栈来解决首先要搞懂一个知识点，就是前序遍历挨着的两个值比如m和n，
     * 他们会有下面两种情况之一的关系。
     *
     * 1. n是m左子树节点的值。
     * 2. n是m右子树节点的值或者是m某个祖先节点的右节点的值。
     *
     * 对于第二个问题，如果一个结点没有左子树只有右子树，那么n就是m右子树节点的值，
     * 如果一个结点既没有左子树也没有右子树，那么n就是m某个祖先节点的右节点，
     * 我们只要找到这个祖先节点就好办了。
     */
    public TreeNode buildTreeS(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            // 直到找到根节点的左孩子
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 找到之后, 向上移不断出栈, 直到找到不同的(这些节点的顺序和它们在中序遍历中出现的顺序一定是相反的。)
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 最后出栈的右孩子
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
