package sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void test(){
        int[] a = {2,8,5,4,6,8,9,1,0,7,5,3};
        sort(a,0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] array, int beginIndex, int endIndex){
        if (endIndex > beginIndex){
            int mid = (endIndex + beginIndex) >> 1;
            sort(array, beginIndex, mid);
            sort(array, mid + 1, endIndex);
            merge(array, beginIndex, endIndex);
        }
    }

    private void merge(int[] array, int beginIndex, int endIndex) {
        int[] tmp = new int[endIndex - beginIndex + 1];
        for (int i = beginIndex;i <= endIndex;i++){//把数组中的部分数据复制到tmp数组中
            tmp[i - beginIndex] = array[i];
        }
        int m = 0;
        int tmpMid = (tmp.length - 1) >> 1;
        int n = tmpMid + 1;
        //注意这个写法
        for (int i = beginIndex;i <= endIndex;i++){
            if (m > tmpMid){
                array[i] = tmp[n++];
            }else if (n >= tmp.length){
                array[i] = tmp[m++];
            }else if (tmp[m] >= tmp[n]){
                array[i] = tmp[n++];
            }else {
                array[i] = tmp[m++];
            }
        }
    }

}
