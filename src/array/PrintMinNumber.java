package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
public class PrintMinNumber {

    @Test
    public void test(){
        int[] a = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }

    //--------------------------------------------------------------------------

    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {//自定义比较器
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "";
                String str2 = o2 + "";
                return (str1 + str2).compareTo(str2 + str1);
            }
        });
        String res = "";
        for (Integer num:list) {
            res = res + num;
        }
        return res;
    }

    //---------------------------------------------------------------------------

}
