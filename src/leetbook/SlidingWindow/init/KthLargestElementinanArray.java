package leetbook.SlidingWindow.init;

import java.util.Random;

/**
 * LC 215
 * @author: Yihu4
 * @create: 2021-11-06 15:33
 */
public class KthLargestElementinanArray {
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
        // 从left之后开始
        for (int i = left + 1; i <= right; i++) {
            if (nums[i]<pivot){
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,left,j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
