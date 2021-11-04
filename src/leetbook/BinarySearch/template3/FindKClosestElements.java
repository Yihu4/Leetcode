package leetbook.BinarySearch.template3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 658
 * <p>
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * 如果距离相同,则取小的
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 * @author: Yihu4
 * @create: 2021-10-25 21:08
 */
public class FindKClosestElements {
    @Test
    public void test(){
        int[] ints = {1, 2, 3, 4, 5};
        findClosestElements(ints,4,-1);
    }
    // k nums 数量
    // x target 目标
    public List<Integer> findClosestElementsCompress(int[] arr, int k, int x) {
        int size = arr.length;
        // 从两端开始压缩, 定义头和尾
        int head = 0;
        int tail = size - 1;
        // 已经移除的元素数量
        int count = 0;
        while (size - count > k) {
            // 如果左距离比右距离大,则移除左
            if (x - arr[head] <= arr[tail] - x) {
                tail--;
            } else {
                // 如果右距离比左距离大,则移除右
                head++;
            }
            // 移除数量增加
            count++;
        }
        // 循环结束后得到head和tail
        List<Integer> integers = new ArrayList<>();
        for (int i = head; i < head + k; i++) {
            integers.add(arr[i]);
        }
        return integers;
    }

    // https://leetcode-cn.com/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        // 候选区间左边界
        int left = 0;
        // 候选区间右边界
        int right = size - k;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            // 向下取整
            int mid = (left + right) >> 1;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 目标与区间边界的距离
            // =等于号, 如果相等,往小的那边缩
            if (x - arr[mid] <= arr[mid + k] - x) {
                // 如果x距离左边界的距离小于距离右边界的距离,那么候选边界往左收缩,目的是让左右距离更加接近
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 数组转list
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
