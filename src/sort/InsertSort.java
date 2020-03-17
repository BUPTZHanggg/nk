package sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {

    @Test
    public void test(){
        int[] a = {1,3,2,5,8,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
     *
     * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
     * 插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
     * @param array
     */
    public void sort(int[] array){
        int n = array.length;
        for (int i = 1;i < n;i++){
            for (int j = i;j > 0 && array[j] < array[j - 1];j--){
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
    }
}
