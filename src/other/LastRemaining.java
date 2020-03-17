package other;

import java.util.ArrayList;

//圆圈中最后剩下的数
public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }

    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
