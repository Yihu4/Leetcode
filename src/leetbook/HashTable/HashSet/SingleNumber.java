package leetbook.HashTable.HashSet;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * LC 136
 * 除了某个元素只出现一次,其余都出现两次,找到那个一次的
 *
 * @author: Yihu4
 * @create: 2021-09-14 19:45
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(3^2);
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer num : nums) {
            if (!hashSet.add(num)){
                // 找到了就移除
                hashSet.remove(num);
            }
        }
        for (int i : hashSet) {
            // 返回哈希集合中的
            return i;
        }
        return 0;
    }
    
    // 位运算
    public int singleNumberBit(int[] nums){
        // 自己与自己异或的结果为 0,自己与 0 异或的结果为自己
        // 所以一轮异或下来之后重复的元素两两自我抵消,剩下的就是那个一个的
        int res = 0;
        for (int num :
                nums) {
            res ^= num;
        }
        return res;
    }
}
