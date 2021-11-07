package leetbook.SlidingWindow.window1;

/**
 * LC 1423
 * 从两头拿牌
 *
 * @author: Yihu4
 * @create: 2021-11-06 18:05
 */
public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        // 两边拿,只要使滑动窗口内的总和最小就行
        // 滑动窗口大小
        int size = cardPoints.length - k;
        // 求出所有和,最后减去滑动窗口里的和用
        int sum = 0;
        for (int i : cardPoints) {
            sum += i;
        }
        // 滑动窗口中的数和
        int cur = 0;
        for (int i = 0; i < size; i++) {
            cur += cardPoints[i];
        }
        int res = cur;
        for (int i = size; i < cardPoints.length; i++) {
            cur -= cardPoints[i - size];
            cur += cardPoints[i];
            // 滑动窗口最小值
            res = Math.min(res, cur);
        }
        return sum - res;
    }
}
