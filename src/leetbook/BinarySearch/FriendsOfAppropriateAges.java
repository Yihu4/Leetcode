package leetbook.BinarySearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * LC 825
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 *
 * @author: Yihu4
 * @create: 2021-12-27 10:22
 */
public class FriendsOfAppropriateAges {
    @Test
    public void test() {
        int[] ints = {16, 17, 18};
        System.out.println(numFriendRequests(ints));
    }

    public int numFriendRequests(int[] ages) {
        // 15岁可以开始找15岁的
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];
            int y = (int) (0.5 * x + 7);
            if (y >= x) {
                continue;
            }

            int begin = binarySearch(ages, y);
            int end = binarySearch(ages, x);
            // 如果右边那一个大于当前的,则往前一次
            if (ages[end] > x) {
                end = end - 1;
            }
            res += end - begin;
        }
        return res;
    }

    // 找目标右边一个
    private int binarySearch(int[] ages, int target) {
        int left = 0;
        int right = ages.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (ages[mid] <= target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 前缀和
    public int numFriendRequestsLC(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];

        for (int i : ages)
            numInAge[i]++;

        for (int i = 1; i <= 120; ++i)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        //到目前年龄的总数

        for (int i = 15; i <= 120; ++i) {
            if (numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i];
            //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }
}