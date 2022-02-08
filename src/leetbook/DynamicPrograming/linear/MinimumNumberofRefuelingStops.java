package leetbook.DynamicPrograming.linear;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * LC 871
 *
 * @author: Yihu4
 * @create: 2021-12-10 21:11
 */
public class MinimumNumberofRefuelingStops {
    @Test
    public void test() {
        int[][] ints = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        int[][] ints2 = {{10, 100}};
        int[][] ints3 = {{25, 25}, {50, 25}, {75, 25}};
        //System.out.println(minRefuelStops(100, 10, ints));
        System.out.println(minRefuelStops(0, 10, ints));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        // dp[i]表示 加i次油能走的最远距离
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i) {
            // 去之前找
            for (int t = i; t >= 0; --t) {
                // 如果当前的dp[t]走的距离大于当前加油站station[i][0]位置
                if (dp[t] >= stations[i][0]) {
                    // 那么再加一次油的能走的距离为
                    // 比较不考虑当前i加油站与考虑当前i加油站的距离
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);
                }
            }
        }

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }

    // 贪心 + 优先队列
    public int minRefuelStopsPQ(int target, int startFuel, int[][] stations) {
        /**
         贪心 + 优先队列
         思路：不是只在加油站才能加油，而是只要现在需要油，并且之前有加油站，
         还没有加油，那么此时就可以加油，这样子一来，如果要使得加油次数最小，
         那么只要加油就加最多的油，为了保证时间效率，使用优先队列来维护前面的未用到的加油站的油量。
         */
        // 如果最初的燃料小于第一个加油站的距离，则无法到达返回-1
        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sum = startFuel;
        int ans = 0;
        for (int i = 0; i < stations.length; i++) {
            // 燃料小于下个某加油站的距离,就从储存的加油站中取出最大的加油
            while (sum < stations[i][0]) {
                // Integer包含null
                Integer ii = queue.poll();
                //队列内没有元素，说明燃料已经到不了最近的一个加油站，返回-1
                if (ii == null) {
                    return -1;
                }
                sum += ii;
                ++ans;
            }
            queue.offer(stations[i][1]);
        }
        // 加油站用完之后再判断一次终点
        while (sum < target) {
            // 所有的燃料加起来还没有target大时，让优先队列再出一个元素进行比较，
            // 只要有元素出队，说明已经进了一个加油站，ans加1
            Integer ii = queue.poll();
            if (ii == null) {
                return -1;
            }
            sum += ii;
            ++ans;
        }
        return ans;
    }

    public int minRefuelStopsJumpGame(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        if (stations.length == 0) {
            return -1;
        }
        // 当前位置能跳到的最远位置
        int[] dp = new int[stations.length + 1];
        // 到达i所需要的次数
        dp[0] = startFuel;
        // 起跳位置的最远距离
        int cur = startFuel;
        int count = 0;
        for (int i = 1; i <= stations.length; i++) {
            dp[i] = Math.max(dp[i - 1], cur + stations[i - 1][1]);
            // 如果当前位置大于起跳位置的最远距离(跳不到)
            if (stations[i - 1][0] > cur) {
                // 更新起跳位置的最远距离为当前的!!!前一格的!!!最远距离
                // 因为前一格在更新前必定跳的到,更新完之后前一格为新的起跳点
                cur = dp[i - 1];
                if (dp[i - 1] < stations[i - 1][0]) {
                    return -1;
                }
                // 增加次数
                count++;
            }
        }
        if (target > cur) {
            count++;
        }
        return count;
    }

}