package leetbook.array_string.doublePointer;

/**
 * LC 167
 * @author: mete0ra
 * @create: 2021-08-25 09:07
 */
public class TwoSum167 {
    public static void main(String[] args) {

    }

    // 二分
    public static int[] twoSumBi(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 双指针
    public int[] twoSumDoublePointer(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        // 正序
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                // 小于目标则增加本身的值, 即左指针右移
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
