package leetbook.HashTable.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * LC 349
 * 两个数组交集
 *
 * @author: Yihu4
 * @create: 2021-09-14 20:12
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        // 要第二个哈希集合, 不然第一个要 remove
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int num : nums1) {
            hashSet1.add(num);
        }
        for (int num : nums2) {
                hashSet2.add(num);
        }
        // 取交集
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int num : hashSet1) {
            if (hashSet2.contains(num)) {
                tmp.add(num);
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    // LC 双指针
    public int[] intersectionLc(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
