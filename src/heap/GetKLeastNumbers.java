package heap;

import org.junit.Test;

import java.util.ArrayList;

public class GetKLeastNumbers {

    @Test
    public void test(){
        int[] a = {1,3,4,6};
        System.out.println(GetLeastNumbers_Solution(a,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return res;

        //将前k个数构建成一个大顶堆
        for (int i = k / 2 - 1;i >= 0;i--){
            construct(input,i,k);
        }

        for (int i = k;i < input.length;i++){
            if (input[i] < input[0]){
                input[0] = input[i];
                construct(input,0,k);//因为之前已经是大顶堆了，所以直接从根节点往下重建大顶堆
            }
        }

        for (int i = 0;i < k;i++){
            res.add(input[i]);
        }
        return res;
    }

    //
    private void construct(int[] input, int i, int len) {
        int tmp = input[i];
        for (int k = 2 * i + 1;k < len;k = 2 * k + 1){
            if (k + 1 < len && input[k] < input [k + 1]){
                k++;
            }
            if (input[k] > tmp){
                input[i] = input[k];
                i = k;
            }else {
                break;
            }
        }
        input[i] = tmp;
    }

}
