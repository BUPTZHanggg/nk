import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianInStream {



    @Test
    public void test(){
        Insert(5);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
    }


    //思路：
    //为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
    //1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
    //2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
    PriorityQueue<Integer> minRootHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxRootHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    int count = 0;

    public void Insert(Integer num) {
        if ((count & 1) == 0){
            maxRootHeap.offer(num);
            Integer maxOfMaxRootHeap = maxRootHeap.poll();
            minRootHeap.offer(maxOfMaxRootHeap);
        }else {
            minRootHeap.offer(num);
            Integer minOfMinRootHeap = minRootHeap.poll();
            maxRootHeap.offer(minOfMinRootHeap);
        }
        count++;
    }

    public Double GetMedian() {
        int peekOfMinRootHeap = minRootHeap.isEmpty() ? 0 : minRootHeap.peek();
        int peekOfMaxRootHeap = maxRootHeap.isEmpty() ? 0 : maxRootHeap.peek();
        if ((count & 1) == 0){
            return (new Double(peekOfMaxRootHeap + peekOfMinRootHeap))/ 2;
        }else {
            return new Double(peekOfMinRootHeap);
        }
    }

}
