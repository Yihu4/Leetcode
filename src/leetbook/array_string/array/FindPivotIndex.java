package leetbook.array_string.array;

import java.util.Arrays;

/**
 * @author meteora
 */
public class FindPivotIndex {
    public static void main(String[] args) {

    }

    public static int find(int[] array) {
        int total = Arrays.stream(array).sum();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum * 2 + array[i] == total) {
                return i;
            }
            sum += array[i];
        }
        return -1;








        // 我的解
        /*int pivot = 0;
        for (int i = 0; i < array.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += array[j];
            }
            for (int k = i + 1; k < array.length; k++) {
                right += array[k];
            }
            if (left == right) {
                pivot = i;
                break;
            }
        }
        return pivot;*/
    }
}
