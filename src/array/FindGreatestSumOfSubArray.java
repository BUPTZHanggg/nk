package array;

import string.StringPermutation;

public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] a = {-1,-2};
        System.out.println(FindGreatestSumOfSubArray(a));
    }

    /**
     * 如果从i到j的子序列和为负，则该序列不能作为结果的前缀序列
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null)
            return 0;
        int maxSum = 0;
        int sum = 0;
        int maxNum = array[0];
        boolean che = false;//是否有元素大于等于0，用于解决都是负数的特殊情况
        for (int i = 0;i < array.length;i++){
            if (array[i] >= 0) che = true;
            if (array[i] > maxNum) maxNum = array[i];
            sum = sum + array[i];
            if (sum > maxSum){
                maxSum = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        if (che){
            return maxSum;
        }else {
            return maxNum;
        }
    }

}
