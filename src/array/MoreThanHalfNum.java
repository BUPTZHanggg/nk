package array;


//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(MoreThanHalfNum_Solution(a));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int tmp = array[0];
        int count = 1;

        //如果存在某个数字出现次数超过数组的一半，则会找出这个数字
        //也可能返回一个出现次数不超过数组一般的数，因此需要再次判断
        for (int i = 1;i < array.length;i++){
            if (count == 0)
                tmp = array[i];
            if (array[i] == tmp){
                count++;
            }else {
                count--;
            }
        }

        count = 0;
        for (int i = 0;i < array.length;i++){
            if (array[i] == tmp)
                count++;
        }
        return count > array.length / 2 ? tmp : 0;
    }

}

