package leetbook.queue_stack.stack_dfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 无向图邻居克隆
 * https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
 * 评论:
 * 课本上总说deep copy和shallow copy，似懂非懂的，不觉得这东西有什么用。
 * 慢慢地，发现deep copy背后隐藏的逻辑其实是一种对象图（Object Graph）的遍历行为——这东西广泛出现在各语言的垃圾回收、序列化机制里。
 * 内存里各个对象存储空间中放置的引用域/指针就好像有向图里一条边，你沿着它去到达内存中的每个角落、去到当前对象所有的关联对象。
 * 题设里的neibours就像一道开胃菜，它可以是其他collection、甚至object，学会这个deep copy，你也就学会了GC里的可达性分析、你也就学会了如何把RAM中的数据固化到硬盘里。
 */

public class CloneGraph {

    private static HashMap<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        //Node node4 = new Node(4);
        node1.neighbors = listOf(node2, node3);
        node2.neighbors = listOf(node1, node3);
        node3.neighbors = listOf(node1, node2);
        //node4.neighbors = listOf(node1, node3);
        System.out.println(cloneGraph(node1).val);
    }

    private static List<Node> listOf(Node node1, Node node2) {
        List<Node> node = new ArrayList<>();
        node.add(node1);
        node.add(node2);
        return node;
    }

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return dfs(node);
    }

    public static Node dfs(Node node) {
        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // 克隆节点，只存储一个节点的值
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 哈希表存储,记录访问过的节点
        visited.put(node, cloneNode);
        // 遍历该节点的邻居并更新克隆节点的邻居列表
        // 递归cloneGraph
        for (Node neighbor : node.neighbors) {
            //递归中,cloneNode的neighbors属性会添加进入cloneNode,但是因为visited的存在,不会陷入死循环
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public Node bfs(Node node) {
        // 将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }


        }
        return visited.get(node);
    }


    // 节点有本身的值和它的邻居
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
