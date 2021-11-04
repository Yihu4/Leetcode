package leetbook.BinarySearch.more;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 349
 * @author: Yihu4
 * @create: 2021-10-27 11:21
 */
public class IntersectionofTwoArrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Arrays.sort(nums2);
            for (int i = 0; i < nums1.length; i++) {
                if (binarySearch(nums2,nums1[i])){
                    set.add(nums1[i]);
                }
            }
            int idx = 0;
            int[] res = new int[set.size()];
            for (int i :
                    set) {
                res[idx++] = i;
            }
            return res;

        }

        private boolean binarySearch(int[] nums, int target){
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = left + right >> 1;
                if (nums[mid] == target){
                    return true;
                }else if (nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return false;
        }

}
