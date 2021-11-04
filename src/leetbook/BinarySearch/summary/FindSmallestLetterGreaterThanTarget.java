package leetbook.BinarySearch.summary;

/**
 * LC 744
 * 找比目标字母大的最小字母
 * @author: Yihu4
 * @create: 2021-10-26 21:09
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right){
            // 向下取整
            int mid = left + right >> 1;
            if (letters[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        // 如果不是大于,则表示target大于数组中的所有,那么返回数组中的第一个元素
        return letters[left]>target? letters[left] : letters[0];
    }
}
