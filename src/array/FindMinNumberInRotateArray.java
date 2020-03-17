package array;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class FindMinNumberInRotateArray {

    @Test
    public void test(){
        int[] a = {1,1,1,0,1};
        System.out.println(minNumberInRotateArray(a));
    }

    /**
     * 用两个指针left,right分别指向数组的第一个元素和最后一个元素
     * 中间元素大于第一个元素，则中间元素位于前面的递增子数组，让第一个指针left指向中间元素
     * 中间元素小于第一个元素，则中间元素位于后面的递增子数组，让第二个指针right指向中间元素
     * 这样缩小寻找的范围
     *
     * 最终第一个指针将指向前面数组的最后一个元素，第二个指针指向后面数组中的第一个元素
     * 这就是循环的结束条件
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        return find(array, 0, array.length - 1);
    }

    private int find(int[] array, int left, int right) {
        if (left == right)
            return array[right];
        while (right - left > 1){
            int mid = (left + right) >> 1;
            if (array[left] == array[mid] && array[right] == array[mid]){
                // 无法确定中间元素是属于前面还是后面的递增子数组,只能顺序查找
                return iterate(array,left,right);
            }else if (array[left] <= array[mid]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return array[right];
    }

    private int iterate(int[] array, int left, int right) {
        int res = array[left];
        for (int i = left + 1;i <= right;i++){
            if (array[i] < res)
                return array[i];
        }
        return res;
    }

}
