package array;

import org.junit.Test;

import java.util.ArrayList;

public class FindTwoNumsInArrayWithSum {

    @Test
    public void test(){
        int[] a = {1,3,4,6};
        System.out.println(FindNumbersWithSum(a,7));
    }


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (array == null)
            return res;
        int pHead = 0;
        int pEnd = array.length - 1;
        while (pHead < pEnd){
            int sum1 = array[pEnd] + array[pHead];
            if (sum1 < sum){
                pHead++;
            }else if (sum1 > sum){
                pEnd--;
            }else {
                res.add(array[pHead]);
                res.add(array[pEnd]);
                return res;
            }
        }
        return res;
    }
}
