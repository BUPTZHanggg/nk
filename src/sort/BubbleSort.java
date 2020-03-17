package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *
 * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出。
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] a = {1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] array){
        int len = array.length;
        boolean needNextLoop = true;
        for (int i = len - 1;i > 0 && needNextLoop;i--){
            needNextLoop = false;
            for (int j = 0;j < i;j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    needNextLoop = true;
                }
            }
        }
    }
}
