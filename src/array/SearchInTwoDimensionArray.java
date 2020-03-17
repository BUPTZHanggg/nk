package array;

import org.junit.Test;

public class SearchInTwoDimensionArray {

    @Test
    public void test(){
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(find2(8, a));
    }

    //===================================================================

    /**
     * 思路一：
     * 利用二维数组由上到下，由左到右递增的规律，
     * 那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     * 当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
     * 即col--；
     * 当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
     * 即row++；
     * @param target
     * @param array
     * @return
     */
    public boolean find1(int target, int [][] array){
        if (array == null || array[0] == null)
            return false;
        if (array.length == 0 || array[0].length == 0)
            return false;
        int col = array.length - 1;
        int row = 0;
        while (col >= 0 && row < array[0].length){
            if (array[row][col] == target){
                return true;
            }else if(array[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }

    //=================================================================

    /**
     * 思路二：
     * 把每一行看成有序递增的数组，
     * 利用二分查找，
     * 通过遍历每一行得到答案，
     * 时间复杂度是nlogn
     * @param target
     * @param array
     * @return
     */
    public boolean find2(int target, int [][] array){
        if (array == null || array[0] == null)
            return false;
        if (array.length == 0 || array[0].length == 0)
            return false;
        for (int i = 0;i < array.length;i++){
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high){
                int mid = (low + high) >> 1;
                if (array[i][mid] < target){
                    low = mid + 1;
                }else if(array[i][mid] > target){
                    high = mid - 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
