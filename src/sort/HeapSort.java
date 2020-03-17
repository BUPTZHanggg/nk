package sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {

    @Test
    public void test(){
        int[] a = {1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] nums){

        //构建大顶堆
        for (int i = nums.length / 2 - 1;i >= 0;i--){
            construct(nums,i,nums.length);
        }

        //每次将堆的顶部与最后一个元素交换，然后重建大顶堆
        for (int i = nums.length - 1;i > 0;i--){
            swap(nums,0,i);
            construct(nums,0,i);
        }
    }

    //从下到上，从右到左重建大顶堆
    private void construct(int[] nums, int i, int length) {
        int tmp = nums[i];
        for (int j = 2 * i + 1; j < length; j++) {
            if (j + 1 < length && nums[j + 1] > nums[j]){
                j++;
            }
            if (nums[j] > tmp){
                nums[i] = nums[j];
                i = j;
            }else {
                break;
            }
        }
        nums[i] = tmp;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
