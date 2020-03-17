import string.StringPermutation;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {1,2,3,5,6};
        System.out.println(bs.search(a,0, a.length - 1, 4));
    }

    public int search(int[] array, int start, int end, int k){
        if (end < start) return -1;
        int mid = (start + end) >> 1;
        if (array[mid] > k)
            return search(array, start, mid - 1, k);
        if (array[mid] < k)
            return search(array, mid + 1, end, k);
        return mid;
    }
}
