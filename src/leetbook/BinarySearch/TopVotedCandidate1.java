package leetbook.BinarySearch;

/**
 * @author: Yihu4
 * @create: 2021-12-11 18:29
 */
public class TopVotedCandidate1 {
    private int[] times;
    private int[] ans;

    public TopVotedCandidate1(int[] persons, int[] times) {
        this.times = times;
        ans = new int[times.length];
        // 记录投票数
        int[] cnts = new int[persons.length];
        // cur 记录最大投票数下标
        int cur = persons[0];
        for (int i = 0; i < times.length; i++) {
            // 当前候选人投票数+1
            cnts[persons[i]]++;
            // 如果当前候选人的票数大于等于之前的
            // 大于等于可以解决最近投票问题
            if (cnts[persons[i]] >= cnts[cur])
                cur = persons[i];
            ans[i] = cur;
        }
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (times[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 如果要找的t大于等于对应下标的,就在ans中找对应下标的
        // 否则选取ans中小一格的
        return times[l] <= t ? ans[l] : ans[l - 1];
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate1 topVotedCandidate1 = new TopVotedCandidate1(persons, times);
        System.out.println(topVotedCandidate1.q(12));
    }
}
