package leetbook.BinarySearch.more;

/**
 * @author: Yihu4
 * @create: 2021-10-27 15:10
 */
public class TwoSum167 {
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
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l <= r){
            int x = numbers[l] + numbers[r];
            if (x == target){
                return new int[]{l + 1, r + 1};
            }else if (x < target){
                l++;
            }else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
    public int[] twoSumBinary(int[] numbers, int target) {
        for (int i = 0; i < numbers.length-1; i++) {
            int l = i + 1;
            int r = numbers.length-1;
            while (l <= r){
                int mid = l + r >>1;
                if (numbers[mid] == target- numbers[i]){
                    return new int[]{i+1,mid+1};
                }else if (numbers[mid] + numbers[i] > target){
                    r = mid -1;
                }else {
                    l = mid+1;
                }
            }
            
        }
        return new int[]{-1,-1};
    }
}
