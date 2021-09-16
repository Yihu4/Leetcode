package leetbook.HashTable.HashSet;

import java.util.HashSet;

/**
 * LC 202
 * @author: Yihu4
 * @create: 2021-09-14 20:57
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(newNumber(100));

    }
    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int next =newNumber(n);
        while (next!=1){
            // 如果死循环形成了, 那么一定会有重复,一旦发现重复,就不是快乐数
            if (!hashSet.add(next)){
                return false;
            }
            next = newNumber(next);
        }
        return true;
    }
    public static int newNumber(int n){
        int sum = 0;
        while (n>0){
            int temp = n % 10;
            sum += temp * temp;
            n = n/10;
        }
        return sum;
    }
}
