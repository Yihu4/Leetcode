package leetbook.BinarySearch.template1;

/**
 * LC 374
 * @author: Yihu4
 * @create: 2021-10-20 19:11
 */
public class GuessGame {
    public int guessNumber(int n) {
        //如果不为0说明没有猜中
        int start=0;
        int end=n;
        int mid=0;
        int flag;
        while(start<=end){
            mid=start+(end-start)/2;
            /*flag=guess(mid);
            if(flag==1){
                start=mid+1;
            }else if(flag==-1){
                end=mid-1;
            }else{
                return mid;
            }*/
        }
        return -1;
    }
}
