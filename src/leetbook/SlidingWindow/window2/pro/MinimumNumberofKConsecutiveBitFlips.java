package leetbook.SlidingWindow.window2.pro;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LC 995
 * 返回  翻转连续k个硬币  将所有元素变为1的最小次数
 *
 * @author: Yihu4
 * @create: 2021-11-13 17:00
 */
public class MinimumNumberofKConsecutiveBitFlips {
    @Test
    public void test() {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(minKBitFlips(nums, 3));
        int d = 2;
        d=d^1;
        System.out.println(d);
    }

    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;
        // 边界队列
        Deque<Integer> everyFlipRange = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            // 翻转的作用范围为翻转的起点+翻转距离k, 当列表头的值为这个值时,去除这个翻转,以免影响后面size的判断
            // peekFirst 检查头, pollFirst 删除头
            if (!everyFlipRange.isEmpty() && everyFlipRange.peekFirst() == i) everyFlipRange.pollFirst();
            // 第i个元素的实际值=原本值 + 当前翻转次数(即size的值)
            int cur = nums[i] + everyFlipRange.size();
            // 当前位置的实际值(原本值经过0-N次之后翻转的值)不为1的情况
            if (cur % 2 == 0) {
                // 实际值不为1, 就要进行翻转(offerLast)
                // 表示新的边界已经到达数组长度上线，该情况不可能成立，返回-1
                if (i + k > len) return -1;
                // 将[i, i + K]之间的元素翻转一次，将翻转的范围边界加入队列
                // offerLast 加入尾
                everyFlipRange.offerLast(i + k);
                cnt++;
            }
        }
        return cnt;
    }

    // 差分
    public int minKBitFlipsGreed(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] arr = new int[n + 1];
        for (int i = 0, cnt = 0; i < n; i++) {
            // count为翻转次数(会继承上次循环
            cnt += arr[i];
            // nums[i] + count为本身加上翻转次数
            if ((nums[i] + cnt) % 2 == 0) {
                if (i + k > n) return -1;
                // 差分法, 当需要对某一段 [l,r] 进行 +1 的时候，只需要 arr[l]++ 和 arr[r + 1]-- 即可
                arr[i + 1]++;
                arr[i + k]--;
                ans++;
            }
        }
        return ans;
    }
}
