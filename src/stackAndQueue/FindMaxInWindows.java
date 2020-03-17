package stackAndQueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FindMaxInWindows {

    @Test
    public void test(){
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a, 1));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (size == 0 || num == null || size > num.length)
            return res;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0;i < num.length;i++){
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();//从后面依次弹出队列中比当前num值小的元素，同时也能保证队列首元素为当前窗口最大值下标
            }
            deque.add(i);//把每次滑动的num下标加入队列
            int begin = i + 1 - size;
            if (begin > deque.peekFirst())
                deque.pollFirst();//如果当前窗口移出队首元素所在的位置，即队首元素坐标对应的num不在窗口中，需要弹出
            if (begin >= 0)
                res.add(num[deque.peekFirst()]);//当滑动窗口首地址i大于等于size时才开始写入窗口最大值
        }
        return res;
    }
}
