package sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void  test(){
        int[] a = {1};
        sort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] nums,int left,int right){
        if (right > left){
            int pivotIndex = partition(nums,left,right);
            sort(nums,left,pivotIndex - 1);
            sort(nums,pivotIndex + 1,right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
