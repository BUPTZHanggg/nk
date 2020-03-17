package array;

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
// 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
public class DuplicateNumberInArray {

    /**
     * 数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，当一个数字被访问过后，
     * 可以设置对应位上的数 - n，之后再遇到相同的数时，会发现对应位上的数已经小于0了，那么直接返回这个数即可
     *
     * +n有内存溢出的风险
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if (length == 0){
            duplication[0] = -1;
            return false;
        }
        for (int i = 0;i < length;i++){
            int index = numbers[i];
            if (index < 0){
                index = index + length;
            }
            if (numbers[index] < 0){
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] - length;
        }
        duplication[0] = -1;
        return false;
    }

    /**
     *
     *直接的想法就是构造一个容量为N的辅助数组B，原数组A中每个数对应B中下标，首次命中，B中对应元素+1。
     * 如果某次命中时，B中对应的不为0，说明，前边已经有一样数字了，那它就是重复的了。
     * 举例：A{1,2,3,3,4,5}，刚开始B是{0,0,0,0,0,0}，开始扫描A。
     * A[0] = 1  {0,1,0,0,0,0}
     * A[1] = 2 {0,1,1,0,0,0}
     * A[2] = 3 {0,1,1,1,0,0}
     * A[3] = 3 {0,1,1,2,0,0}，到这一步，就已经找到了重复数字。
     * A[4] = 4 {0,1,1,2,1,0}
     * A[5] = 5 {0,1,1,2,1,1}
     * 时间复杂度O（n），空间复杂度O（n），算法优点是简单快速，比用set更轻量更快，不打乱原数组顺序。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 1) {
            duplication[0] = -1;
            return false;
        }
        int[] tmp = new int[length];
        for (int i = 0;i < length;i++){
            int index = numbers[i];
            if (tmp[index] == 1){
                duplication[0] = index;
                return true;
            }
            tmp[index] = tmp[index] + 1;
        }
        duplication[0] = -1;
        return false;
    }

}
