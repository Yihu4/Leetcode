package leetbook.SlidingWindow.window2;

import org.junit.Test;

/**
 * LC 978
 *
 * @author: Yihu4
 * @create: 2021-11-13 15:14
 */
public class LongestTurbulentSubarray {
    @Test
    public void test(){
        int[] ints = {1,1,2};
        System.out.println(maxTurbulenceSize(ints));
    }
    public int maxTurbulenceSizeDP(int[] arr) {
        // 流向向上
        // 定义 up[i] 表示以位置 i 结尾的，并且 arr[i - 1] < arr[i] 的最长湍流子数组长度。
        int[] up = new int[arr.length];
        // 流向向下
        // 定义 down[i] 表示以位置 i 结尾的，并且 arr[i - 1] > arr[i] 的最长湍流子数组长度。
        int[] down = new int[arr.length];
        up[0]=1;
        down[0]=1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1]){
                // 当前流向向上
                up[i] = down[i-1]+1;
                down[i]=1;
            }else if (arr[i]< arr[i-1]){
                // 当前流向向下
                down[i] = up[i-1]+1;
                up[i] = 1;
            }else {
                // 相等
                up[i]=1;
                down[i]=1;
            }
            res = Math.max(res,Math.max(up[i],down[i]));
        }
        return res;
    }

    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int res = 2;

        int obey = 1;
        if (arr.length == 2) {
            if (arr[1]!=arr[0]){
                return arr.length;
            }else{
                return 1;
            }
        }
        if (arr.length==1){
            return 1;
        }
        if (arr[1]==arr[0]){
            res=1;
        }
        if (arr[1] > arr[0]) {
            obey = -1;
        }
        if (arr[1] == arr[0]) {
            left=1;
            obey = 0;
        }
        for (int right = 2; right < arr.length; right++) {
            if (arr[right]==arr[right-1]){
                // 如果相等
                left=right;
            }
            if ((arr[right] < arr[right - 1]) && obey==1) {
                // 继续顺流
                left = right-1;
            }
            if ((arr[right] > arr[right - 1] && obey==-1)) {
                // 继续逆流
                left = right-1;
            }
            // 更新流向
            if (arr[right] < arr[right - 1]){
                obey=1;
            }
            if (arr[right] > arr[right - 1]){
                obey=-1;
            }
            if (arr[right] == arr[right - 1]){
                obey=0;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
    public int maxTurbulenceSizeSince1(int[] arr) {
        if (arr.length<2){
            return arr.length;
        }
        boolean preObey=false;
        boolean curObey;
        int left = 0;
        int res = 1;
        for (int right = 1; right < arr.length; right++) {
            curObey = arr[right]<arr[right-1];
            if (curObey==preObey){
                // 当right = 1 的时候,不管之前是逆流还是顺流,left都为0
                left=right-1;
            }
            if (arr[right]==arr[right-1]){
                left=right;
            }
            res= Math.max(res,right-left+1);
            preObey=curObey;
        }
        return res;
    }
}
