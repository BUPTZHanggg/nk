package array;

import org.junit.Test;

//统计一个数字在排序数组中出现的次数。
public class GetNumberOfK {

    @Test
    public void test(){
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        int[] a= {1,2,3,3,5,5,5,6};
        System.out.println(getNumberOfK.GetNumberOfK(a, 3));
    }


    //--------------------------------------------------------------------------

    /**
     * 排序数组自然想到二分查找
     * 先找到第一次出现的位置，再找到第二次出现的位置
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0)
            return 0;
        int first = getFirstIndex(array,0,array.length - 1,k);
        int last = getLastIndex(array,0,array.length - 1,k);
        if (first == -1)
            return 0;
        return last - first + 1;
    }

    private int getLastIndex(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (array[mid] > k){
            return getLastIndex(array,start,mid-1,k);
        }else if(array[mid] < k){
            return getLastIndex(array,mid+1,end,k);
        }else {
            if (mid + 1 <= end && array[mid + 1] == k){//判断是否最后一次出现
                return getLastIndex(array,mid + 1,end,k);
            }
            return mid;
        }
    }

    private int getFirstIndex(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (array[mid] > k){
            return getFirstIndex(array,start,mid-1,k);
        }else if(array[mid] < k){
            return getFirstIndex(array,mid+1,end,k);
        }else {
            if (mid - 1 >= start && array[mid - 1] == k){//判断是否第一次出现
                return getFirstIndex(array,start,mid-1,k);
            }
            return mid;
        }
    }

    //------------------------------------------------------------------------------

}

