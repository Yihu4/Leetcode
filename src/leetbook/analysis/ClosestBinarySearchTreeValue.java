package leetbook.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * LC 270
 * 找二叉搜索树中的最接近的值
 * 二叉搜索树
 *
 * @author: Yihu4
 * @create: 2021-10-30 10:49
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        int closet = root.val;
        // 每一步root往下
        while (root != null) {
            cur = root.val;
            // 对比当前值与目标值的距离判断往左还是往右
            root = target - cur < 0 ? root.left : root.right;
            // 对比当前值和当前最接近值  与目标的距离
            closet = Math.abs(target - cur) < Math.abs(target - closet) ? cur : closet;
        }
        return closet;
    }

    // 在中序数组中进行线性搜索(一个一个搜)
    public int closestValueInOrder(TreeNode root, double target) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        // 比较器先排序再通过Collection.min获取最小
        return Collections.min(nums, (o1, o2) -> Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1);
    }

    // 递归构建中序
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
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
