package sort;

import org.junit.Test;

import java.util.Arrays;

public class ChooseSort {

    @Test
    public void test(){
        int[] a = {1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
     * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
     * 不断进行这样的操作，直到将整个数组排序。
     *
     * 选择排序需要N2/2 次比较和 N 次交换，它的运行时间与输入无关，
     * 这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
     * @param array
     */
    public void sort(int[] array){
        int len = array.length;
        for (int i = 0;i < array.length - 1;i++){
            int min = i;
            for (int j = i + 1;j < array.length;j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
}
