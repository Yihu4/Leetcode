package leetbook.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LC 102
 * 二叉树层序遍历
 *
 * @author: Yihu4
 * @create: 2021-08-28 11:20
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        // check
        if (root == null) {
            return lists;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        // 只要不为空
        while (!deque.isEmpty()) {
            // 取出每一层
            List<Integer> list = new ArrayList<>();
            // size 要单独赋值,如果在 for 中定义则会改变
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                // 该层每一个元素元素
                list.add(temp.val);
                if (temp.left != null) {
                    deque.add(temp.left);
                }
                if (temp.right != null) {
                    deque.add(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }

    void dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }
}
