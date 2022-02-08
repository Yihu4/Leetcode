package leetbook.DynamicPrograming.unclassified;

import org.junit.Test;

/**
 * LC 45
 *
 * @author: Yihu4
 * @create: 2021-11-18 16:34
 */
public class JumpGameII {
    @Test
    public void test() {
        int[] ints = {2,3,1,1,4};
        System.out.println(jump(ints));
    }

    public int jump(int[] nums) {
        // 当前位置能跳到的最远位置
        int[] dp = new int[nums.length];
        if (nums.length==1){
            return 0;
        }
        dp[0] = nums[0];
        // 起跳位置的最远距离
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            // 如果当前位置大于起跳位置的最远距离(跳不到)
            if (i > cur) {
                // 更新起跳位置的最远距离为当前的!!!前一格的!!!最远距离
                // 因为前一格在更新前必定跳的到,更新完之后前一格为新的起跳点
                cur = dp[i-1];
                // 增加次数
                count++;
            }
        }
        return count;
    }

    public int jumpdp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i]表示跳到i的最小次数
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int ans = 0xfffff;
            for (int j = 0; j < i; j++) { //遍历所有可以跳一次就到达的上一个位置
                // 在跳跃范围之内
                if (nums[j] >= i - j) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            dp[i] = ans;
        }
        return dp[n - 1];
    }

    public int jumpGreedy(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            // 找目前为止能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){
                //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    // https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
    // 逆推
    public int jumpRe(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    // 每次找到之后break出循环,从头开始找
                    break;
                }
            }
        }
        return steps;
    }
}
