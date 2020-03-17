package other;

import org.junit.Test;

import java.util.ArrayList;

//找出所有和为S的连续正数序列
public class FindContinuousSequence {

    @Test
    public void test(){
        System.out.println(FindContinuousSequence(100));
    }

    /**
     * 双指针，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int pHead = 1;
        int pEnd = 2;
        while (pHead < pEnd){
            int sum1 = (pHead + pEnd) * (pEnd - pHead + 1) / 2;
            if (sum1 < sum){
                pEnd++;
            }else if (sum1 > sum){
                pHead++;
            }else {
                ArrayList<Integer> nums = new ArrayList<Integer>();
                for (int i = pHead;i <= pEnd;i++){
                    nums.add(i);
                }
                res.add(nums);
                pEnd++;
            }
        }
        return res;
    }

}
