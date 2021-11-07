package leetbook.array.init;

/**
 * LC 283
 *
 * @author: Yihu4
 * @create: 2021-11-04 14:33
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right <= nums.length - 1) {
            if (nums[right] == 0) {
                // 快指针遇到0就跳过
                right++;
            }else {
                // 直到快指针遇到的不是0,那么把当前快指针的值赋值给慢指针
                // 快指针继续前进
                nums[left++] =nums[right++];
            }
        }
        for (; left <= nums.length -1; left++) {
            nums[left] = 0;
        }
    }

    // 两种方法其实一样,都是把fast的元素赋值给slow, 交换法少了最后赋值0的步骤
    // 交换法
    public void moveZeroesSwap(int[] nums) {
        int slow=0;
        for(int fast =0;fast<nums.length;fast++){
            if(nums[fast]!=0){
                // 每当快指针不为0, 把fast对应的值,和slow对应的值(0)进行交换
                // 最后slow的值就是非0的个数
                swap(nums,slow,fast);
                slow++;
            }
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
