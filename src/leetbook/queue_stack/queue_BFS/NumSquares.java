package leetbook.queue_stack.queue_BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * LC 279
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * @author meteora
 */

public class NumSquares {
    public static void main(String[] args) {
        System.out.println(numSquaresDP(5));

    }

    /**
     * BFS
     */
    public static int numSquaresBFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int level = 0;
        //生成每一层
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            //遍历每一层的每个节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //生成每一层的每个节点的子节点
                for (int j = 1; j < n; j++) {
                    int nodeValue = digit + j * j;
                    //当节点的值等于n时,直接返回
                    if (nodeValue == n) {
                        return level;
                    }
                    //如果节点的值大于n时,那么接下来的节点都会大于n,终止该循环
                    if (nodeValue > n) {
                        break;
                    }
                    //如果visited里面没有该节点,就加入队列和visited
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }

            }
        }
        return level;
    }

    /**
     * DP
     */
    public static int numSquaresDP(int n) {
        //创建一个n+1长度的数组,数组的第一个是0
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            //最坏的情况都是由1的平方组成
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                //动态规划公式
                //i - j * j反推之前需要最少需要几次
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
