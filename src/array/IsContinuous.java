package array;

import java.util.Arrays;

//扑克牌顺子
public class IsContinuous {

    public static void main(String[] args) {
        int [] a = {1,3,0};
        System.out.println(isContinuous(a));
    }

    /**
     * 排序数组
     * 遍历数组得到0的个数和空隙数目
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return false;
        int zeroCount = 0;
        int spaceCount = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0){
                zeroCount++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) return false;
            spaceCount += numbers[i + 1] - numbers[i] - 1;
        }
        return zeroCount >= spaceCount;
    }

}
