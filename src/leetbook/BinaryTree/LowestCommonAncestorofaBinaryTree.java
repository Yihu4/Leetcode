package leetbook.BinaryTree;


import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * LC 236
 *
 * @author: Yihu4
 * @create: 2021-09-02 20:36
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
 */
public class LowestCommonAncestorofaBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.left.left =null;
        root.left.left.right = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode treeNode = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(treeNode.val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历
        // 递归终止条件: 穷尽或者直到找到 p 或者 q
        // 如果一个节点是另一个节点的祖先,那么只会留下祖先
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左孩子
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右孩子
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 要考虑两边都为空的情况, 这时候不能返回 root

        /*if (left == null &&right!=null) {
            return right;
        }

        if (right == null && left!=null) {
            return left;
        }
        if (right== null && left ==null){
            return null;
        }*/
        //简化为 都为 null 返回 null
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }
        // left == null && right != null 和 right == null && left != null摘掉了两边为空
        // 两边都不为空 ,这个 root 就是最近的
        System.out.println("11");
        System.out.println(root.val);
        return root;
    }
}
