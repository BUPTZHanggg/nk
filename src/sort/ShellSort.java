package sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSort {

    @Test
    public void test(){
        int[] a = {1,3,2,5,8,7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
     *
     * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
     *
     * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
     * @param array
     */
    public void sort(int[] array){
        int n = array.length;
        int h = 1;
        while (h < n / 3){
            h = h * 3 + 1; // 1, 4, 13, 40, ...
        }
        while (h >= 1){
            for (int i = h;i < n;i++){
                for (int j = i;j >= h && array[j] < array[j - h];j -= h){
                    int tmp = array[j];
                    array[j] = array[j - h];
                    array[j - h] = tmp;
                }
            }
            h = h / 3;
        }
    }
}
