package leetbook.queue_stack.queue_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBFS {
    /**
     * 二叉树BFS
     */
    public void binaryTreeBFS(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);//相当于把数据加入到队列尾部
        while (!queue.isEmpty()) {
            //poll方法相当于移除队列头部的元素
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
    /**
     * 二叉树BFS打印层数
     */
    public void levelOrder(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int level = 0;//统计有多少层
        while (!queue.isEmpty()) {
            //每一层的节点数
            int size = queue.size();
            //把旧层的节点推出,构建新的层
            for (int i = 0; i < size; i++) {
                //把旧层的节点推出
                TreeNode node = queue.poll();
                //打印节点
                System.out.println(node.val);
                //把下一层的节点加入队列
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
            //打印现在循环进行到了第几层
            System.out.println(level);
        }
    }

    /**
     * 二叉树
     */
    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }
    }
}
