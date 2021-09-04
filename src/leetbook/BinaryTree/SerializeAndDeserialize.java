package leetbook.BinaryTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * LC 297
 *
 * @author: Yihu4
 * @create: 2021-09-03 13:58
 */
public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = serialize(root);
        System.out.println(serialize);

    }


    // BFS 层序, 非前序
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 入队用 offer , push 是在头部
        deque.offer(root);
        stringBuilder.append(root.val);
        stringBuilder.append(',');
        while (!deque.isEmpty()) {
            TreeNode temp = deque.poll();
            if (temp.left != null) {
                stringBuilder.append(temp.left.val).append(",");
                deque.offer(temp.left);
            } else {
                stringBuilder.append("a").append(",");
            }
            if ((temp.right != null)) {
                stringBuilder.append(temp.right.val).append(",");
                deque.offer(temp.right);
            } else {
                stringBuilder.append("a").append(",");
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    // 双队列
    public static TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        char[] chars = data.toCharArray();
        // 将序列化字符串变为节点队列
        Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        // 构建根节点 , 字符串转 int
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        // 存在节点队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            // 如果不为空, 则入队节点队
            if (!"a".equals(left)){
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            if ((!"a".equals(right))){
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }
        return root;
    }


    // DFS 前序
    // Encodes a tree to a single string.
    public static String serializeDFS(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String left = serializeDFS(root.left);
        String right = serializeDFS(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeDFS(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll();
        if ("X".equals(value)) {
            return null;
        }
        // 字符串转 int
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}
