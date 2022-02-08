package leetbook.array_string;

/**
 * LC 1446
 * @author: Yihu4
 * @create: 2021-12-01 09:49
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        if (s.length()==1){
            return 1;
        }
        int cur=1;
        int res =1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]==chars[i-1]){
                cur++;
                res = Math.max(res,cur);
            }else {
                cur=1;
            }
        }
        return res;
    }

    // 双指针
    public int maxPowerDoublePointer(String s) {
        int n = s.length();
        int ans = 1;
        for (int i = 0; i < n; ) {
            // 快指针
            int j = i;
            // 快指针跑
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            ans = Math.max(ans, j - i);
            // 更新慢指针位置
            i = j;
        }
        return ans;
    }
}
