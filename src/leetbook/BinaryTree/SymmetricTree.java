package leetbook.BinaryTree;

import java.util.LinkedList;

/**
 * LC 101 对称二叉树
 *判断是否对称
 * @author: Yihu4
 * @create: 2021-08-30 14:15
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode t1, TreeNode t2) {
        // 叶子结点
        if (t1 == null && t2 == null) {
            return true;
        }
        // 不对称(结构上)
        if (t1 == null || t2 == null) {
            return false;
        }
        // 不对称(数值上)
        if (t1.val!=t2.val){
            return false;
        }
        // 本身
        return dfs(t1.left, t2.right) && dfs(t1.right, t2.left);
    }

    // 队列实现
    public boolean isSymmetricQueue(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()>0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if(left==null && right==null) {
                continue;
            }
            if(left==null || right==null) {
                return false;
            }
            if(left.val!=right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
