package leetbook.analysis;

/**
 * LC 702
 * @author: Yihu4
 * @create: 2021-10-30 14:28
 */
public class SearchinaSortedArrayofUnknownSize {
    /*public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target){
            left = right;
            right *=2;
        }

        while(left < right){
            int mid = left + (right - left)/2;
            if (reader.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return reader.get(left) == target ? left : -1;
    }*/
}
