package leetbook.SlidingWindow.window2.pro;

import org.junit.Test;

import java.util.HashMap;

/**
 * LC 1100
 * 返回String s中长度为k的不重复子数组
 * @author: Yihu4
 * @create: 2021-11-16 18:38
 */
public class FindK_LengthSubstringsWithNoRepeatedCharacters {
    @Test
    public void test(){
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));

    }
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k>s.length()){
            return 0;
        }
        int left = 0;
        // 当前窗口内长度
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
           if (map.containsKey(s.charAt(right))){
               // 如果重复,重新定义窗口
               right=map.get(s.charAt(right))+1;
               left= right;
               map.clear();

           }
           map.put(s.charAt(right),right);
           // 找到了
           if (right-left+1==k){
               // 缩小窗口左边界
               map.remove(s.charAt(left));
               left++;
               count++;
           }
        }
        return count;
    }
}
