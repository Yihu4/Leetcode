package leetbook.HashTable.KeyDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 654
 * @author: Yihu4
 * @create: 2021-09-26 20:16
 */
public class FindDuplicateSubtrees {
    Map<String, Integer> record;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        record = new HashMap();
        res = new ArrayList();
        collect(root);
        return res;
    }

    public String collect(TreeNode node) {
        if (node == null) {
            return "#";
        }
        // DFS
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        // 记录所有子串, 如果有重复则+1
        record.put(serial, record.getOrDefault(serial, 0) + 1);
        // 如果有重复,
        if (record.get(serial) == 2) {
            // 把重复的根节(当前节点)点加入数组
            res.add(node);
        }
        return serial;
    }

    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtreesMark(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        // 如果当前节点不存在, 则在 trees 里面记录, 返回一个 uid
        // 存在则返回已存的 value
        // 等于每个不同的节点有不同的 uid
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        // return 的是 uid
        return uid;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}