package leetbook.BinarySearch;

import org.junit.Test;

import java.util.*;

/**
 * LC 911
 * @author: Yihu4
 * @create: 2021-12-11 16:50
 */
public class TopVotedCandidate {
    List<int[]> list = new ArrayList<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= val) {
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }
        }
    }
    public int q(int t) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid)[0] <= t) l = mid;
            else r = mid - 1;
        }
        return list.get(r)[0] <= t ? list.get(r)[1] : 0;
    }
    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(12));
    }
}

