package array;

public class InversePairs {

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();
        int[] a = {7,0,3,2};
        System.out.println(ip.InversePairs(a));
    }

//-------------------------------------------------------------------------

    /**
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     */

    private int count = 0;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        divideAndMerge(array,0,array.length - 1);
        return count;
    }

    private void divideAndMerge(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        divideAndMerge(array,start,mid);
        divideAndMerge(array,mid + 1,end);
        merge(array,start,mid,end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end){
            if (array[i] > array[j]){
                tmp[index++] = array[j++];
                count += mid - i + 1;
            }else {
                tmp[index++] = array[i++];
            }
        }
        while (i <= mid){
            tmp[index++] = array[i++];
        }
        while (j <= end){
            tmp[index++] = array[j++];
        }
        for (int k = 0;i < tmp.length;k++){
            array[start + k] = tmp[k];
        }
    }

//--------------------------------------------------------------------------

}
