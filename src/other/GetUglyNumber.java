package other;

import java.util.ArrayList;
import java.util.List;


//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class GetUglyNumber {

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        while (list.size() < index){
            int m2 = list.get(n2) * 2;
            int m3 = list.get(n3) * 3;
            int m5 = list.get(n5) * 5;
            int min = Math.min(Math.min(m2,m3),m5);
            list.add(min);
            if (m2 == min) n2++;
            if (m3 == min) n3++;
            if (m5 == min) n5++;
        }
        return list.get(index - 1);
    }



}
