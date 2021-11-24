package leetbook.SlidingWindow.init;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * LC 215
 * @author: Yihu4
 * @create: 2021-11-06 15:33
 */
public class KthLargestElementinanArray {
    @Test
    public void test(){
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargestPriority(ints, 5));
    }
    public int findKthLargestDiy(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 第k大数的下标
        int target = len -k;
        int left = 0;
        int right = len - 1;
        while (true){
            int partition = partition(nums, left, right);
            if (partition == target){
                return nums[partition];
            }else if (partition > target){
                right = partition -1;
            }else {
                left = partition + 1;
            }
        }
    }

    // 在区间 nums[left..right] 区间执行 partition 操作
    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }
        int pivot = nums[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i]<pivot){
                // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                j++;
                swap(nums,j,i);
            }
        }
        // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
        // pivot的位置还在nums[left],j的位置在分界末尾
        swap(nums,left,j);
        // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // 优先队列
    // 队列长度不变,遍历数组最后剩下五个最大的,获取队列最前
    public int findKthLargestPriority(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topEle = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
